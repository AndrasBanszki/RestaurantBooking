package my.restaurant.booking.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import my.restaurant.booking.api.model.TableBooking;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class TableBookingDAOTest {

    /**
     * Test of getAllTableBooking method, of class TableBookingDAO.
     */
    @Test
    public void testGetAllTableBooking() {
        
        TableBookingDAO tableBookingDao = new TableBookingDAO();
        List<TableBooking> tableBookings = tableBookingDao.getAllTableBooking();
        
        assertFalse(tableBookings.isEmpty());
    }

    /**
     * Test of getTableBookingOfRestaurantByDate method, of class TableBookingDAO.
     */
    @Test
    public void testGetTableBookingOfRestaurantByDate() {
        
        TableBookingDAO tableBookingDao = new TableBookingDAO();
        LocalDate locDate = LocalDate.parse("2017-09-01", DateTimeFormatter.ofPattern("yyyy-LL-dd"));
        
        List<TableBooking> tableBookings = tableBookingDao.getTableBookingOfRestaurantByDate(5, locDate);
        
        assertFalse(tableBookings.isEmpty());
        assertEquals(120, tableBookings.get(0).getBooking().getDuration());
        assertEquals(2, tableBookings.get(0).getBooking().getNumberOfPeople());
        assertEquals("2017-09-01T11:30", tableBookings.get(0).getBooking().getDateTime().toString());
    }
    
}
