package com.javamongodb.webapp.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyResourceConfig extends ResourceConfig {
    public JerseyResourceConfig() {
        super();
        packages(true, "com.javamongodb.webapp.resource");
    }
}