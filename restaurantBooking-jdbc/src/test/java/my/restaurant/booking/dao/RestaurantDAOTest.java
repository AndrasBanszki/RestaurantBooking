
package my.restaurant.booking.dao;

import java.util.List;
import my.restaurant.booking.api.model.Restaurant;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class RestaurantDAOTest {

    /**
     * Test of getRestaurants method, of class RestaurantDAO.
     */
    @Test
    public void testGetRestaurants() {
        
        List<Restaurant> restaurants = new RestaurantDAO().getRestaurants(1);        
        
        assertFalse(restaurants.isEmpty());  
        assertEquals(3, restaurants.size());
    }
    
}
