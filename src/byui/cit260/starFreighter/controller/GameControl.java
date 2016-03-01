/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.exceptions.GameControlExceptions;
import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.Game;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static starfreighter.StarFreighter.setCurrentGame;
import static starfreighter.StarFreighter.setPlayer;

/**
 *
 * @author austingolding
 */
public class GameControl {
    public static Game game;


    public static CrewController createPlayer(String playersName) {
        
        if (playersName == null) {
            return null;
        }
        
        CrewController player = new CrewController();
        CrewMember captain = new CrewMember();
        player.name(captain, playersName);
        
        setPlayer(player);
        
        return player;
    }

    public static void createNewGame(CrewController player) {
        
    }
    
    public static void saveGame(CrewController player, String file) throws GameControlExceptions {
             try (FileOutputStream fop = new FileOutputStream(file)){
            ObjectOutputStream output = new ObjectOutputStream(fop);
            
            output.writeObject(game);
        } catch (IOException excep){
            throw new GameControlExceptions(excep.getMessage());
        } 
    }

        public static void loadGame(String file) throws GameControlExceptions {
        Game game = null;
         try(FileInputStream fip = new FileInputStream(file)){
             ObjectInputStream output = new ObjectInputStream(fip);
             
             game = (Game) output.readObject();
         }catch (FileNotFoundException filenot){
             throw new GameControlExceptions(filenot.getMessage());
         }catch(Exception excep){
             throw new GameControlExceptions(excep.getMessage());
         }
         setCurrentGame(game);
    }

    public boolean GameControl() {
        return true;
    }
    
        
}
