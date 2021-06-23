package org.senlacourse.images.exception;

import org.senlacourse.images.api.exception.ApplicationException;
import org.senlacourse.images.api.exception.DtoValidationException;
import org.senlacourse.images.api.exception.ObjectNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ObjectNotFoundException.class})
    public ResponseEntity<Object> handleObjectNotFoundException(Exception ex) {
        return new ResponseEntity<>(
                ex, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({DtoValidationException.class})
    public ResponseEntity<Object> handleBadRequestBodyException(Exception ex) {
        return new ResponseEntity<>(
                ex, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<Object> handleServiceException(Exception ex) {
        return new ResponseEntity<>(
                ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}