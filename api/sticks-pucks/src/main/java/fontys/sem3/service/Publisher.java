package fontys.sem3.service;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.grizzly.http.server.HttpServer;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 * This class deploys CustomApplicationConfig on a Grizzly server
 */
class Publisher {
    private static String dbUrl = "jdbc:mysql://studmysql01.fhict.local/dbi426146";

    private static final URI BASE_URI = URI.create("http://localhost:9090/v1/");

    private static String dbPassword = "1234";

    public static void main(String[] args) {
        ResultSet result = null;
        Connection connection = null;
        PreparedStatement query = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection (Publisher.dbUrl, "dbi426146", dbPassword);
            System.out.println("Successfully connected to the db");
            query = connection.prepareStatement("SELECT email FROM account");
            result = query.executeQuery();
            while( result.next() ) {
                String name = result.getString("email");
                System.out.println(name);
            }
        } catch(Exception e){
            System.err.println(e.toString());
        } finally {
            if (result != null ) try { result.close(); } catch (Exception e) { /* ignored */ }
            if (query != null ) try { query.close(); } catch (Exception e) { /* ignored */ }
            if (connection != null ) try { connection.close(); } catch (Exception e) { /* ignored */ }
        }

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
