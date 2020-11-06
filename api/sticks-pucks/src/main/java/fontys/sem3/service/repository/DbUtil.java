package fontys.sem3.service.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fontys.sem3.service.model.Account;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DbUtil {
    private static String dbUrl = "jdbc:mysql://studmysql01.fhict.local/dbi426146";
    private static String dbUsername = "dbi426146";
    private static String dbPassword = "1234";

    private DbUtil() {
        // hide the default constructor
    }

    public static Connection GetConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    public static List<Account> GetUsers() {
        ResultSet result = null;
        Connection connection = null;
        PreparedStatement query = null;
        List<Account> users = new ArrayList<>();

        try {
            connection = DbUtil.GetConnection();
            query = connection.prepareStatement("SELECT * FROM account");
            result = query.executeQuery();
            while (result.next()) {
                String dob = result.getString("date_of_birth");
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
                users.add(new Account(result.getInt("id"), result.getString("first_name") + result.getString("last_name"), result.getString("email"), date));
            }
            // System.out.println(users); // for debugging only
        } catch (Exception e) {
            System.err.println(e.toString());
        } finally {
            if (result != null) try {
                result.close();
            } catch (Exception e) { /* ignored */ }
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
