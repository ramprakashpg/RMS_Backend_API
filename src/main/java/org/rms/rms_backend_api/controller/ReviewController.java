package org.rms.rms_backend_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class ReviewController {
    @GetMapping("/")
    public ResponseEntity<Object> helloWorld() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }
}
