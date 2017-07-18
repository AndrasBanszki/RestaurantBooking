
package my.restaurant.booking.api.dao;

import java.time.LocalDate;
import java.util.List;
import my.restaurant.booking.api.model.TableBooking;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface InterfaceTableBookingDAO {
    
    public List<TableBooking> getTableBookings(long restId, LocalDate date);
    
}
