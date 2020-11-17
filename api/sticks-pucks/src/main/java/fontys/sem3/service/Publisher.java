package fontys.sem3.service;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import fontys.sem3.service.repository.*;

import java.net.URI;
import java.sql.*;
import fontys.sem3.service.model.Account;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.client.ClientConfig;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

/**
 * This class deploys CustomApplicationConfig on a Grizzly server
 */
class Publisher {
    private static final URI BASE_URI = URI.create("http://localhost:9090/v1/");

    public static void main(String[] args) {
//        ResourceConfig resourceConfig = new ResourceConfig(Account.class);
//
//        resourceConfig.packages("fontys.sem3.service.resources;");
//        resourceConfig.register(AuthenticationFilter.class);

        CustomApplicationConfig customApplicationConfig = new CustomApplicationConfig();
        // create and start a grizzly server
        GrizzlyHttpServerFactory.createHttpServer(BASE_URI, customApplicationConfig);
    }
}
