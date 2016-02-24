/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.Coordinates;
import byui.cit260.starFreighter.model.Planet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        System.out.println("calculateDistance");
        MapController instance = new MapController();
        
        // Test case #1
        System.out.println("\tTest Case #1");
        Planet currentPlanet1 = new Planet(1, 1);
        Planet desiredPlanet1 = new Planet(-1, -1);
        
        double expResult1 = 2.8284;
        double result1 = instance.calculateDistance(currentPlanet1, desiredPlanet1);
        assertEquals(expResult1, result1, 0.001);
        
        // Test case #2
        System.out.println("\tTest Case #2");
        Planet currentPlanet2 = new Planet(10, -10);
        Planet desiredPlanet2 = new Planet(-10, 10);
        double expResult2 = 28.2842;
        double result2 = instance.calculateDistance(currentPlanet2, desiredPlanet2);
        assertEquals(expResult2, result2, 0.001);
        
        // Test case #3
        System.out.println("\tTest Case #3");
        Planet currentPlanet3 = new Planet(5, 5);
        Planet desiredPlanet3 = new Planet(5, 5);
        double expResult3 = 0.0;
        double result3 = instance.calculateDistance(currentPlanet3, desiredPlanet3);
        assertEquals(expResult3, result3, 0.001);
        
        // Test case #4
        System.out.println("\tTest Case #4");
        Planet currentPlanet4 = new Planet(500, 500);
        Planet desiredPlanet4 = new Planet(0, 0);
        double expResult4 = 707.1068;
        double result4 = instance.calculateDistance(currentPlanet4, desiredPlanet4);
        assertEquals(expResult4, result4, 0.001);
        
        // Test case #5
        /*
        Test case won't run; integer types are required by planet class
        System.out.println("\tTest Case #5");
        Planet currentPlanet5 = new Planet(0.1, 0);
        Planet desiredPlanet5 = new Planet(0, 0);
        double expResult5 = 0; // NaN?
        double result5 = instance.calculateDistance(currentPlanet5, desiredPlanet5);
        assertEquals(expResult5, result5, 0.001);
        */
    }
    
}
