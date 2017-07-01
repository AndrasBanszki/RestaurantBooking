
package my.restaurant.booking.dao;

import java.util.List;
import my.restaurant.booking.api.model.Table;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class TablesDAOTest {

    /**
     * Test of getTablesOfRestaurant method, of class TablesDAO.
     */
    @Test
    public void testGetTablesOfRestaurant() {
        
        List<Table> tables = new TablesDAO().getTablesOfRestaurant(1); 
        
        assertFalse(tables.isEmpty());  
        assertEquals(5, tables.size());
    }
    
}
