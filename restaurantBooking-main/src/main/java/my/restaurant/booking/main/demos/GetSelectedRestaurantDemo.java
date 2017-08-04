
package my.restaurant.booking.main.demos;


import java.util.List;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.service.DAOManager;


/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class GetSelectedRestaurantDemo {
    
    public static void main(String[] args){
        DAOManager daoManager = new DAOManager();
        List<Restaurant> rest = daoManager.getAllRestaurants();
        for(Restaurant r : rest){
            System.out.println("Restaurant name: " +r.getName());
        }
                
        
    }

}
