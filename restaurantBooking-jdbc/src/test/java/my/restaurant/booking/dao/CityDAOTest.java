/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.restaurant.booking.dao;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class CityDAOTest {
    
    public CityDAOTest() {
    }

    /**
     * Test of getCities method, of class CityDAO.
     */
    @Test
    public void testGetCities() {

        CityDAO instance = new CityDAO();        
        
        assertEquals(3, instance.getCities().size());
        assertFalse(instance.getCities().isEmpty());
        
        
    }
    
}
