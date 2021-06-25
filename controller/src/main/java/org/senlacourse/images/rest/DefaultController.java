package org.senlacourse.images.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping
    public ResponseEntity<String> validPing() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}