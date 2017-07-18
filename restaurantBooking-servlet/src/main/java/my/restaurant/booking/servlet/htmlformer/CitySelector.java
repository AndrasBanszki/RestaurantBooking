

package my.restaurant.booking.servlet.htmlformer;

import java.util.List;
import java.util.StringJoiner;
import my.restaurant.booking.api.model.City;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class CitySelector {
    
    public String make(List<City> cities, int selectedCity){
        StringJoiner sj = new StringJoiner( "</option>\n" +
                                            "<option value=\"", 
                                            "<select id=\"select\" name=\"selectCity\" >\n<option value=\"",
                                            "</option>\n</select>");
        
        for(City c : cities){
            if(c.getId() == selectedCity){
                sj.add(String.valueOf(c.getId()) + "\" selected>" + c.getName());
            } else{
                sj.add(String.valueOf(c.getId()) + "\">" + c.getName());
            }
        }
        return sj.toString();
    }

}
