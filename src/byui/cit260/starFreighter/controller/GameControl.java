/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.CombatEncounter;
import byui.cit260.starFreighter.model.Coordinates;
import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.Game;
import byui.cit260.starFreighter.model.Item;
import byui.cit260.starFreighter.model.JobBoard;
import byui.cit260.starFreighter.model.Location;
import byui.cit260.starFreighter.model.MerchantStock;
import byui.cit260.starFreighter.model.Planet;
import byui.cit260.starFreighter.model.Ship;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import starfreighter.StarFreighter;
import static starfreighter.StarFreighter.setPlayer;

/**
 *
 * @author austingolding
 */
public class GameControl {
        public static CrewController crewCon = new CrewController();
    public static CrewMember crewOne = new CrewMember();
    public static CrewMember crewTwo = new CrewMember();
    public static CrewMember crewThr = new CrewMember();
    public static CrewMember crewFou = new CrewMember();
    public static CrewMember crewFiv = new CrewMember();
    public static CrewMember captain = new CrewMember();

    public static Game game;

    public static CrewController createPlayer(String playersName) {

        if (playersName == null) {
            return null;
        }

        CrewController player = new CrewController();
        CrewMember captain = new CrewMember();
        player.name(captain, playersName);

        setPlayer(captain);

        return player;
    }

    public static void createNewGame(CrewMember captain) {

        StarFreighter.setCurrentGame(game);

        CombatEncounter combat = new CombatEncounter();
        Coordinates coorD = new Coordinates(0, 0);
        crewCon = GameControl.createCrewMemberList();
       // Item[] item = GameControl.createItemList();
        JobBoard jobs = new JobBoard();
      //  Location[] location = GameControl.createLocationList();
        MerchantStock merch;

        Ship ship;
    }

    public static void saveGame(Game game, String file) {
        try (FileOutputStream fop = new FileOutputStream(file + "/StarFreighterSave.data")) { 
            ObjectOutputStream output = new ObjectOutputStream(fop);

            output.writeObject(game);
        } catch (IOException ex) {
            Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loadGame(String file) throws IOException {
        Game game = null;
        try (FileInputStream fip = new FileInputStream(file + "/StarFreighterSave.data")){
            ObjectInputStream output = new ObjectInputStream(fip);

           game = (Game) output.readObject();
        }
         catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(GameControl.class.getName()).log(Level.SEVERE, null, ex);
            }
             StarFreighter.setCurrentGame(game);
    }  
    

    private static CrewController createCrewMemberList() {

        crewOne.setTrader(4);
        crewTwo.setFighter(4);
        crewThr.setDoctor(4);
        crewFou.setMechanic(4);
        crewFiv.setPilot(4);

        crewOne.setHitPoints(30);
        crewTwo.setHitPoints(30);
        crewThr.setHitPoints(30);
        crewFou.setHitPoints(30);
        crewFiv.setHitPoints(30);

        crewCon.name(crewOne, "Spock");
        crewCon.name(crewTwo, "Kirk");
        crewCon.name(crewThr, "Bones");
        crewCon.name(crewFou, "McCoy");
        crewCon.name(crewFiv, "Sulu");
        
        
        return crewCon;
    }

    private static Item[] createItemList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Location[] createLocationList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean gameControl() {
        return true;
    }

}
