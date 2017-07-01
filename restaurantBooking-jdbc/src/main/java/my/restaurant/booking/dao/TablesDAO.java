
package my.restaurant.booking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.restaurant.booking.api.dao.IBookingTablesDAO;
import my.restaurant.booking.api.model.Table;
import my.restaurant.booking.jdbc.MySqlConnector;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class TablesDAO extends MySqlConnector implements IBookingTablesDAO {
    
    private final static String QUERY = "select restaurant.table.id as tableId, restaurant.table.number_of_seats as seats, restaurant.table.restaurant_id as restId\n" +
                                        "from restaurant.table\n" +
                                        "where restaurant.table.restaurant_id = " ;

    @Override
    public List<Table> getTablesOfRestaurant(long restaurantId) {
        
        List<Table> tables = new LinkedList<>();
        
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(QUERY + String.valueOf(restaurantId) + ";") ) {
            
            while (rs.next()) {
                tables.add( new Table(rs.getLong("tableId"),rs.getInt("seats"),rs.getLong("restId")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tables;
    }

}
