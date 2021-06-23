package org.senlacourse.images.api.localstorage;

import org.senlacourse.images.api.exception.ApplicationException;
import org.senlacourse.images.api.exception.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IFileTransportService {

    String uploadFile(MultipartFile file) throws ApplicationException, ObjectNotFoundException;

    ResponseEntity<Object> downloadFile(String imgFileName) throws ObjectNotFoundException, ApplicationException;
}
