

package my.restaurant.booking.servlet.htmlformer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <input type="date" name="bday" value="2017-07-21" min="2017-07-18" max="2018-07-08" >
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class DateSelector {
    
    public String make( String selectedDate){
        StringBuilder sb = new StringBuilder();
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        
        sb.append("<input type=\"date\" name=\"selectedDate\"");
        if(  selectedDate != null && !selectedDate.isEmpty() )
            sb.append("value=\"").append(selectedDate).append("\"");
        sb.append("min=\"").append(sdf.format(today)).append("\"");
        sb.append(">");
        
        
        return sb.toString();
    }

}
