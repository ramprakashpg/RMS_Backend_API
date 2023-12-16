package org.rms.rms_backend_api.service;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.rms.rms_backend_api.repository.CouchDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sanjay Bharathi
 */

@Service
public class CouchDBService {
    @Autowired
   CouchDBRepository couchDBRepository;

    public List<Object> getAllDocuments() {
        CouchDbClient couchDbClient = couchDBRepository.getCouchDbClient();
        //NOTE: Specify the viewId as viewDocumentName/viewName
        return couchDbClient.view("new/new-view").query(Object.class);

    }

}
