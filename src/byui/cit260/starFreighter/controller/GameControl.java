/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import static byui.cit260.starFreighter.controller.GameControl.Constant.NUMBER_OF_ITEMS_INVENTORY;
import byui.cit260.starFreighter.model.CombatEncounter;
import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.Game;
import byui.cit260.starFreighter.model.GameMap;
import byui.cit260.starFreighter.model.Item;
import byui.cit260.starFreighter.model.JobBoard;
import byui.cit260.starFreighter.model.Location;
import byui.cit260.starFreighter.model.MerchantStock;
import byui.cit260.starFreighter.model.Player;
import byui.cit260.starFreighter.model.Ship;
import enums.InventoryItem;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
public class GameControl {

    public static Game game;
    
    public static Player createPlayer(String playersName) {

        if (playersName == null) {
            return null;
        }

        Player player = new Player();
        player.setName(playersName);
        
        StarFreighter.setPlayer(player);

        return player;
    }

    public static void createNewGame(Player player) {
        game = new Game();
        StarFreighter.setCurrentGame(game);

        CombatEncounter combat = new CombatEncounter();

        GameMap map = MapController.createMap(11, 11);
        game.setGameMap(map);
        
        
        ArrayList<CrewMember>crew = GameControl.createCrewMemberList(player.getName());
        game.setCrewCon(crew);

        Item[] item = GameControl.createItemList();
        game.setItem(item);

        JobBoard jobs = new JobBoard();
        game.setJobs(jobs);

        Location[] location = GameControl.createLocationList();
        game.setLocation(location);

        MerchantStock merch = GameControl.createMerchantStock();
        game.setMerch(merch);

        Ship ship = new Ship();
        game.setShip(ship);
    }

    private static MerchantStock createMerchantStock() {
       MerchantStock merch = new MerchantStock();
       for (int i = 0; i < NUMBER_OF_ITEMS_INVENTORY; i++) {
           merch.addItem(GameControl.createItemList()[i]);         
       }
       merch.setCurrency(100);
       return merch;
    }


    public static class Constant {

        public final static int NUMBER_OF_ITEMS_INVENTORY = 11;

        public enum Item {
            cheese,
            bandages,
            oldparts,
            newparts,
            junk,
            powerbar,
            ore,
            weaponparts,
            weapon,
            armor,
            coins;
        }
    }

    public static void saveGame(Game game, String file) {
        try (FileOutputStream fop = new FileOutputStream(file + "/StarFreighterSave.data")) {
            ObjectOutputStream output = new ObjectOutputStream(fop);

            output.writeObject(game);
        } catch (IOException ex) {
            Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadGame(String file) {
        Game load = new Game();
        try (FileInputStream fip = new FileInputStream(file + "/StarFreighterSave.data")) {
            ObjectInputStream output = new ObjectInputStream(fip);

            load = (Game) output.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        StarFreighter.setCurrentGame(load);
    }

    private static ArrayList<CrewMember> createCrewMemberList(String playersName) {
        ArrayList<CrewMember> crew = new ArrayList<>();
        
        CrewMember crewOne = new CrewMember();
        CrewMember crewTwo = new CrewMember();
        CrewMember crewThr = new CrewMember();
        CrewMember crewFou = new CrewMember();
        CrewMember crewFiv = new CrewMember();
        CrewMember captain = new CrewMember();
        
        crewOne.setTrader(4);
        crewTwo.setFighter(4);
        crewThr.setDoctor(4);
        crewFou.setMechanic(4);
        crewFiv.setPilot(4);
        
        captain.setName(playersName);
        crewOne.setName("Spock");
        crewTwo.setName("Kirk");
        crewThr.setName("Bones");
        crewFou.setName("McCoy");
        crewFiv.setName("Sulu");
        
        captain.setHitPoints(30);
        crewOne.setHitPoints(30);
        crewTwo.setHitPoints(30);
        crewThr.setHitPoints(30);
        crewFou.setHitPoints(30);
        crewFiv.setHitPoints(30);

        crew.add(0, captain);
        crew.add(1, crewOne);
        crew.add(2, crewTwo);
        crew.add(3, crewThr);
        crew.add(4, crewFou);
        crew.add(5, crewFiv);

        return crew;
    }

    private static Item[] createItemList() {
        Item[] item = new Item[Constant.NUMBER_OF_ITEMS_INVENTORY];

        Item cheese = new Item("Amazing Space Cheese", 5);
        item[InventoryItem.cheese.ordinal()] = cheese;

        Item bandages = new Item("Super Bandages", 10);
        item[InventoryItem.bandages.ordinal()] = bandages;

        Item oldparts = new Item("Old Parts", 3);
        item[InventoryItem.oldparts.ordinal()] = oldparts;

        Item newparts = new Item("New Parts", 15);
        item[InventoryItem.newparts.ordinal()] = newparts;

        Item junk = new Item("Junk", 1);
        item[InventoryItem.junk.ordinal()] = junk;

        Item powerbar = new Item("Powerbar", 10);
        item[InventoryItem.powerbar.ordinal()] = powerbar;

        Item ore = new Item("Space Ore", 20);
        item[InventoryItem.ore.ordinal()] = ore;

        Item weaponparts = new Item("Weapon Parts", 10);
        item[InventoryItem.weaponparts.ordinal()] = weaponparts;

        Item weapon = new Item("Laser Rifle", 50);
        item[InventoryItem.weapon.ordinal()] = weapon;

        Item armor = new Item("Body Armor", 50);
        item[InventoryItem.armor.ordinal()] = armor;

        Item coins = new Item("Mysterious Coin", 100);
        item[InventoryItem.coins.ordinal()] = coins;

        return item;
    }

    private static Location[] createLocationList() {
        // stub so this will run!
        return new Location[1];
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean gameControl() {
        return true;
    }

}
