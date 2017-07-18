

package my.restaurant.booking.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import my.restaurant.booking.api.model.Booking;
import my.restaurant.booking.api.model.City;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.api.model.TableBooking;
import my.restaurant.booking.dao.RestaurantBookingDAO;
import my.restaurant.booking.api.service.InterfaceBookingServices;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class BookingServices extends RestaurantBookingDAO implements InterfaceBookingServices{
   

    @Override
    public List<City> getCityes() {
        return this.getCityDao().getCities();
    }

    @Override
    public List<Restaurant> getRestaurants(long cityId) {
        return this.getRestaurantDao().getRestaurants(cityId);
    }

    @Override
    public List<TableBooking> getBookedTables(long restId, LocalDate date) {
        return this.getTableBookingDao().getTableBookings(restId, date);
    }

    @Override
    public boolean checkNewBooking(long cityId, long restaurantId, long tableId, Booking booking) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean makeNewBooking(long cityId, long restaurantId, long tableId, Booking booking) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
