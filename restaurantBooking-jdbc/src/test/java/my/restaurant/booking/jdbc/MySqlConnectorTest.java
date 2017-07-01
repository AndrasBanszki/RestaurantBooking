
package my.restaurant.booking.jdbc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class MySqlConnectorTest {

    @Test
    public void GetConnectionTest() throws Exception {
        
        MySqlConnector mySqlConn = new MySqlConnector();
        assertNotNull(mySqlConn.getConnection());  
    }
    
}
