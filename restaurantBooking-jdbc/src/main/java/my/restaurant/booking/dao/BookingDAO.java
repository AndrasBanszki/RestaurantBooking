package my.restaurant.booking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.restaurant.booking.api.model.Booking;
import my.restaurant.booking.jdbc.MySqlConnector;
import static my.restaurant.booking.jdbc.MySqlConnector.prepareStatement;
import my.restaurant.booking.api.dao.InterfaceBookingDAO;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class BookingDAO extends MySqlConnector  implements InterfaceBookingDAO{
    
    private final static String SELECT_ALL_QUERY = "SELECT restaurant.books.id AS bookId,\n" + 
                                                   "       restaurant.books.date_time AS dateTime,\n" +
                                                   "       restaurant.books.long AS duration,\n" +
                                                   "       restaurant.books.number_of_people noPeople\n" +
                                                   "FROM restaurant.books;";
    
    private final static String SELECT_BY_ID_QUERY = "SELECT restaurant.books.id AS bookId,\n" + 
                                                     "       restaurant.books.date_time AS dateTime,\n" +
                                                     "       restaurant.books.long AS duration,\n" + 
                                                     "       restaurant.books.number_of_people noPeople\n" +
                                                     "FROM restaurant.books\n" +
                                                     "WHERE restaurant.books.id = ?;";
    
    private final static String SELECT_BY_DATE_QUERY = "SELECT restaurant.books.id AS bookId,\n" +
                                                       "       restaurant.books.date_time AS dateTime,\n" +
                                                       "       restaurant.books.long AS duration,\n" +
                                                       "       restaurant.books.number_of_people noPeople\n" +
                                                       "FROM restaurant.books\n" +
                                                       "WHERE Date(restaurant.books.date_time) = ?;";

    @Override
    public List<Booking> getAllBooking() {
        
        List<Booking> bookings = new LinkedList<>();
                
        try(Statement stmt  = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY); ) 
            {
            while (rs.next()) { 
                bookings.add(new Booking(rs.getLong("bookId"),
                                         LocalDateTime.parse(rs.getString("dateTime"), 
                                                             DateTimeFormatter.ofPattern("yyyy-LL-dd HH:mm:ss")),
                                         rs.getInt("duration"),
                                         rs.getInt("noPeople")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bookings;
    }

    @Override
    public Booking getBookingById(long bookId) {
        
        Booking book = null;
                
        try(PreparedStatement stmt = prepareStatement(this.getConnection(), 
                                                       SELECT_BY_ID_QUERY,
                                                       ps -> ps.setString(1, String.valueOf(bookId)));
            ResultSet rs = stmt.executeQuery(); ) 
            {
            if (rs.next()) { 
                book = new Booking(rs.getLong("bookId"),
                                   LocalDateTime.parse(rs.getString("dateTime"), 
                                                       DateTimeFormatter.ofPattern("yyyy-LL-dd HH:mm:ss")),
                                   rs.getInt("duration"),
                                   rs.getInt("noPeople"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return book;
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date) {
        
        List<Booking> bookings = new LinkedList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                
        try(PreparedStatement stmt = prepareStatement(this.getConnection(), 
                                                       SELECT_BY_DATE_QUERY,
                                                       ps -> ps.setString(1, date.format(formatter)));  
            ResultSet rs = stmt.executeQuery(); )
            {
            while (rs.next()) { 
                bookings.add(new Booking(rs.getLong("bookId"),
                                         LocalDateTime.parse(rs.getString("dateTime"), 
                                                             DateTimeFormatter.ofPattern("yyyy-LL-dd HH:mm:ss")),
                                         rs.getInt("duration"),
                                         rs.getInt("noPeople")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bookings;
    }

}
