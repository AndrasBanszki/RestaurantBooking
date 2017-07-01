
package my.restaurant.booking.api.dao;

import java.util.List;
import my.restaurant.booking.api.model.Table;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface IBookingTablesDAO {
    
    public List<Table> getTablesOfRestaurant(long restaurant_id);
    
}
