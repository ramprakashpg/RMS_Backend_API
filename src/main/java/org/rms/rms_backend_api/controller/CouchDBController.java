package org.rms.rms_backend_api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.rms.rms_backend_api.model.Review;
import org.rms.rms_backend_api.service.CouchDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author Sanjay Bharathi
 */

@RestController
@RequestMapping("/api/documents")
public class CouchDBController {

    @Autowired
    private CouchDBService couchDbService;


    @GetMapping
    public List<Object> getAllDocuments() {
        return couchDbService.getAllDocuments();
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity.BodyBuilder saveDocument(@RequestBody Review review) throws JsonProcessingException, JSONException {
        couchDbService.saveDocuments(review);
        return ResponseEntity.ok();
    }
}
