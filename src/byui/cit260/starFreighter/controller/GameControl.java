/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.CrewMember;
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
public class GameControl {



    public static CrewController createPlayer(String playersName) {
        
        if (playersName == null) {
            return null;
        }
        
        CrewController player = new CrewController();
        CrewMember captain = new CrewMember();
        player.name(captain, playersName);
        
        StarFreighter.setPlayer(player);
        
        return player;
    }

    public static void createNewGame(CrewController player) {
        
    }


    
}
