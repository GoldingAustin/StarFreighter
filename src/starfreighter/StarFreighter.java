/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starfreighter;

import byui.cit260.starFreighter.model.*;
import byui.cit260.starFreighter.controller.*;

/**
 *
 * @author austingolding
 */
public class StarFreighter {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CrewController crewController = new CrewController();
        CrewMember captain = new CrewMember();
        crewController.name(captain, "Cap'n Steve");
        crewController.setStat(captain, CrewController.Stats.MECHANIC, 5);
        System.out.println(captain);
        
        ShipController shipController = new ShipController();
        Ship playerShip = new Ship();
        
        shipController.assignPosition(playerShip, captain, ShipController.Positions.CAPTAIN);
        System.out.println(playerShip);
       // Create controller instances
       MerchantController playerInventory = new MerchantController("player");
       MerchantController shopInventory = new MerchantController("shop");
       
       // Display their currencies
       playerInventory.displayCurrency();
       shopInventory.displayCurrency();
       
       // Create a test item
       Item cheese = new Item();
       cheese.setName("Amazing Space Cheese");
       cheese.setValue(5);
       
       // Add the item to the player's playerInventory
       playerInventory.addItem(cheese);
       
       // Display each inventory
       playerInventory.displayStock();
       shopInventory.displayStock();
       
       // Have the shopInventory attempt to buy the item
       if (shopInventory.buyItem(cheese)) {
           System.out.println("Shop has bought the amazing space cheese for " + cheese.getValue());
           
           // Have the playerInventory sell the item
           if (playerInventory.sellItem(cheese)) {
               System.out.println("Player has sold the amazing space cheese for " + cheese.getValue());
           }
       }
       
       // Display their currencies again
       playerInventory.displayCurrency();
       shopInventory.displayCurrency();
       
       // Display each inventory again
       playerInventory.displayStock();
       shopInventory.displayStock();
       
       
       /*
       // GameCharacter.java test
       GameCharacter player = new GameCharacter();
       
       player.setName("Player");
       player.setRole("role");
       player.setPilot(1);
       player.setMechanic(1);
       player.setFighter(1);
       player.setDoctor(1);
       player.setTrader(1);
       player.setHitPoints(10);
       
       String playerInfo = player.toString();
       System.out.println(playerInfo);
       
       // Ship.java test
       Ship theShip = new Ship();
       
       theShip.setName("A cool name for a ship");
       theShip.setUpgrade(0);
       theShip.setRepair(1);
       
       String theShipInfo = theShip.toString();
       System.out.println(theShipInfo);

       // Shop.java && ShopItem.java test
       Shop theShop = new Shop();
       theShop.setCurrency(100);
       
       Item anItem = new Item();
       anItem.setName("Item Name");
       anItem.setValue(100);
       theShop.addItem(anItem);
       
       Item anotherItem = new Item();
       anotherItem.setName("This item is not in the shopInventory");
       anotherItem.setValue(100000);
       theShop.addItem(anotherItem); // Add it...
       theShop.removeItem(anotherItem); // ... then remove it
       
       String anItemInfo = anItem.toString();
       System.out.println(anItemInfo);
       
       String anotherItemInfo = anotherItem.toString();
       System.out.println(anotherItemInfo);
       
       String shopInventoryInfo = theShop.toString();
       System.out.println(shopInventoryInfo);
       
       // CombatEncounter.java test
       CombatEncounter enemyMine = new CombatEncounter();
       enemyMine.setAlive(true);
       enemyMine.setHitPoints(100);
       enemyMine.setDamage(5);
       enemyMine.setDamageModifiers(10);
       
       String enemyInfo = enemyMine.toString();
       System.out.println(enemyInfo);
       
       Map planetMap = new Map();
       
       planetMap.display();
       planetMap.isCompleted();
       planetMap.setCompleted(false);
   
       Planet aPlanet = new Planet();
       
       aPlanet.setName("Planet Name");
       aPlanet.setDescription("This is the first planet");
       planetMap.setPlanets(aPlanet);
       
       String mapInfo = planetMap.toString();
       System.out.println(mapInfo);
    
       Location aLoc = new Location();
       
       aLoc.setName("A Location");
       
       JobBoard aJob = new JobBoard();
       
       aJob.setJob("A Job");
       aJob.setLocation("A Job Location");
       aJob.setReward(10);
       aLoc.setJobList(aJob);
       
       String locInfo = aLoc.toString();
       System.out.println(locInfo);
*/
       
       
       
    }
    
}
