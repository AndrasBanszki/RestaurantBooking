
package my.restaurant.booking.main.demos;


import java.util.List;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.service.BookingServices;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class GetSelectedRestaurantDemo {
    
    public static void main(String[] args){
        BookingServices bs = new BookingServices();
        List<Restaurant> rs = bs.getRestaurants(1);
        for(Restaurant r : rs){
            System.out.println(r.toString());
        }
                
        
    }

}
