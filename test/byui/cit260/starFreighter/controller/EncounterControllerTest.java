/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author austingolding
 */
public class EncounterControllerTest {

    /**
     *
     */
    public EncounterControllerTest() {
    }

    /**
     * Test of generateEncounter method, of class EncounterController.
     */
    /**
     * Test of calculateDamage method, of class EncounterController.
     */
    @Test
    public void testCalculateDamage() {
        System.out.println("calculateDamage");

        /**
         * ***************************
         * Test case #1
         ***************************
         */
        System.out.println("\tTest case #1");

        //New Instance for EncounterController
        EncounterController instance = new EncounterController();

        //Sets attack and DamageModifier
        int attack = 10;
        int mod = 1;

        //Sets expected result
        int expResult = 11;

        //Runs calculateDamage and is contained in result
        int result = instance.calculateDamage(attack, mod);

        assertEquals(expResult, result, 0.0001);

        /**
         * ***************************
         * Test case #2
         ***************************
         */
        System.out.println("\tTest case #2");

        //Sets attack and DamageModifier
        attack = 10;
        mod = 0;

        //Sets expected result
        expResult = 10;

        //Runs calculateDamage and is contained in result
        result = instance.calculateDamage(attack, mod);

        assertEquals(expResult, result, 0.0001);

        /**
         * ***************************
         * Test case #3
         ***************************
         */
        System.out.println("\tTest case #3");

        //New Instance for EncounterController
        //Sets attack and DamageModifier
        attack = 1;
        mod = 10;

        //Sets expected result
        expResult = 2;

        //Runs calculateDamage and is contained in result
        result = instance.calculateDamage(attack, mod);

        assertEquals(expResult, result, 0.0001);

        /**
         * ***************************
         * Test case #4
         ***************************
         */
        System.out.println("\tTest case #4");

        //New Instance for EncounterController
        //Sets attack and DamageModifier
        attack = 0;
        mod = 1;

        //Sets expected result
        expResult = 0;

        //Runs calculateDamage and is contained in result
        result = instance.calculateDamage(attack, mod);

        assertEquals(expResult, result, 0.0001);

    }

    /**
     *
     */
    @Test
    public void testdamageEnemy() {
        System.out.println("damageEnemy");

        /**
         * ***************************
         * Test case #1
         ***************************
         */
        System.out.println("\tTest case #1");
        //Sets new values for player and enemy

        //New Instance for EncounterController
        EncounterController instances = new EncounterController();

        //Test sets setDamage and set Alive for player and setHitPoints and
        //isAlive for Enemy
        instances.player.setDamage(10);
        instances.player.setAlive(true);
        instances.enemy.setAlive(false);
        instances.enemy.setHitPoints(0);

        int expResult = 0;
        //Runs damageEnemy and is contained in result
        int result = instances.damageEnemy();
        assertEquals(expResult, result, 0.0001);

        /**
         * ***************************
         * Test case #2
         ***************************
         */
        System.out.println("\tTest case #2");

        //Test sets setDamage and set Alive for player and setHitPoints and
        //isAlive for Enemy
        instances.player.setDamage(10);
        instances.player.setAlive(true);
        instances.enemy.setAlive(true);
        instances.enemy.setHitPoints(0);

        expResult = -10;
        //Runs damageEnemy and is contained in result
        result = instances.damageEnemy();
        assertEquals(expResult, result, 0.0001);

        /**
         * ***************************
         * Test case #3
         ***************************
         */
        System.out.println("\tTest case #3");

        //Test sets setDamage and set Alive for player and setHitPoints and
        //isAlive for Enemy
        instances.player.setDamage(10);
        instances.player.setAlive(false);
        instances.enemy.setAlive(true);
        instances.enemy.setHitPoints(20);

        expResult = -1;
        //Runs damageEnemy and is contained in result
        result = instances.damageEnemy();
        assertEquals(expResult, result, 0.0001);

        /**
         * ***************************
         * Test case #4
         ***************************
         */
        System.out.println("\tTest case #4");

        //Test sets setDamage and set Alive for player and setHitPoints and
        //isAlive for Enemy
        instances.player.setDamage(-3);
        instances.player.setAlive(true);
        instances.enemy.setAlive(true);
        instances.enemy.setHitPoints(0);

        expResult = 0;
        //Runs damageEnemy and is contained in result
        result = instances.damageEnemy();
        assertEquals(expResult, result, 0.0001);

        /**
         * ***************************
         * Test case #5
         ***************************
         */
        System.out.println("\tTest case #5");

        //Test sets setDamage and set Alive for player and setHitPoints and
        //isAlive for Enemy
        instances.player.setDamage(5);
        instances.player.setAlive(true);
        instances.enemy.setAlive(true);
        instances.enemy.setHitPoints(15);

        expResult = 10;
        //Runs damageEnemy and is contained in result
        result = instances.damageEnemy();
        assertEquals(expResult, result, 0.0001);

    }

}
