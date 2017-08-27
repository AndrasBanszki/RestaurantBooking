

package my.restaurant.booking.api.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import my.restaurant.booking.api.model.Booking;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface InterfaceBookingDAO {
    
    public List<Booking> getAllBooking();
    
    public Booking getBookingById(long id);
    
    public List<Booking> getBookingsByDate(LocalDate date);
    
    public long addNewBooking(LocalDateTime dateTime, int duration, int numberPeople );
    
    public void deleteBooking(long id);

}
