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
    private static CrewController player = null;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //  MapMenuView test = new MapMenuView();
      //  test.display();
        StartProgramView startProgram = new StartProgramView();
        startProgram.displayStartProgramView();
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        StarFreighter.currentGame = currentGame;
    }

    public static CrewController getPlayer() {
        return player;
    }

    public static void setPlayer(CrewController player) {
        StarFreighter.player = player;
    }
   
}
