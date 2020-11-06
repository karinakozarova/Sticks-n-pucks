package fontys.sem3.service;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import fontys.sem3.service.repository.*;

import java.net.URI;
import java.sql.*;

/**
 * This class deploys CustomApplicationConfig on a Grizzly server
 */
class Publisher {
    private static final URI BASE_URI = URI.create("http://localhost:9090/v1/");

    public static void main(String[] args) {
        CustomApplicationConfig customApplicationConfig = new CustomApplicationConfig();
        // create and start a grizzly server
        GrizzlyHttpServerFactory.createHttpServer(BASE_URI, customApplicationConfig, true);
    }
}
