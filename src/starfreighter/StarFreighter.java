/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starfreighter;

import byui.cit260.starFreighter.model.*;

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
       
       InventoryItem firstItem = new InventoryItem();
       firstItem.setName("First Item");
       firstItem.setValue(100);
       shipInventory.addItem(firstItem);
       
       InventoryItem secItem = new InventoryItem();
       secItem.setName("Second Item");
       secItem.setValue(1000);
       shipInventory.addItem(secItem);
       
       String shipInfo = shipInventory.toString();
       System.out.println(shipInfo);
       
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
       
       ShopItem anItem = new ShopItem();
       anItem.setName("Item Name");
       anItem.setValue(100);
       theShop.addItem(anItem);
       
       ShopItem anotherItem = new ShopItem();
       anotherItem.setName("This item is not in the shop");
       anotherItem.setValue(100000);
       theShop.addItem(anotherItem); // Add it...
       theShop.removeItem(anotherItem); // ... then remove it
       
       String anItemInfo = anItem.toString();
       System.out.println(anItemInfo);
       
       String anotherItemInfo = anotherItem.toString();
       System.out.println(anotherItemInfo);
       
       String shopInfo = theShop.toString();
       System.out.println(shopInfo);
       
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
       
       
       
    }
    
}
