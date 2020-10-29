package fontys.sem3.service;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.core.UriBuilder;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.io.IOException;
import java.net.URI;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 * This class deploys CustomApplicationConfig on a Grizzly server
 */
class Publisher {

    private static final URI BASE_URI = URI.create("http://localhost:9090/v1/");

    public static void main(String[] args) {

        try{
            String dbUrl = "jdbc:mysql://studmysql01.fhict.local/dbi426146";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection (dbUrl, "dbi426146", "1234");
            System.out.println("Success");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
            ResultSet result;
            try {
                PreparedStatement query = connection.prepareStatement("SELECT email FROM account");
                result = query.executeQuery();
                while( result.next() ) {
                    String name = result.getString("email");
                    System.out.println(name);
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        } catch(Exception e){
            System.out.println(e.toString());
        }

        try {
            CustomApplicationConfig customApplicationConfig = new CustomApplicationConfig();
            // create and start a grizzly server
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, customApplicationConfig, true);

            System.out.println("Hosting resources at " + BASE_URI.toURL());

        } catch (IOException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
