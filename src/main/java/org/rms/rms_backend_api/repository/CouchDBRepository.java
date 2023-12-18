package org.rms.rms_backend_api.repository;

import org.json.JSONObject;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

/**
 * @author Ramprakash PG
 */
@Repository
public class CouchDBRepository {
    @Value("${couchdb.url}")
    private String couchDbUrl;

    @Value("${couchdb.username}")
    private String couchDbUsername;

    @Value("${couchdb.password}")
    private String couchDbPassword;

    public CouchDbClient getCouchDbClient() {
        CouchDbProperties properties = new CouchDbProperties()
                .setDbName("hello")
                .setCreateDbIfNotExist(false)
                .setProtocol("http")
                .setHost(couchDbUrl)
                .setPort(5984)
                .setUsername(couchDbUsername)
                .setPassword(couchDbPassword)
                .setMaxConnections(100);
        return new CouchDbClient(properties);
    }

    public HttpURLConnection getPOSTConnection(){
        try {
            URL url = new URL("http://192.168.1.241:5984/testing");

            // Create connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set up the connection for a POST request
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Set up basic authentication
            String credentials = "admin" + ":" + "admin";
            String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
            return connection;
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
        return null;
    }
}
