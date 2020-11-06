package fontys.sem3.service;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.grizzly.http.server.HttpServer;
import fontys.sem3.service.repository.*;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 * This class deploys CustomApplicationConfig on a Grizzly server
 */
class Publisher {
    private static final URI BASE_URI = URI.create("http://localhost:9090/v1/");

    public static void main(String[] args) {
        try {
            CustomApplicationConfig customApplicationConfig = new CustomApplicationConfig();
            // create and start a grizzly server
            GrizzlyHttpServerFactory.createHttpServer(BASE_URI, customApplicationConfig, true);
            System.out.println("Hosting resources at " + BASE_URI.toURL());
        } catch (IOException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
