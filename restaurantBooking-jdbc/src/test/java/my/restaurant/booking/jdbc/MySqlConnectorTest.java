/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.restaurant.booking.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class MySqlConnectorTest {

    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        assertNotNull(new MySqlConnector().getConnection());
    }
    
    @Test
    public void testCitys() throws Exception {
        int cityCount = 0;
        Connection con = new MySqlConnector().getConnection();

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select count(name) from city;");
            
            while (rs.next()) {
                cityCount = rs.getInt("count(name)");
                System.out.println(cityCount);
            }
        Assert.assertEquals(3, cityCount);
        
    }
    
}
