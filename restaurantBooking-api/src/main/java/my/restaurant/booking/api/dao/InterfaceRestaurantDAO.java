
package my.restaurant.booking.api.dao;

import java.util.List;
import my.restaurant.booking.api.model.Restaurant;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface InterfaceRestaurantDAO {
    
    public List<Restaurant> getRestaurants(long cityId);
}
