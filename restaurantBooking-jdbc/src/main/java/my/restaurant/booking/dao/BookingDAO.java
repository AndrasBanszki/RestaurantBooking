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
import javax.enterprise.context.RequestScoped;
import my.restaurant.booking.api.model.Booking;
import my.restaurant.booking.jdbc.MySqlConnector;
import static my.restaurant.booking.jdbc.MySqlConnector.prepareStatement;
import my.restaurant.booking.api.dao.InterfaceBookingDAO;


/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */

@RequestScoped
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
    
    private final static String ADD_BOOKING = "INSERT INTO `restaurant`.`books` (`date_time`,`long`,`number_of_people`)\n" +
                                              "VALUES ( ?, ?, ? );";
    
    private final static String DELETE_BOOKING = "DELETE FROM `restaurant`.`books`\n" +
                                                 "  WHERE restaurant.books.id = ?;";

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
                
        try(PreparedStatement pstmt = prepareStatement(this.getConnection(), 
                                                       SELECT_BY_DATE_QUERY,
                                                       ps -> ps.setString(1, date.format(formatter)));  
            ResultSet rs = pstmt.executeQuery(); )
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
    public long addNewBooking(LocalDateTime dateTime, int duration, int numberPeople) {
        long newBookingId = 0;
                                                                // '2017-09-01 11:30:00'
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        try( PreparedStatement pstmt = prepareStatement(this.getConnection(), 
                                                       ADD_BOOKING,
                                                       Statement.RETURN_GENERATED_KEYS,
                                                       ps -> { ps.setString(1, dateTime.format(formatter));
                                                               ps.setInt(2, duration);
                                                               ps.setInt(3, numberPeople); } 
                                                        );
            
            )   {
                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0){
                    throw new SQLException("Creating booking failed, no rows affected.");
                }
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        newBookingId = generatedKeys.getLong(1);
                    }
                else {
                    throw new SQLException("Creating booking failed, no ID obtained.");
                    }
                }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return newBookingId;
    }
    
    @Override
    public void deleteBooking(long id) {
        try (PreparedStatement pstmt = prepareStatement(this.getConnection(), 
                                                       DELETE_BOOKING,
                                                       ps -> ps.setLong(1, id)); 
            ){
            System.out.println(pstmt);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("Delete booking failed, no rows affected.");
            }    
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
    
