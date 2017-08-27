package my.restaurant.booking.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import my.restaurant.booking.api.model.Booking;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class BookingDAOTest {
    
    public BookingDAOTest() {
    }

    /**
     * Test of getAllBooking method, of class BookingDAO.
     */
    @Test
    public void testGetAllBooking() {
        BookingDAO bookingDao = new BookingDAO();
        
        List<Booking> bookings = bookingDao.getAllBooking();        
        
        assertFalse( bookings.isEmpty());  
        //assertEquals(10, bookings.size());
    }

    /**
     * Test of getBookingById method, of class BookingDAO.
     */
    @Test
    public void testGetBookingById() {
        BookingDAO bookingDao = new BookingDAO();
        
        Booking book = bookingDao.getBookingById(1L);
        
        assertNotNull( book);  
        assertEquals(120, book.getDuration());
        assertEquals(2, book.getNumberOfPeople());
        assertEquals("2017-09-01T11:30", book.getDateTime().toString());
    }

    /**
     * Test of getBookingByDate method, of class BookingDAO.
     */
    @Test
    public void testGetBookingByDate() {
        BookingDAO bookingDao = new BookingDAO();
        LocalDate locDate = LocalDate.parse("2017-09-01", DateTimeFormatter.ofPattern("yyyy-LL-dd"));
               
        List<Booking> bookings = bookingDao.getBookingsByDate(locDate);
        
        assertFalse( bookings.isEmpty());  
        assertEquals(120, bookings.get(0).getDuration());
        assertEquals(2, bookings.get(0).getNumberOfPeople());
        assertEquals("2017-09-01T11:30", bookings.get(0).getDateTime().toString());
    }
    
    /**
     * Test of addNewBooking method, of class BookingDAO.
     * only counting number of rows before and after the insert, 
     * then deletig the inserted row by ID
     */
    @Test
    public void testAddNewBooking() {
        BookingDAO bookingDao = new BookingDAO();
        int count = bookingDao.getAllBooking().size();
        
        LocalDateTime locDateTime = LocalDateTime.parse("2017-10-01 12:30:00", DateTimeFormatter.ofPattern("yyyy-LL-dd HH:mm:ss"));
        long insrtedBookingID = bookingDao.addNewBooking(locDateTime, 120, 4);
        
        assertEquals(count + 1, bookingDao.getAllBooking().size());
        
        bookingDao.deleteBooking(insrtedBookingID);
        assertEquals(count, bookingDao.getAllBooking().size());
        
    }
    
}
