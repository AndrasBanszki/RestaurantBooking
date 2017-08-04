package my.restaurant.booking.api.dao;

import java.util.List;
import my.restaurant.booking.api.model.Table;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface InterfaceTablesDAO {
    
    public List<Table> getAllTables();
    
    public Table getTableById(Long id);
    
    public List<Table> getTablesByRestId(Long restId);
    
}
