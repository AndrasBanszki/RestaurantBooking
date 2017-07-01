
package my.restaurant.booking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.restaurant.booking.api.dao.IBookingCityDao;
import my.restaurant.booking.api.model.City;
import my.restaurant.booking.jdbc.MySqlConnector;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class CityDAO extends MySqlConnector implements IBookingCityDao{
    
    private final static String QUERY = "select city.id as cityId, city.name as cityName from city;";

    @Override
    public List<City> getCities() {
        
        List<City> cities = new LinkedList<>();
        
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(QUERY)) {
            
            while (rs.next()) {
                cities.add( new City(rs.getLong("cityId"),rs.getString("cityName")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cities; 
    }

}
