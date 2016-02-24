/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starfreighter;

import byui.cit260.starFreighter.model.*;
import byui.cit260.starFreighter.controller.*;
import byui.cit260.starFreighter.view.*;

/**
 *
 * @author austingolding
 */
public class StarFreighter {
    private static Game currentGame = null;
    private static CrewMember player = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MapMenuView test = new MapMenuView();
        test.displayMenu();
        //StartProgramView startProgram = new StartProgramView();
        //startProgram.displayStartProgramView();
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        StarFreighter.currentGame = currentGame;
    }

    public static CrewMember getPlayer() {
        return player;
    }

    public static void setPlayer(CrewMember player) {
        StarFreighter.player = player;
    }

    public static void setPlayer(CrewController player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}