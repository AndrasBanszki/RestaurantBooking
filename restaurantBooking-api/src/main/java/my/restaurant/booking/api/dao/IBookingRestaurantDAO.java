
package my.restaurant.booking.api.dao;

import java.util.List;
import my.restaurant.booking.api.model.Restaurant;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface IBookingRestaurantDAO {
    
    public List<Restaurant> getRestaurants();
}
