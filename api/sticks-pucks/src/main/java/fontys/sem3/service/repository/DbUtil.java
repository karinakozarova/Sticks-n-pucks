package fontys.sem3.service.repository;

import java.sql.*;

/**
 * Class for databates utilities
 */
public class DbUtil {
    /**
     * URL for the database
     */
    private static String dbUrl = "jdbc:mysql://studmysql01.fhict.local/dbi426146";

    /**
     * USername to connect to the database
     */
    private static String dbUsername = "dbi426146";

    /**
     * Constructor
     */
    private DbUtil() {
        // hide the default constructor
    }

    /**
     * Get a Connection object
     * @return Connection object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(dbUrl, dbUsername, "1234");
    }
}
