package org.rms.rms_backend_api.controller;

import org.rms.rms_backend_api.model.Review;
import org.rms.rms_backend_api.service.CouchDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author Sanjay Bharathi
 */

@RestController
@CrossOrigin
@RequestMapping("/api/documents")
public class CouchDBController {

    @Autowired
    private CouchDBService couchDbService;


    @GetMapping
    public List<Object> getAllDocuments() {
        return couchDbService.getAllDocuments();
    }
    @PostMapping
    public ResponseEntity<String> handlePostRequest(@RequestBody Review requestBody) {
        try {
            couchDbService.postRandom(requestBody);
            return ResponseEntity.ok("Data written to DB");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing Request");
        }
    }
}
