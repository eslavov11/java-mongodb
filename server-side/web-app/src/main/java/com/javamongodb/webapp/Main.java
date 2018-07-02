package com.javamongodb.webapp;

import com.javamongodb.webapp.config.GrizzlyServerConfigurer;
import com.javamongodb.webapp.config.JerseyResourceConfig;
import com.javamongodb.webapp.config.ServerSignatureFilter;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.grizzly2.httpserver.internal.LocalizationMessages;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.IOException;
import java.net.URI;

public class Main extends WebApp {
    public static void main(String[] args) throws Exception {
        startServer();
        Thread.currentThread().join();
    }

    private static final URI BASE_URI = URI.create("http://0.0.0.0:8080/");

    private static void startServer() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.scan("com.*");
        ctx.refresh();

        JerseyResourceConfig jerseyConfig = ctx.getBean(JerseyResourceConfig.class);
        GrizzlyServerConfigurer grizzlyConfigurer = ctx.getBean(GrizzlyServerConfigurer.class);

        ServerSignatureFilter signatureFilter = ctx.getBean(ServerSignatureFilter.class);
        jerseyConfig.register(signatureFilter);

        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, jerseyConfig, false);
        grizzlyConfigurer.configure(server);

        try {
            server.start();
        } catch (IOException ex) {
            server.shutdownNow();
            throw new RuntimeException(LocalizationMessages.FAILED_TO_START_SERVER(ex.getMessage()), ex);
        }
    }
}