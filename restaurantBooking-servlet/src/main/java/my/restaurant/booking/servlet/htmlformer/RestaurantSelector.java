

package my.restaurant.booking.servlet.htmlformer;

import java.util.List;
import java.util.StringJoiner;
import my.restaurant.booking.api.model.Restaurant;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class RestaurantSelector {
    
    public String make( List<Restaurant> restaurants, int selectedRestaurant ){
        
        StringJoiner sj = new StringJoiner( "</option>\n" +
                                            "<option value=\"", 
                                            "<select id=\"select2\" name=\"selectRestaurant\" >\n<option value=\"",
                                            "</option>\n</select>");
        
        for(Restaurant r : restaurants){
            if(r.getId() == selectedRestaurant){
                sj.add(String.valueOf(r.getId()) + "\" selected>" + r.getName());
            } else{
                sj.add(String.valueOf(r.getId()) + "\">" + r.getName());
            }
        }
        return sj.toString();
    }

}
