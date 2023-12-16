package org.rms.rms_backend_api.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Document;
import org.lightcouch.Response;
import org.rms.rms_backend_api.service.CouchDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
}
