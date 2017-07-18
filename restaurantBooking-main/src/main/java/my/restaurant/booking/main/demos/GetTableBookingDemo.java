

package my.restaurant.booking.main.demos;


import java.time.LocalDate;
import java.util.List;
import my.restaurant.booking.api.model.TableBooking;
import my.restaurant.booking.service.BookingServices;
import my.restaurant.booking.servlet.htmlformer.BookedTablesOfDateTableMaker;
import my.restaurant.booking.servlet.htmlformer.FormBuilder;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class GetTableBookingDemo {
    
    public static void main(String[] args){
        BookingServices bs = new BookingServices();
        String selectedDate = "2017-09-01";
        
        
        List<TableBooking> tb = bs.getBookedTables(5, LocalDate.parse(selectedDate));
        
        
        for(TableBooking t : tb){
            System.out.println(t);
        }
        FormBuilder fb = new FormBuilder();
        int selectedCity = 2;
        int selectedRestaurant = 5;
        
        
        System.out.println("\n\n" + fb.buildForm(bs.getCityes(), selectedCity,
                               bs.getRestaurants(selectedCity), selectedRestaurant, 
                               selectedDate,
                               bs.getBookedTables(selectedRestaurant, LocalDate.parse(selectedDate))));
        
        
    }

}