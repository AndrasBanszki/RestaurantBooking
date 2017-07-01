
package my.restaurant.booking.api.service;

import my.restaurant.booking.api.model.Booking;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface IBookingServices {
    

    public boolean checkNewBooking(int cityId, int restaurantId, int tableId, Booking booking);
    public boolean makeNewBooking(int cityId, int restaurantId, int tableId, Booking booking);
    
    
    
    
}
