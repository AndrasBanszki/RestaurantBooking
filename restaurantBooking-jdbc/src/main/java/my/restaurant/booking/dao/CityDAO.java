package my.restaurant.booking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.restaurant.booking.api.model.City;
import my.restaurant.booking.jdbc.MySqlConnector;
import my.restaurant.booking.api.dao.InterfaceCityDAO;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class CityDAO extends MySqlConnector implements InterfaceCityDAO{
    
    private final static String QUERY_ALL = "SELECT city.id AS cityId, city.name AS cityName " +
                                            "FROM city;";
    
    private final static String QUERY_ID = "SELECT city.id AS cityId, city.name AS cityName " +
                                           "FROM city " +
                                           "WHERE city.id = ? ;" ;
    
    @Override
    public List<City> getAllCities() {
        
        List<City> cities = new LinkedList<>();
                
        try( Statement stmt  = this.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(QUERY_ALL); ) 
            {
            while (rs.next()) {
                cities.add( new City(rs.getLong("cityId"),
                                     rs.getString("cityName")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cities;
    }

    @Override
    public City getCityById( long id) {
        
        City city = null;
        
        try(PreparedStatement stmt = prepareStatement(this.getConnection(),
                                                      QUERY_ID, 
                                                      ps -> ps.setString(1, String.valueOf(id)));
            ResultSet rs = stmt.executeQuery(); ) 
            {
            if (rs.next()) {
                city =  new City(rs.getLong("cityId"),
                                 rs.getString("cityName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return city;
    }
}
