/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starfreighter;

import byui.cit260.starFreighter.model.Inventory;

/**
 *
 * @author austingolding
 */
public class StarFreighter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Inventory shipInventory = new Inventory();
       
       shipInventory.setCurrency(8);
       shipInventory.setItemList(new String[]{"Cannon", "Blaster", "Medicine"});
       
       String shipInfo = shipInventory.toString();
       System.out.println(shipInfo);
        
    }
    
}
