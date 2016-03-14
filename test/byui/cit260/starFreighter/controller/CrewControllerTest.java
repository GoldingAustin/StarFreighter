/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import static byui.cit260.starFreighter.controller.CrewController.Stats.PILOT;
import byui.cit260.starFreighter.model.CrewMember;
import org.junit.Test;
import static org.junit.Assert.*;

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
        System.out.println("Name");
        CrewMember crew = new CrewMember();
        String name = "Bob";
        CrewController instance = new CrewController();
        instance.name(crew, name);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of damage method, of class CrewController.
     */
    @Test
    public void testDamage() {
        System.out.println("damage");
        CrewMember crew = new CrewMember();
        int damage = 10;
        CrewController instance = new CrewController();
        instance.damage(crew, damage);
        // TODO review the generated test code and remove the default call to fail.
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
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setStat method, of class CrewController.
     */
    @Test
    public void testSetStat() {
        System.out.println("setStat");
        CrewMember crew = new CrewMember();
        CrewController.Stats stat = PILOT;
        int value = 2;
        CrewController instance = new CrewController();
        instance.setStat(crew, stat, value);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
