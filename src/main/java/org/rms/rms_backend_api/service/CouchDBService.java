package org.rms.rms_backend_api.service;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Sanjay Bharathi
 */

@Service
public class CouchDBService {
    @Value("${couchdb.url}")
    private String couchDbUrl;

    @Value("${couchdb.username}")
    private String couchDbUsername;

    @Value("${couchdb.password}")
    private String couchDbPassword;

    public CouchDbClient getCouchDbClient() {
        CouchDbProperties properties = new CouchDbProperties()
                .setDbName("db_name")
                .setCreateDbIfNotExist(false)
                .setProtocol("http")
                .setHost(couchDbUrl)
                .setPort(5984)
                .setUsername(couchDbUsername)
                .setPassword(couchDbPassword)
                .setMaxConnections(100);

        return new CouchDbClient(properties);
    }
}
