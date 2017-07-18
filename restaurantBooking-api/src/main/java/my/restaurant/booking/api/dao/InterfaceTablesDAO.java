
package my.restaurant.booking.api.dao;

import java.util.Date;
import java.util.List;
import my.restaurant.booking.api.model.Table;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface InterfaceTablesDAO {
    
    public List<Table> getBookedTables(long restaurantId, Date date );
    
}
