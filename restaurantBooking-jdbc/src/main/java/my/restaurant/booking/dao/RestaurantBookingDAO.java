
package my.restaurant.booking.dao;

import my.restaurant.booking.api.dao.InterfaceCityDAO;
import my.restaurant.booking.api.dao.InterfaceTablesDAO;
import my.restaurant.booking.api.dao.InterfaceRestaurantDAO;
import my.restaurant.booking.api.dao.InterfaceTableBookingDAO;


/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class RestaurantBookingDAO {
    
    private InterfaceCityDAO cityDao;
    private InterfaceRestaurantDAO restaurantDao;
    private InterfaceTablesDAO tablesDao;
    private InterfaceTableBookingDAO tableBookingDao;
    
    protected InterfaceCityDAO getCityDao(){
        if(this.cityDao == null){
            this.cityDao = new CityDAO();
        }
        return this.cityDao;
    }

    protected  InterfaceRestaurantDAO getRestaurantDao(){
        if(this.restaurantDao == null){
            this.restaurantDao = new RestaurantDAO();
        }
        return this.restaurantDao;
    }
    
    protected  InterfaceTablesDAO getTablesDao(){
        if(this.tablesDao == null){
            this.tablesDao = new TablesDAO();
        }
        return this.tablesDao;
    }
    
    protected  InterfaceTableBookingDAO getTableBookingDao(){
        if(this.tableBookingDao == null){
            this.tableBookingDao = new TableBookingDAO();
        }
        return this.tableBookingDao;
    }
    
}
