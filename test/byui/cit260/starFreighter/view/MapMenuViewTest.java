/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author austingolding
 */
public class MapMenuViewTest {

    public MapMenuViewTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of doAction method, of class MapMenuView.
     */
    @Test
    public void testDoAction() {
        System.out.println("doAction");
        Object obj = null;
        MapMenuView instance = new MapMenuView();
        boolean expResult = false;
        boolean result = instance.doAction(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of EncounterChance method, of class MapMenuView.
     */
    @Test
    public void testEncounterChance() {
        System.out.println("EncounterChance");
        MapMenuView instance = new MapMenuView();
        instance.EncounterChance();
        // TODO review the generated test code and remove the default call to fail.

    }

}
