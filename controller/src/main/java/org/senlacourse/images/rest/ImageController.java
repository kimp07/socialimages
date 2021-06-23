package org.senlacourse.images.rest;

import lombok.RequiredArgsConstructor;
import org.senlacourse.images.api.service.IImageService;
import org.senlacourse.images.dto.ImageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

    private final IImageService imageService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getImageById(@PathVariable String id) {
        return imageService.getImage(id);
    }

    @PostMapping(value = "",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadImage(@RequestBody MultipartFile file) {
        ImageDto dto = imageService.saveImage(file);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(
                UriComponentsBuilder.fromPath("/images/{id}").buildAndExpand(dto.getId()).toUri());
        return new ResponseEntity<>(dto.getId(), responseHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteImage(@PathVariable String id) {
        imageService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
