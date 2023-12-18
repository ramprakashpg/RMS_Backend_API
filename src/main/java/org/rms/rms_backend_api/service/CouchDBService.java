package org.rms.rms_backend_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.modelmapper.ModelMapper;
import org.rms.rms_backend_api.model.Review;
import org.rms.rms_backend_api.repository.CouchDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
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
        return couchDbClient.view("new/new-view").limit(100).query(Object.class);

    }

    public void saveDocuments(Review review) throws JsonProcessingException {
        CouchDbClient couchDbClient = couchDBRepository.getCouchDbClient();
        Review newReview = modelMapper.map(review, Review.class);
        ObjectMapper mapper = new ObjectMapper();
        String e = mapper.writeValueAsString(review);
        JsonObject jsonObject = couchDbClient.getGson().fromJson(e, JsonObject.class);
        System.out.println(jsonObject);
        couchDbClient.save(jsonObject);

    }

    public void postRandom(Review obj) {

        HttpURLConnection connection = new CouchDBRepository().getPOSTConnection();
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(obj);
        org.json.JSONObject jsonBody = new JSONObject().put("body", new JSONObject(json));

        try {
            // Write the JSON data to the request body
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonBody.toString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Request successful. Response: " + readResponse(connection));
            } else {
                System.out.println("Error response code: " + responseCode);
                System.out.println("Error response: " + readResponse(connection));
            }

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    private static String readResponse(HttpURLConnection connection) throws Exception {
        StringBuilder response = new StringBuilder();
        try (var reader = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        return response.toString();
    }
}
