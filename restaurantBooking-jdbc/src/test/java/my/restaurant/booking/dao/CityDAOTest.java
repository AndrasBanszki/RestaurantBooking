
package my.restaurant.booking.dao;


import java.util.List;
import my.restaurant.booking.api.model.City;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class CityDAOTest {
    
    public CityDAOTest() {
    }

    /**
     * Test of getAllCities method, of class CityDAO.
     */
    @Test
    public void testGetAllCities() {
        
        CityDAO cityDAO =  new CityDAO();
        List<City> cities = cityDAO.getAllCities();        
        
        assertFalse(cities.isEmpty());  
        assertEquals(3, cities.size());
    }

    /**
     * Test of getCityById method, of class CityDAO.
     */
    @Test
    public void testGetCityById() {
        
        CityDAO cityDAO =  new CityDAO();
        City city = cityDAO.getCityById(1);
        
        assertNotNull(city);  
        assertEquals("Budapest", city.getName());
    }
    
}
