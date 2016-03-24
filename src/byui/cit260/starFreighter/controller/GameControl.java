/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import static byui.cit260.starFreighter.controller.CrewController.Stats.DOCTOR;
import static byui.cit260.starFreighter.controller.CrewController.Stats.FIGHTER;
import static byui.cit260.starFreighter.controller.CrewController.Stats.MECHANIC;
import static byui.cit260.starFreighter.controller.CrewController.Stats.PILOT;
import static byui.cit260.starFreighter.controller.CrewController.Stats.TRADER;
import static byui.cit260.starFreighter.controller.GameControl.Constant.NUMBER_OF_ITEMS_INVENTORY;
import byui.cit260.starFreighter.exceptions.GameControlExceptions;
import byui.cit260.starFreighter.model.CombatEncounter;
import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.Game;
import byui.cit260.starFreighter.model.GameMap;
import byui.cit260.starFreighter.model.Item;
import byui.cit260.starFreighter.model.JobBoard;
import byui.cit260.starFreighter.model.Location;
import byui.cit260.starFreighter.model.MerchantStock;
import byui.cit260.starFreighter.model.Planet;
import static byui.cit260.starFreighter.model.Planet.Kryta;
import byui.cit260.starFreighter.model.Player;
import byui.cit260.starFreighter.model.Ship;
import enums.InventoryItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
public class GameControl {

    public static Game game;
    public static String save = "";

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

        ArrayList<CrewMember> crew = GameControl.createCrewMemberList(player.getName());
        game.setCrewCon(crew);

        Item[] item = GameControl.createItemList();
        game.setItem(item);

        ArrayList<JobBoard> jobs = GameControl.createJobsBoard();
        game.setJobs(jobs);

        Location[] location = GameControl.createLocationList();
        game.setLocation(location);

        MerchantStock merch = GameControl.createMerchantStock();
        game.setMerch(merch);

        Ship ship = new Ship();
        ship.setCurrentLocation(Planet.Kryta);
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

    public static void saveGame(Game game) throws GameControlExceptions, IOException {

        try {
            new File(System.getProperty("user.home") + File.separator + "StarFreighter").mkdir();
            save = System.getProperty("user.home") + File.separator + "StarFreighter" + File.separator + "save.data";
        } catch (SecurityException ex) {
            System.out.println("Error while creating directory in Java:" + ex);
        }

        try (FileOutputStream fop = new FileOutputStream(save)) {
            ObjectOutputStream output = new ObjectOutputStream(fop);
            output.writeObject(game);

        } catch (IOException ex) {
            throw new GameControlExceptions(ex.getMessage());
        }

    }

    public static void loadGame() throws GameControlExceptions, ClassNotFoundException, IOException {
        Game load = new Game();
        save = System.getProperty("user.home") + File.separator + "StarFreighter" + File.separator + "save.data";
        try (FileInputStream fip = new FileInputStream(save)) {
            ObjectInputStream output = new ObjectInputStream(fip);
            load = (Game) output.readObject();
            
        } catch (FileNotFoundException ex) {
            throw new GameControlExceptions(ex.getMessage());
        }

        StarFreighter.setCurrentGame(load);
    }

    private static ArrayList<CrewMember> createCrewMemberList(String playersName) {
        ArrayList<CrewMember> crew = new ArrayList<>();

        CrewController crewCon = new CrewController();

        CrewMember crewOne = new CrewMember();
        CrewMember crewTwo = new CrewMember();
        CrewMember crewThr = new CrewMember();
        CrewMember crewFou = new CrewMember();
        CrewMember crewFiv = new CrewMember();
        CrewMember captain = new CrewMember();

        crewCon.setStat(crewOne, TRADER, 4);
        crewCon.setStat(crewTwo, FIGHTER, 4);
        crewCon.setStat(crewThr, DOCTOR, 4);
        crewCon.setStat(crewFou, MECHANIC, 4);
        crewCon.setStat(crewFiv, PILOT, 4);

        crewCon.name(captain, playersName);
        crewCon.name(crewOne, "Spock");
        crewCon.name(crewTwo, "Kirk");
        crewCon.name(crewThr, "Bones");
        crewCon.name(crewFou, "McCoy");
        crewCon.name(crewFiv, "Sulu");

        crewCon.heal(captain, 30);
        crewCon.heal(crewOne, 30);
        crewCon.heal(crewTwo, 30);
        crewCon.heal(crewThr, 30);
        crewCon.heal(crewFou, 30);
        crewCon.heal(crewFiv, 30);

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

        Item bandages = new Item("Super Bandages", 12);
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

    private static ArrayList<JobBoard> createJobsBoard() {

        ArrayList<JobBoard> jobs = new ArrayList<>();

        JobBoard fight = new JobBoard("Fight Pirates", Kryta, "Kryta", 250);

        JobBoard mine = new JobBoard("Mine Ore", Kryta, "Kryta", 150);

        JobBoard find = new JobBoard("Find Parts", Kryta, "Kryta", 200);

        JobBoard trade = new JobBoard("Trade 3 Space Ore", Kryta, "Kryta", 100);

        jobs.add(0, fight);
        jobs.add(1, mine);
        jobs.add(2, find);
        jobs.add(3, trade);

        return jobs;
    }

    public boolean gameControl() {
        return true;
    }

}
