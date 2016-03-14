/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import static byui.cit260.starFreighter.controller.CrewController.Stats.DOCTOR;
import static byui.cit260.starFreighter.controller.CrewController.Stats.FIGHTER;
import static byui.cit260.starFreighter.controller.CrewController.Stats.PILOT;
import byui.cit260.starFreighter.model.CrewMember;
import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author austingolding
 */
public class CrewControllerTest {

    public CrewControllerTest() {

    }

    /**
     * Test of name method, of class CrewController.
     */
    @Test
    public void testName() {
        /**
         * ***************************
         * Test case #1 **************************
         */

        System.out.println("Name");

        out.println("\tTest case #1");
        CrewMember crew = new CrewMember();
        String name = "Bob";

        CrewController instance = new CrewController();
        instance.name(crew, name);

        String result = crew.getName();
        assertEquals(result, name);

        /**
         * ***************************
         * Test case #2 **************************
         */
        out.println("\tTest case #2");

        name = "Tom";

        instance.name(crew, name);

        result = crew.getName();
        assertEquals(result, name);
    }

    /**
     * Test of damage method, of class CrewController.
     */
    @Test
    public void testDamage() {
        /**
         * ***************************
         * Test case #1 **************************
         */

        System.out.println("damage");
        out.println("\tTest case #1");
        CrewMember crew = new CrewMember();
        crew.setHitPoints(30);
        int damage = 10;

        CrewController instance = new CrewController();
        instance.damage(crew, damage);

        int result = crew.getHitPoints();
        int expResult = 20;
        assertEquals(expResult, result, 0.0001);

        /**
         * ***************************
         * Test case #2 **************************
         */
        out.println("\tTest case #2");
        crew.setHitPoints(30);
        damage = 35;

        instance.damage(crew, damage);

        result = crew.getHitPoints();
        expResult = -5;
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of heal method, of class CrewController.
     */
    @Test
    public void testHeal() {
        System.out.println("heal");
        CrewMember crew = new CrewMember();
        int heal = 25;

        CrewController instance = new CrewController();
        instance.heal(crew, heal);

        int result = crew.getHitPoints();
        int expResult = 25;
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of setStat method, of class CrewController.
     */
    @Test
    public void testSetStat() {
        System.out.println("setStat");
        /**
         * ***************************
         * Test case #1 **************************
         */
        out.println("\tTest case #1");
        CrewMember crew = new CrewMember();
        CrewController.Stats stat = PILOT;
        int value = 2;

        CrewController instance = new CrewController();
        instance.setStat(crew, stat, value);

        int result = crew.getPilot();
        int expResult = 2;
        assertEquals(expResult, result, 0.0001);
        /**
         * ***************************
         * Test case #2 **************************
         */
        out.println("\tTest case #2");
        stat = DOCTOR;
        value = 2;
        instance.setStat(crew, stat, value);

        result = crew.getPilot();
        expResult = 2;
        assertEquals(expResult, result, 0.0001);

        /**
         * ***************************
         * Test case #3 **************************
         */
        out.println("\tTest case #3");
        stat = FIGHTER;
        value = 2;
        instance.setStat(crew, stat, value);

        result = crew.getPilot();
        expResult = 2;
        assertEquals(expResult, result, 0.0001);
    }

}
