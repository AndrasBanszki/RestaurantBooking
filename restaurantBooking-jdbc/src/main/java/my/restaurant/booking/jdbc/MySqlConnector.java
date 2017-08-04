
package my.restaurant.booking.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class MySqlConnector {
    
    private static final String URL = "jdbc:mysql://localhost:3306/restaurant?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    
    public Connection getConnection() throws SQLException {
        
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    public static PreparedStatement prepareStatement(Connection connection, String sql, PreparedStatementSetter setter) 
            throws SQLException {
            PreparedStatement ps = connection.prepareStatement(sql);
            setter.setValues(ps);
    return ps;
    }
}    

