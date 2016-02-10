/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.CombatEncounter;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author austingolding
 */
public class EncounterControllerTest {
    
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
        
        /*****************************
         * Test case #1
         ****************************/
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
 
                /*****************************
         * Test case #1
         ****************************/
        System.out.println("\tTest case #2");
     
        
        //Sets attack and DamageModifier
        attack = 10;
        mod = 0;
        
        //Sets expected result
        expResult = 10;
        
        //Runs calculateDamage and is contained in result
        result = instance.calculateDamage(attack, mod);
        
        assertEquals(expResult, result, 0.0001);
 
                /*****************************
         * Test case #1
         ****************************/
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
 
                /*****************************
         * Test case #1
         ****************************/
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


}
