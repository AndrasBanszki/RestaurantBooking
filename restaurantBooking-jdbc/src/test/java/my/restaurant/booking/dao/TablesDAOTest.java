
package my.restaurant.booking.dao;

import java.util.List;
import my.restaurant.booking.api.model.Table;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class TablesDAOTest {
    
    public TablesDAOTest() {
    }

    /**
     * Test of getAllTables method, of class TablesDAO.
     */
    @Test
    public void testGetAllTables() {
        TablesDAO tablesDAO = new TablesDAO();
        
        List<Table> tables = tablesDAO.getAllTables();
        
        assertFalse(tables.isEmpty());  
        assertEquals(43, tables.size());
    }

    /**
     * Test of getTableById method, of class TablesDAO.
     */
    @Test
    public void testGetTableById() {/*
        TablesDAO tablesDAO = new TablesDAO();
        
        List<Table> tables = tablesDAO.getTableById(1L );
        
        assertFalse(tables.isEmpty());  
        assertEquals(1, tables.size());
        
        assertEquals(1, tables.get(0).getId());
        assertEquals(2, tables.get(0).getNumberOfSeats());
        assertEquals(1, tables.get(0).getRestaurantId());
        assertEquals(1, tables.get(0).getTableNo());
*/
    }

    /**
     * Test of getTableByRestId method, of class TablesDAO.
     */
    @Test
    public void testGetTableByRestId() {/*
        TablesDAO tablesDAO = new TablesDAO();
        
        List<Table> tables = tablesDAO.getTableByRestId(1L);
        
        assertFalse(tables.isEmpty());  
        assertEquals(5, tables.size());
        
        assertEquals(1, tables.get(0).getId());
        assertEquals(2, tables.get(0).getNumberOfSeats());
        assertEquals(1, tables.get(0).getRestaurantId());
        assertEquals(1, tables.get(0).getTableNo());
        */
    }
    
}
