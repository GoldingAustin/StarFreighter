/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.Item;
import static java.lang.System.out;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Connor
 */
public class MerchantControllerTest {
    private final MerchantController totalTest = new MerchantController();
    private final MerchantController resaleTest = new MerchantController();
    private final MerchantController sortTest = new MerchantController();
    private final Item testItem = new Item("Testing", 100);
    private final Item spaceCheese = new Item("Amazing Space Cheese", 250);
    private final Item negative = new Item("Negative", -500);
    
    public MerchantControllerTest() {

    }

    /**
     * Test of calculateTotalValue method, of class MerchantController.
     */
    @Test
    public void testCalculateTotalValue() {
        out.println("calculateTotalValue");

        // Test case #1
        out.println("\tTest Case #1");
        int expResult1 = 0;
        int result1 = totalTest.calculateTotalValue();
        assertEquals(expResult1, result1);

        // Test case #2
        out.println("\tTest Case #2");
        totalTest.addItem(testItem);
        int expResult2 = 100;
        int result2 = totalTest.calculateTotalValue();
        assertEquals(expResult2, result2);

        // Test case #3
        out.println("\tTest Case #3");
        totalTest.addItem(spaceCheese);
        int expResult3 = 350;
        int result3 = totalTest.calculateTotalValue();
        assertEquals(expResult3, result3);

        // Test case #4
        out.println("\tTest Case #4");
        totalTest.addItem(negative);
        int expResult4 = -150;
        int result4 = totalTest.calculateTotalValue();
        assertEquals(expResult4, result4);
    }

    /**
     * Test of calculateTotalResaleValue method, of class MerchantController.
     */
    @Test
    public void testCalculateTotalResaleValue() {
        out.println("calculateTotalResaleValue");

        // Test case #1
        out.println("\tTest Case #1");
        int expResult1 = 0;
        int result1 = resaleTest.calculateTotalResaleValue();
        assertEquals(expResult1, result1);        

        // Test case #1
        out.println("\tTest Case #2");
        resaleTest.addItem(testItem);
        int expResult2 = 75;
        int result2 = resaleTest.calculateTotalResaleValue();
        assertEquals(expResult2, result2);

        // Test case #3
        out.println("\tTest Case #3");
        resaleTest.addItem(spaceCheese);
        int expResult3 = 262;
        int result3 = resaleTest.calculateTotalResaleValue();
        assertEquals(expResult3, result3);

        // Test case #4
        out.println("\tTest Case #4");
        resaleTest.addItem(negative);
        int expResult4 = -113;
        int result4 = resaleTest.calculateTotalResaleValue();
        assertEquals(expResult4, result4);
    }

    /**
     * Test of sortByValue method, of class MerchantController.
     */
    @Test
    public void testSortByValue() {
        out.println("sortByValue");
        ArrayList<Item> sorted = null;

        // Test case #1
        out.println("\tTest Case #1");
        sorted = sortTest.sortByValue(sortTest.itemList());
        int expResult1 = 0;
        int result1 = sorted.size();
        assertEquals(expResult1, result1);        

        // Test case #1
        out.println("\tTest Case #2");
        sortTest.addItem(testItem);
        sorted = sortTest.sortByValue(sortTest.itemList());
        int expResult2 = 1;
        int result2 = sorted.size();
        assertEquals(expResult2, result2);
        int expResult2a = 100;
        int result2a = sorted.get(0).getValue();
        assertEquals(expResult2a, result2a);

        // Test case #3
        out.println("\tTest Case #3");
        sortTest.addItem(spaceCheese);
        sorted = sortTest.sortByValue(sortTest.itemList());
        int expResult3 = 2;
        int result3 = sorted.size();
        assertEquals(expResult3, result3);
        int expResult3a = 250;
        int result3a = sorted.get(1).getValue();
        assertEquals(expResult3a, result3a);

        // Test case #4
        out.println("\tTest Case #4");
        sortTest.addItem(negative);
        sorted = sortTest.sortByValue(sortTest.itemList());
        int expResult4 = 3;
        int result4 = sorted.size();
        assertEquals(expResult4, result4);
        int expResult4a = -500;
        int result4a = sorted.get(0).getValue();
        assertEquals(expResult4a, result4a);
    }
    
}
