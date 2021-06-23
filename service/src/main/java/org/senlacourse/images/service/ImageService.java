package org.senlacourse.images.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.senlacourse.images.api.exception.ObjectNotFoundException;
import org.senlacourse.images.api.localstorage.IFileTransportService;
import org.senlacourse.images.api.service.IImageService;
import org.senlacourse.images.domain.Image;
import org.senlacourse.images.dto.ImageDto;
import org.senlacourse.images.mapstruct.ImageDtoMapper;
import org.senlacourse.images.repository.ImageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Log4j
public class ImageService implements IImageService {

    private final ImageRepository imageRepository;
    private final ImageDtoMapper imageDtoMapper;
    private final IFileTransportService fileTransportService;

    @Override
    public ImageDto findById(String id) throws ObjectNotFoundException {
        return imageDtoMapper.fromModel(
                imageRepository.findById(id).<ObjectNotFoundException>orElseThrow(() -> {
                    ObjectNotFoundException e = new ObjectNotFoundException();
                    log.error(e.getMessage(), e);
                    throw e;
                }));
    }

    @Override
    public void delete(String id) {
        imageRepository.deleteById(id);
    }

    private ImageDto save(String imageFileName) {
        LocalDateTime now = LocalDateTime.now();
        return imageDtoMapper.fromModel(
                imageRepository.save(
                        new Image()
                                .setCreatedDate(now)
                                .setFileName(imageFileName)));
    }

    @Override
    public ImageDto saveImage(MultipartFile file) {
        String fileName = fileTransportService.uploadFile(file);
        return save(fileName);
    }

    @Override
    public ResponseEntity<Object> getImage(String id) throws ObjectNotFoundException {
        ImageDto dto = findById(id);
        return fileTransportService.downloadFile(dto.getFileName());
    }
}
