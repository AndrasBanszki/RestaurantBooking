
package my.restaurant.booking.service;

import java.time.LocalDate;
import java.util.List;
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
import my.restaurant.booking.dao.BookingDAO;
import my.restaurant.booking.dao.CityDAO;
import my.restaurant.booking.dao.RestaurantDAO;
import my.restaurant.booking.dao.TableBookingDAO;
import my.restaurant.booking.dao.TablesDAO;


/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class DAOManager implements InterfaceDaoManager{
    
    private InterfaceBookingDAO bookingDao;
    private InterfaceCityDAO cityDao;
    private InterfaceRestaurantDAO restaurantDao;
    private InterfaceTableBookingDAO tableBookingDao;
    private InterfaceTablesDAO tablesDao;
    
    private InterfaceBookingDAO getBookingDao(){
        if(this.bookingDao == null){
            this.bookingDao = new BookingDAO();
        }
        return this.bookingDao;
    }
    
    private InterfaceCityDAO getCityDao(){
        if(this.cityDao == null){
            this.cityDao = new CityDAO();
        }
        return this.cityDao;
    }

    private  InterfaceRestaurantDAO getRestaurantDao(){
        if(this.restaurantDao == null){
            this.restaurantDao = new RestaurantDAO();
        }
        return this.restaurantDao;
    }
    
    private  InterfaceTableBookingDAO getTableBookingDao(){
        if(this.tableBookingDao == null){
            this.tableBookingDao = new TableBookingDAO();
        }
        return this.tableBookingDao;
    }
    
    private  InterfaceTablesDAO getTablesDao(){
        if(this.tablesDao == null){
            this.tablesDao = new TablesDAO();
        }
        return this.tablesDao;
    }

    @Override
    public List<Booking> getAllBooking() {
        return this.getBookingDao().getAllBooking();
    }

    @Override
    public Booking getBookingById(long id) {
        return this.getBookingDao().getBookingById(id);
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date) {
        return this.getBookingDao().getBookingsByDate(date);
    }

    @Override
    public List<City> getAllCities() {
        return this.getCityDao().getAllCities();
    }

    @Override
    public City getCityById(long id) {
        return this.getCityDao().getCityById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return this.getRestaurantDao().getAllRestaurants();
    }

    @Override
    public List<Restaurant> getRestaurantByCity(long cityId) {
        return this.getRestaurantDao().getRestaurantByCity(cityId);
    }

    @Override
    public Restaurant getRestaurantById(long restaurantId) {
        return this.getRestaurantDao().getRestaurantById(restaurantId);
    }

    @Override
    public List<TableBooking> getAllTableBooking() {
        return this.getTableBookingDao().getAllTableBooking();
    }

    @Override
    public List<TableBooking> getTableBookingOfRestaurantByDate(long restId, LocalDate date) {
        return this.getTableBookingDao().getTableBookingOfRestaurantByDate(restId, date);
    }

    @Override
    public List<Table> getAllTables() {
        return this.getTablesDao().getAllTables();
    }

    @Override
    public Table getTableById(Long id) {
        return this.getTablesDao().getTableById(id);
    }

    @Override
    public List<Table> getTablesByRestId(Long restId) {
        return this.getTablesDao().getTablesByRestId(restId);
    }

    
}
