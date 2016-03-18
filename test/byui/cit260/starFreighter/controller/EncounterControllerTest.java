/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.CombatEncounter;
import static java.lang.System.out;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author austingolding
 */
public class EncounterControllerTest {
    CombatEncounter player = new CombatEncounter();
    CombatEncounter enemy = new CombatEncounter();
    /**
     *
     */
    public EncounterControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of generateEncounter method, of class EncounterController.
     */
    /**
     * Test of calculateDamage method, of class EncounterController.
     */
//    @Test
//    public void testCalculateDamage() {
//        out.println("calculateDamage");
//
//        /**
//         * ***************************
//         * Test case #1
//         ***************************
//         */
//        out.println("\tTest case #1");
//
//        //New Instance for EncounterController
//        EncounterController instance = new EncounterController();
//
//        //Sets attack and DamageModifier
//        int attack = 10;
//        int mod = 1;
//
//        //Sets expected result
//        int expResult = 11;
//
//        //Runs calculateDamage and is contained in result
//        int result = instance.calculateDamage();
//
//        assertEquals(expResult, result, 0.0001);
//
//        /**
//         * ***************************
//         * Test case #2
//         ***************************
//         */
//        out.println("\tTest case #2");
//
//        //Sets attack and DamageModifier
//        attack = 10;
//        player.setDamageModifiers(0);
//
//        //Sets expected result
//        expResult = 10;
//
//        //Runs calculateDamage and is contained in result
//        result = instance.calculateDamage();
//
//        assertEquals(expResult, result, 0.0001);
//
//        /**
//         * ***************************
//         * Test case #3
//         ***************************
//         */
//        out.println("\tTest case #3");
//
//        //New Instance for EncounterController
//        //Sets attack and DamageModifier
//        attack = 10;
//        mod = 10;
//
//        //Sets expected result
//        expResult = 20;
//
//        //Runs calculateDamage and is contained in result
//        result = instance.calculateDamage(attack, mod);
//
//        assertEquals(expResult, result, 0.0001);
//
//        /**
//         * ***************************
//         * Test case #4
//         ***************************
//         */
//        out.println("\tTest case #4");
//
//        //New Instance for EncounterController
//        //Sets attack and DamageModifier
//        attack = 0;
//        mod = 1;
//
//        //Sets expected result
//        expResult = 0;
//
//        //Runs calculateDamage and is contained in result
//        result = instance.calculateDamage(attack, mod);
//
//        assertEquals(expResult, result, 0.0001);
//
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void testdamageEnemy() {
//        out.println("damageEnemy");
//
//        /**
//         * ***************************
//         * Test case #1
//         ***************************
//         */
//        out.println("\tTest case #1");
//        //Sets new values for player and enemy
//
//        //New Instance for EncounterController
//        EncounterController instances = new EncounterController();
//
//        //Test sets setDamage and set Alive for player and setHitPoints and
//        //isAlive for Enemy
//        instances.player.setDamage(10);
//        instances.player.setAlive(true);
//        instances.enemy.setAlive(false);
//        instances.enemy.setHitPoints(0);
//
//        int expResult = 0;
//        //Runs damageEnemy and is contained in result
//        int result = instances.damageEnemy();
//        assertEquals(expResult, result, 0.0001);
//
//        /**
//         * ***************************
//         * Test case #2
//         ***************************
//         */
//        out.println("\tTest case #2");
//
//        //Test sets setDamage and set Alive for player and setHitPoints and
//        //isAlive for Enemy
//        instances.player.setDamage(10);
//        instances.player.setAlive(true);
//        instances.enemy.setAlive(true);
//        instances.enemy.setHitPoints(0);
//
//        expResult = -10;
//        //Runs damageEnemy and is contained in result
//        result = instances.damageEnemy();
//        assertEquals(expResult, result, 0.0001);
//
//        /**
//         * ***************************
//         * Test case #3
//         ***************************
//         */
//        out.println("\tTest case #3");
//
//        //Test sets setDamage and set Alive for player and setHitPoints and
//        //isAlive for Enemy
//        instances.player.setDamage(10);
//        instances.player.setAlive(false);
//        instances.enemy.setAlive(true);
//        instances.enemy.setHitPoints(20);
//
//        expResult = -1;
//        //Runs damageEnemy and is contained in result
//        result = instances.damageEnemy();
//        assertEquals(expResult, result, 0.0001);
//
//        /**
//         * ***************************
//         * Test case #4
//         ***************************
//         */
//        out.println("\tTest case #4");
//
//        //Test sets setDamage and set Alive for player and setHitPoints and
//        //isAlive for Enemy
//        instances.player.setDamage(-3);
//        instances.player.setAlive(true);
//        instances.enemy.setAlive(true);
//        instances.enemy.setHitPoints(0);
//
//        expResult = 0;
//        //Runs damageEnemy and is contained in result
//        result = instances.damageEnemy();
//        assertEquals(expResult, result, 0.0001);
//
//        /**
//         * ***************************
//         * Test case #5
//         ***************************
//         */
//        out.println("\tTest case #5");
//
//        //Test sets setDamage and set Alive for player and setHitPoints and
//        //isAlive for Enemy
//        instances.player.setDamage(5);
//        instances.player.setAlive(true);
//        instances.enemy.setAlive(true);
//        instances.enemy.setHitPoints(15);
//
//        expResult = 10;
//        //Runs damageEnemy and is contained in result
//        result = instances.damageEnemy();
//        assertEquals(expResult, result, 0.0001);
//
//    }

    /**
     * Test of run method, of class EncounterController.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        EncounterController instance = new EncounterController();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of generateEncounter method, of class EncounterController.
     */
    @Test
    public void testGenerateEncounter() {
        System.out.println("generateEncounter");
        EncounterController instance = new EncounterController();
        instance.generateEncounter();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of damageEnemy method, of class EncounterController.
     */
    @Test
    public void testDamageEnemy() {
        System.out.println("damageEnemy");
        EncounterController instance = new EncounterController();
        instance.damageEnemy();
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getEnemies method, of class EncounterController.
     */
    @Test
    public void testGetEnemies() {
        System.out.println("getEnemies");
        EncounterController instance = new EncounterController();
        ArrayList<CombatEncounter> expResult = null;
        ArrayList<CombatEncounter> result = instance.getEnemies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEnemies method, of class EncounterController.
     */
    @Test
    public void testSetEnemies() {
        System.out.println("setEnemies");
        ArrayList<CombatEncounter> enemies = null;
        EncounterController instance = new EncounterController();
        instance.setEnemies(enemies);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class EncounterController.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        EncounterController instance = new EncounterController();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class EncounterController.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        EncounterController instance = new EncounterController();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class EncounterController.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        EncounterController instance = new EncounterController();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
