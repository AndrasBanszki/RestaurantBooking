
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
     * Test of getCities method, of class CityDAO.
     */
    @Test
    public void testGetCities() {

        List<City> cities = new CityDAO().getCities();        
        
        assertFalse(cities.isEmpty());  
        assertEquals(3, cities.size());
    }
    
}
