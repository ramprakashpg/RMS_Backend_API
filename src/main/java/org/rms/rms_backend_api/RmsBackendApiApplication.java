package org.rms.rms_backend_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication()
public class RmsBackendApiApplication {

    public static void main(String[] args) {
        System.out.println("Server Started");
        SpringApplication.run(RmsBackendApiApplication.class, args);
    }

}
