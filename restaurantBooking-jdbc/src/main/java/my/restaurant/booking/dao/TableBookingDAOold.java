

package my.restaurant.booking.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import my.restaurant.booking.api.dao.InterfaceTableBookingDAO;

import my.restaurant.booking.api.model.TableBookingOld;
import my.restaurant.booking.jdbc.MySqlConnector;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
@RequestScoped
public class TableBookingDAOold extends MySqlConnector  {
    
    private static final String QUERY_PART1 =   "SELECT t.id as tableId, restaurant_table as restTableId, t.restaurant_id as restId,\n" +
                                                "DATE_FORMAT( b.date_time, '%Y-%m-%dT%H:%i:%s') as dateTime, b.long as duration, b.number_of_people as personNum\n" +
                                                "FROM restaurant.book_table as bt\n" +
                                                "JOIN restaurant.table AS t ON bt.table_id = t.id\n" +
                                                "JOIN restaurant.books AS b ON bt.book_id = b.id\n" +
                                                "WHERE Date(b.date_time) = '";
    private static final String QUERY_PART2 =   "' \n" +
                                                "AND t.restaurant_id = ";
    private static final String QUERY_PART3 =   "\nORDER BY t.id ASC, b.date_time;";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    

    
    public List<TableBookingOld> getTableBookings(long restId, LocalDate date) {
        
        if(date == null){
            return new LinkedList<>();
        }
        
        List<TableBookingOld> tableBookings = new LinkedList<>();
        
        System.out.println(QUERY_PART1 + date.format(formatter) + QUERY_PART2 + String.valueOf(restId) + QUERY_PART3);
                
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();      
            ResultSet rs = statement.executeQuery(QUERY_PART1 + date.format(formatter) + QUERY_PART2 + String.valueOf(restId) + QUERY_PART3 ) ) 
            {
            
            while (rs.next()) {
// TableBooking(long tableid, long restTableId, long restaurantId, Date date, int duration, int numberOfperson)
                tableBookings.add(new TableBookingOld(rs.getLong("tableId"),
                                                    rs.getLong("restTableId"),
                                                    rs.getLong("restId"),
                                                    LocalDateTime.parse(rs.getString("dateTime"), ISO_DATE_TIME),
                                                    rs.getInt("duration"),
                                                    rs.getInt("personNum")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableBookings;
    }
    

}
