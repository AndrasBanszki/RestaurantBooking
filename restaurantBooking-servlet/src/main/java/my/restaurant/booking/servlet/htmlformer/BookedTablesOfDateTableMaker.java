

package my.restaurant.booking.servlet.htmlformer;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.StringJoiner;
import my.restaurant.booking.api.model.TableBooking;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class BookedTablesOfDateTableMaker {
    
    public String makeTable(List<TableBooking> bookedTables){
        if( bookedTables == null){
            return "";
        }
        StringJoiner sj = new StringJoiner("</tr>\n<tr>", 
              "\n\n<table>\n<tr>\n"
                      + "\t<th>Table no.</th>\n"
                      + "\t<th>Time</th>\n"
                      + "\t<th>Duration</th>\n"
                      + "</tr>\n"
                      + "<tr>\n", 
              "</tr></table>\n");
      
        for (TableBooking t : bookedTables) {
            sj.add(makeTableRow(t));
        }
        return sj.toString();
        
    }
    
    //restTableId=1, restaurantId=5, date=2017-09-01T11:30, duration=120, numberOfperson=2
    private String makeTableRow(TableBooking t){
        return new StringJoiner("</td>\n\t<td>", "\n\t<td>", "</td>\n")
                    .add(String.valueOf(t.getRestTableId()))
                    .add(t.getDate().format(DateTimeFormatter.ISO_TIME))
                    .add(String.valueOf(t.getDuration())).toString();
    }

}
