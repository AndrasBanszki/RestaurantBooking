package my.restaurant.booking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.jdbc.MySqlConnector;
import my.restaurant.booking.api.dao.InterfaceRestaurantDAO;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class RestaurantDAO extends MySqlConnector implements InterfaceRestaurantDAO {
    
    private final static String SELECT_ALL_QUERY = "SELECT restaurant.city_id AS cityId,\n" +
                                                   "       restaurant.id AS restId,\n" +
                                                   "       restaurant.name AS restName\n" +
                                                   "FROM restaurant;";
    
    private final static String SELECT_BY_ID_QUERY = "SELECT restaurant.city_id AS cityId,\n" +
                                                     "       restaurant.id AS restId,\n" +
                                                     "       restaurant.name AS restName\n" +
                                                     "FROM restaurant\n" +
                                                     "WHERE restaurant.id = ? ;";
    
    private final static String SELECT_BY_CITY_ID_QUERY = "SELECT restaurant.city_id AS cityId,\n" +
                                                          "       restaurant.id AS restId,\n" +
                                                          "       restaurant.name AS restName\n" +
                                                          "FROM restaurant\n" +
                                                          "WHERE restaurant.city_id = ? ;";
    
    @Override
    public List<Restaurant> getAllRestaurants(){
        
        List<Restaurant> restaurants = new LinkedList<>();
                
        try(Statement stmt  = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);) 
            {
            while (rs.next()) {
                restaurants.add( new Restaurant(rs.getLong("restId"), 
                                                rs.getString("restName"),
                                                rs.getLong("cityId")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return restaurants;
    }
    
     @Override
    public Restaurant getRestaurantById(long restaurantId) {
        
        Restaurant restaurant = null;
        
        try(PreparedStatement stmt = prepareStatement(this.getConnection(), 
                                                       SELECT_BY_CITY_ID_QUERY,
                                                       ps -> ps.setString(1, String.valueOf(restaurantId)));
            ResultSet rs = stmt.executeQuery();) 
            {
            if (rs.next()) {
                restaurant = new Restaurant(rs.getLong("restId"), 
                                            rs.getString("restName"), 
                                            rs.getLong("cityId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return restaurant;
    }
    
    @Override
    public List<Restaurant> getRestaurantByCity( long cityId) {
        
        if( cityId == 0 ) return new LinkedList<>();
        
        List<Restaurant> restaurants = new LinkedList<>();
        
        try(PreparedStatement stmt = prepareStatement(this.getConnection(), 
                                                       SELECT_BY_CITY_ID_QUERY,
                                                       ps -> ps.setString(1, String.valueOf(cityId)));
            ResultSet rs = stmt.executeQuery();) 
            {
            while (rs.next()) {
                restaurants.add( new Restaurant(rs.getLong("restId"), 
                                                rs.getString("restName"), 
                                                rs.getLong("cityId")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return restaurants;
    }


}
