

package my.restaurant.booking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.restaurant.booking.api.dao.IBookingRestaurantDAO;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.jdbc.MySqlConnector;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class RestaurantDAO extends MySqlConnector implements IBookingRestaurantDAO {

    private final static String QUERY = "select restaurant.city_id as cityId, restaurant.id as restId, restaurant.name as restName\n" +
                                        "from restaurant\n" +
                                        "where restaurant.city_id = ";
    
    @Override
    public List<Restaurant> getRestaurants(long cityId) {
        
        List<Restaurant> restaurants = new LinkedList<>();
        
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(QUERY + String.valueOf(cityId) + ";" ) ) {
            
            while (rs.next()) {
                restaurants.add( new Restaurant(rs.getLong("cityId"), rs.getString("restName"), rs.getLong("cityId")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return restaurants;
    }

}
