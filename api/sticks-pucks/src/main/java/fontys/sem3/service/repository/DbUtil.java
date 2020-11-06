package fontys.sem3.service.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fontys.sem3.service.model.Account;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    /**
     * Get all the users in the system
     * @return list of users
     */
    public static List<Account> getUsers() {
        ResultSet result = null;
        Connection connection = null;
        PreparedStatement query = null;
        List<Account> users = new ArrayList<>();

        try {
            connection = DbUtil.getConnection();
            query = connection.prepareStatement("SELECT * FROM account");
            result = query.executeQuery();
            while (result.next()) {
                String dob = result.getString("date_of_birth");
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
                users.add(new Account(result.getInt("id"), result.getString("first_name") + result.getString("last_name"), result.getString("email"), date));
            }
        } catch (Exception e) {
            // Nothing
        } finally {
            if (query != null) try {
                query.close();
            } catch (Exception e) { /* ignored */ }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) { /* ignored */ }
        }
        return users;
    }
}
