package org.rms.rms_backend_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.tomcat.util.json.JSONParser;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.modelmapper.ModelMapper;
import org.rms.rms_backend_api.model.Review;
import org.rms.rms_backend_api.repository.CouchDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanjay Bharathi
 */

@Service
public class CouchDBService {
    @Autowired
    CouchDBRepository couchDBRepository;
    @Autowired
    ModelMapper modelMapper;

    public List<Object> getAllDocuments() {
        CouchDbClient couchDbClient = couchDBRepository.getCouchDbClient();
        //NOTE: Specify the viewId as viewDocumentName/viewName
        return couchDbClient.view("new/new-view").query(Object.class);

    }

    public void saveDocuments(Review review) throws JsonProcessingException, JSONException {
        CouchDbClient couchDbClient = couchDBRepository.getCouchDbClient();
        Review newReview = modelMapper.map(review,Review.class);
        ObjectMapper mapper = new ObjectMapper();
        String e = mapper.writeValueAsString(review);
        JsonObject jsonObject = couchDbClient.getGson().fromJson(e,JsonObject.class);
        System.out.println(jsonObject);
        couchDbClient.save(jsonObject);

    }
}
