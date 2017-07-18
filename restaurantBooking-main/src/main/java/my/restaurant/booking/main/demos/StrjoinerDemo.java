

package my.restaurant.booking.main.demos;

import java.util.StringJoiner;
import my.restaurant.booking.api.model.City;
import my.restaurant.booking.service.BookingServices;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class StrjoinerDemo {
    public static void main(String[] args) {
        BookingServices bs = new BookingServices();
        
        
        StringJoiner sj = new StringJoiner( "</option>\n" +
                                            "<option value=\"", 
                                            "<select id=\"selectbasic\" name=\"selectbasic\" class=\"form-control\">\n<option value=\"",
                                            "</option>\n</select>");
        
        for(City c : bs.getCityes()){
            sj.add(String.valueOf(c.getId()) + "\">" +c.getName());
        }
        
        System.out.println(sj.toString());
    }

}
