/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.Planet;
import static java.lang.System.out;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Connor
 */
public class MapControllerTest {
    
    public MapControllerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateDistance method, of class MapController.
     */
    @Test
    public void testCalculateDistance() {
        out.println("calculateDistance");
        MapController instance = new MapController();
        
        // Test case #1
        out.println("\tTest Case #1");
        double expResult1 = 5.0;
        double result1 = instance.calculateDistance(Planet.Kryta, Planet.Mezopan);
        assertEquals(expResult1, result1, 0.001);
        
        // Test case #2
        out.println("\tTest Case #2");
        double expResult2 = 3.6055;
        double result2 = instance.calculateDistance(Planet.Kryta, Planet.Qualufe);
        assertEquals(expResult2, result2, 0.001);
        
        // Test case #3
        out.println("\tTest Case #3");
        double expResult3 = 0.0;
        double result3 = instance.calculateDistance(Planet.Kryta, Planet.Kryta);
        assertEquals(expResult3, result3, 0.001);
        
        // Test case #4
        out.println("\tTest Case #4");
        double expResult4 = 4.472;
        double result4 = instance.calculateDistance(Planet.Redecent, Planet.Mezopan);
        assertEquals(expResult4, result4, 0.001);
    }
}
