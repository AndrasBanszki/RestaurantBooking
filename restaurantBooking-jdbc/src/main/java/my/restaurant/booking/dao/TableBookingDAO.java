package my.restaurant.booking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import my.restaurant.booking.api.dao.InterfaceTableBookingDAO;
import my.restaurant.booking.api.model.Booking;
import my.restaurant.booking.api.model.Table;
import my.restaurant.booking.api.model.TableBooking;
import my.restaurant.booking.jdbc.MySqlConnector;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
@RequestScoped
public class TableBookingDAO extends MySqlConnector implements InterfaceTableBookingDAO{
    
    private final static String SELECT_ALL_QUERY = "SELECT restaurant.book_table.id AS id,\n" +
                                                   "       restaurant.book_table.book_id AS bookId,\n" +
                                                   "       restaurant.book_table.table_id AS tableId\n" +
                                                   "FROM restaurant.book_table;";
    
    private final static String SELECT_BY_RESTAURANT_DATE_QUERY = "SELECT ta.id AS tableId, \n" +
                                                                  "	  ta.number_of_seats AS seats,\n" +
                                                                  "       ta.restaurant_id AS restId,\n" +
                                                                  "       ta.restaurant_table AS tableNo,\n" +
                                                                  "       bt.id AS btId,\n" +
                                                                  "       bo.id AS bookId,\n" +
                                                                  "       bo.long AS duration,\n" +
                                                                  "       bo.number_of_people AS noPeople,\n" +
                                                                  "       bo.date_time AS date\n" +
                                                                  "FROM restaurant.table  ta, restaurant.book_table bt, restaurant.books bo\n" +
                                                                  "WHERE ta.id = bt.table_id\n" +
                                                                  "AND bt.book_id = bo.id\n" +
                                                                  "AND Date(bo.date_time) = ?\n" +
                                                                  "AND ta.restaurant_id = ?\n" +
                                                                  "ORDER BY bo.date_time ASC, ta.id;";
    
    /*
    Trying to use the other DAO-s to fill out the TableBooking list, its a basic thing
    TableBooking has an id, and 2 outer keys : table_id, book_id in the database
    The POJO of this has an ID, and 2 other POJOs as attribute,
        Booking and Table;
        I gonna use my other DAO-s to get these Objects, and create a TableBooking Object
    */
    @Override
    public List<TableBooking> getAllTableBooking() {
        
        List<TableBooking> tableBookings = new ArrayList<>();
        TablesDAO tablesDao = new TablesDAO();
        BookingDAO bookingDao = new BookingDAO();
        
        try(Statement stmt  = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);) 
            {
            while (rs.next()) {
                tableBookings.add( new TableBooking(rs.getLong("id"), 
                                                    tablesDao.getTableById(rs.getLong("tableId")),
                                                    bookingDao.getBookingById(rs.getLong("bookId"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tableBookings;
    }
    
    /*
    Here i dont use other DAO instances, instead im letting the sql server to fetch all the date I need
    */
    @Override
    public List<TableBooking> getTableBookingOfRestaurantByDate(long restId, LocalDate date) {
        
        List<TableBooking> tableBookings = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                
        try(PreparedStatement stmt = prepareStatement(this.getConnection(), 
                                                       SELECT_BY_RESTAURANT_DATE_QUERY,
                                                       ps -> {ps.setString(1, date.format(formatter)); 
                                                              ps.setString(2,  String.valueOf(restId));});                                    
            ResultSet rs = stmt.executeQuery(); )
            {
            while (rs.next()) { 
                tableBookings.add(new TableBooking(rs.getLong("btId"),
                                                   new Table(rs.getLong("tableId"), 
                                                             rs.getInt("seats"), 
                                                             rs.getLong("restId"), 
                                                             rs.getInt("tableNo")),
                                                   new Booking(rs.getLong("bookId"),
                                                               LocalDateTime.parse(rs.getString("date"),DateTimeFormatter.ofPattern("yyyy-LL-dd HH:mm:ss")),
                                                               rs.getInt("duration"),
                                                               rs.getInt("noPeople"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableBookings;
    }

}
