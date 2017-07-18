
package my.restaurant.booking.api.service;

import java.time.LocalDate;
import java.util.List;
import my.restaurant.booking.api.model.Booking;
import my.restaurant.booking.api.model.City;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.api.model.TableBooking;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface InterfaceBookingServices {
    

    public List<City> getCityes();
    public List<Restaurant> getRestaurants(long cityId);
    public List<TableBooking> getBookedTables(long restId, LocalDate date);
    
    public boolean checkNewBooking(long cityId, long restaurantId, long tableId, Booking booking);
    public boolean makeNewBooking(long cityId, long restaurantId, long tableId, Booking booking);
    
    
    
    
}
