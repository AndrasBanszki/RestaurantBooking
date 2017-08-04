package my.restaurant.booking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.restaurant.booking.api.model.Table;
import my.restaurant.booking.jdbc.MySqlConnector;
import my.restaurant.booking.api.dao.InterfaceTablesDAO;
import static my.restaurant.booking.jdbc.MySqlConnector.prepareStatement;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class TablesDAO extends MySqlConnector implements InterfaceTablesDAO {
    
    private final static String SELECT_ALL_QUERY = "SELECT restaurant.table.id AS tableId,\n" +
                                                   "       restaurant.table.number_of_seats AS noSeats,\n" +
                                                   "       restaurant.table.restaurant_id AS restId,\n" +
                                                   "       restaurant.table.restaurant_table AS tableNo\n" +
                                                   "FROM restaurant.table;";
    
    private final static String SELECT_BY_ID_QUERY = "SELECT restaurant.table.id AS tableId,\n" +
                                                     "       restaurant.table.number_of_seats AS noSeats,\n" +
                                                     "       restaurant.table.restaurant_id AS restId,\n" +
                                                     "       restaurant.table.restaurant_table AS tableNo\n" +
                                                     "FROM restaurant.table\n" +
                                                     "WHERE restaurant.table.id = ?;";
    
    private final static String SELECT_BY_RESTAURANT_ID_QUERY = "SELECT restaurant.table.id AS tableId,\n" +
                                                                "       restaurant.table.number_of_seats AS noSeats,\n" +
                                                                "       restaurant.table.restaurant_id AS restId,\n" +
                                                                "       restaurant.table.restaurant_table AS tableNo\n" +
                                                                "FROM restaurant.table\n" +
                                                                "WHERE restaurant.table.restaurant_id = ?;";
    
   
    @Override
    public List<Table> getAllTables() {
        
        List<Table> tables = new LinkedList<>();
        
        try(Statement stmt  = this.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_QUERY);) 
            {   
            while (rs.next()) {
                tables.add( new Table(rs.getLong("tableId"), 
                                      rs.getInt("noSeats"), 
                                      rs.getLong("restId"), 
                                      rs.getInt("tableNo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tables;
    }
    
    @Override
    public Table getTableById(Long id) {
        
        Table table = null;
        
        try(PreparedStatement stmt = prepareStatement(this.getConnection(),
                                                       SELECT_BY_ID_QUERY, 
                                                       ps -> ps.setString(1, String.valueOf(id)));
            ResultSet rs = stmt.executeQuery();)
            {
            if (rs.next()) {
                table =  new Table(rs.getLong("tableId"), 
                                   rs.getInt("noSeats"), 
                                   rs.getLong("restId"), 
                                   rs.getInt("tableNo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return table;
    }
    
    @Override
    public List<Table> getTablesByRestId(Long restId) {
        
        List<Table> tables = new LinkedList<>();
        
        try(PreparedStatement stmt = prepareStatement(this.getConnection(), 
                                                      SELECT_BY_RESTAURANT_ID_QUERY, 
                                                      ps -> ps.setString(1, String.valueOf( restId)));
            ResultSet rs = stmt.executeQuery();) 
            {
            while (rs.next()) {
                tables.add( new Table(rs.getLong("tableId"), 
                                      rs.getInt("noSeats"), 
                                      rs.getLong("restId"), 
                                      rs.getInt("tableNo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tables;
    }
    
}
