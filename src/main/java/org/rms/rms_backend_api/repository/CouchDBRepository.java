package org.rms.rms_backend_api.repository;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

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
                .setHost("localhost")
                .setPort(5984)
                .setUsername(couchDbUsername)
                .setPassword(couchDbPassword)
                .setMaxConnections(100);
        return new CouchDbClient(properties);
    }
}
