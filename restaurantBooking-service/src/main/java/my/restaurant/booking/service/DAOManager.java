package my.restaurant.booking.service;

import java.time.LocalDate;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import my.restaurant.booking.api.dao.InterfaceBookingDAO;
import my.restaurant.booking.api.dao.InterfaceCityDAO;
import my.restaurant.booking.api.dao.InterfaceTablesDAO;
import my.restaurant.booking.api.dao.InterfaceRestaurantDAO;
import my.restaurant.booking.api.dao.InterfaceTableBookingDAO;
import my.restaurant.booking.api.model.Booking;
import my.restaurant.booking.api.model.City;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.api.model.Table;
import my.restaurant.booking.api.model.TableBooking;
import my.restaurant.booking.api.service.InterfaceDaoManager;


/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
@RequestScoped
public class DAOManager implements InterfaceDaoManager{
    
    @Inject private InterfaceBookingDAO bookingDao;
    @Inject private InterfaceCityDAO cityDao;
    @Inject private InterfaceRestaurantDAO restaurantDao;
    @Inject private InterfaceTableBookingDAO tableBookingDao;
    @Inject private InterfaceTablesDAO tablesDao;


    @Override
    public List<Booking> getAllBooking() {
        return this.bookingDao.getAllBooking();
    }

    @Override
    public Booking getBookingById(long id) {
        return this.bookingDao.getBookingById(id);
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date) {
        return this.bookingDao.getBookingsByDate(date);
    }

    @Override
    public List<City> getAllCities() {
        return this.cityDao.getAllCities();
    }

    @Override
    public City getCityById(long id) {
        return this.cityDao.getCityById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return this.restaurantDao.getAllRestaurants();
    }

    @Override
    public List<Restaurant> getRestaurantByCity(long cityId) {
        return this.restaurantDao.getRestaurantByCity(cityId);
    }

    @Override
    public Restaurant getRestaurantById(long restaurantId) {
        return this.restaurantDao.getRestaurantById(restaurantId);
    }

    @Override
    public List<TableBooking> getAllTableBooking() {
        return this.tableBookingDao.getAllTableBooking();
    }

    @Override
    public List<TableBooking> getTableBookingOfRestaurantByDate(long restId, LocalDate date) {
        return this.tableBookingDao.getTableBookingOfRestaurantByDate(restId, date);
    }

    @Override
    public List<Table> getAllTables() {
        return this.tablesDao.getAllTables();
    }

    @Override
    public Table getTableById(Long id) {
        return this.tablesDao.getTableById(id);
    }

    @Override
    public List<Table> getTablesByRestId(Long restId) {
        return this.tablesDao.getTablesByRestId(restId);
    }

    
}
