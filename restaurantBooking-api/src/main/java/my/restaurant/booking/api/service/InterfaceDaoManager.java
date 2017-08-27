package my.restaurant.booking.api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import my.restaurant.booking.api.model.Booking;
import my.restaurant.booking.api.model.City;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.api.model.Table;
import my.restaurant.booking.api.model.TableBooking;


/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface InterfaceDaoManager {
    
    /*Booking*/
    public List<Booking> getAllBooking();
    public Booking getBookingById(long id);  
    public List<Booking> getBookingsByDate(LocalDate date);
    public long addNewBooking(LocalDateTime dateTime, int duration, int numberPeople );
    public void deleteBooking(long id);
    
    
    /*City*/
    public List<City> getAllCities();
    public City getCityById(long id);
    
    
    /*Restaurant*/
    public List<Restaurant> getAllRestaurants();
    public List<Restaurant> getRestaurantByCity(long cityId);
    public Restaurant getRestaurantById(long restaurantId);
    
    
    /*TableBooking*/
    public List<TableBooking> getAllTableBooking();
    public List<TableBooking> getTableBookingOfRestaurantByDate(long restId, LocalDate date);
    
    
    /*Table*/
    public List<Table> getAllTables();
    public Table getTableById(Long id);
    public List<Table> getTablesByRestId(Long restId);
    
   
}
