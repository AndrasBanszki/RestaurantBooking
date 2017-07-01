
package my.restaurant.booking.api.dao;

import java.util.List;
import my.restaurant.booking.api.model.BookedTable;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface IBookedTablesDAO {
    
    public List<BookedTable> getBookedTables();
    
}
