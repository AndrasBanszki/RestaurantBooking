
package my.restaurant.booking.servlet.htmlformer;

import my.restaurant.booking.servlet.htmlformer.DateSelector;
import my.restaurant.booking.servlet.htmlformer.CitySelector;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import my.restaurant.booking.api.model.City;
import my.restaurant.booking.api.model.Restaurant;
import my.restaurant.booking.api.model.TableBooking;



/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class FormBuilder {
    
    public String buildForm( List<City> cities, int selectedCity, 
                             List<Restaurant> restaurants, 
                             int selectedRestaurant, 
                             String selectedDate,
                             List<TableBooking> bookedTables){
        
        StringJoiner sj = new StringJoiner( "<br>", 
                                             "<form action = \"BookingServlet\" method = \"GET\">", 
                                             "<input type = \"submit\" value = \"Submit\" />\n" + 
                                             "</form>");
        
        sj.add( new CitySelector().make(cities,selectedCity));
        if( selectedCity != 0)
            sj.add( new RestaurantSelector().make(restaurants, selectedRestaurant));
        if( selectedRestaurant != 0)
            sj.add( new DateSelector().make(selectedDate));
        if( selectedDate != null && !bookedTables.isEmpty()){
            sj.add( new BookedTablesOfDateTableMaker().makeTable(bookedTables));
        }
        return sj.toString();
    }
    
}
