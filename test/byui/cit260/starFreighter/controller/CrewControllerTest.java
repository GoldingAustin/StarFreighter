/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

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
        System.out.println("name");
        CrewMember crew = null;
        String name = "";
        CrewController instance = new CrewController();
        instance.name(crew, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of damage method, of class CrewController.
     */
    @Test
    public void testDamage() {
        System.out.println("damage");
        CrewMember crew = null;
        int damage = 0;
        CrewController instance = new CrewController();
        instance.damage(crew, damage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of heal method, of class CrewController.
     */
    @Test
    public void testHeal() {
        System.out.println("heal");
        CrewMember crew = null;
        int heal = 0;
        CrewController instance = new CrewController();
        instance.heal(crew, heal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStat method, of class CrewController.
     */
    @Test
    public void testSetStat() {
        System.out.println("setStat");
        CrewMember crew = null;
        CrewController.Stats stat = null;
        int value = 0;
        CrewController instance = new CrewController();
        instance.setStat(crew, stat, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
