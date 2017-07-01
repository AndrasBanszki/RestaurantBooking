package my.restaurant.booking.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.restaurant.booking.jdbc.MySqlConnector;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection con = new MySqlConnector().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("fuck you");
        }
        System.out.println("ok sikeresen lefutott");
    }
}
