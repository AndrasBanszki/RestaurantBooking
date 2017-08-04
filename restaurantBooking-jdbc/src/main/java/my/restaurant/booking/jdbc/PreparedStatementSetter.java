package my.restaurant.booking.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface PreparedStatementSetter {
    
    void setValues(PreparedStatement ps) throws SQLException;
    
}
