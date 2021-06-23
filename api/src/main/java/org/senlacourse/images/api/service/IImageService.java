package org.senlacourse.images.api.service;

import org.senlacourse.images.api.exception.ObjectNotFoundException;
import org.senlacourse.images.dto.ImageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {

    ImageDto findById(String id) throws ObjectNotFoundException;

    void delete(String id);

    ImageDto saveImage(MultipartFile file);

    ResponseEntity<Object> getImage(String id) throws ObjectNotFoundException;
}
