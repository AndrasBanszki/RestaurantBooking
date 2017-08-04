
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
     * Test of getAllRestaurants method, of class RestaurantDAO.
     */
    @Test
    public void testGetAllRestaurants() {
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        
        List<Restaurant> restaurants = restaurantDAO.getAllRestaurants();
        
        assertEquals(6, restaurants.size());
    }

    /**
     * Test of getRestaurantByCity method, of class RestaurantDAO.
     */
    @Test
    public void testGetRestaurantByCity() {
        RestaurantDAO restaurantDAO = new RestaurantDAO();
        
        List<Restaurant> restaurants = restaurantDAO.getRestaurantByCity(1);
        
        assertFalse(restaurants.isEmpty());  
        assertEquals(3, restaurants.size());
    }
    
}
