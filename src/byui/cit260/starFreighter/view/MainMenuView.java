/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.controller.GameControl;
import static byui.cit260.starFreighter.controller.GameControl.save;
import byui.cit260.starFreighter.exceptions.GameControlExceptions;
import java.io.IOException;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import starfreighter.StarFreighter;
import static starfreighter.StarFreighter.getPlayer;

/**
 *
 * @author austingolding
 */
public class MainMenuView extends View {

    public MainMenuView() {
        super("\n"
                + "\n--------------------------------"
                + "\n| Main Menu                    |"
                + "\n--------------------------------"
                + "\nG - Start Game"
                + "\nL - Load Saved Game"
                + "\nZ – Save Game"
                + "\nH - Help Menu"
                + "\nE - Exit"
                + "\n--------------------------------");
    }

    @Override
    public boolean doAction(Object obj) {

        String value = (String) obj;
        char choice = value.charAt(0);

        switch (choice) {
            case 'G':
                this.startNewGame();
                break;
            case 'L':
                this.startExistingGame();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'Z':
                this.saveGame();
                break;
            case 'E':
                return true;
            default:
                out.println("\n*** Invalid selection *** Try again");
                break;

        }
        return false;
    }

    private void startNewGame() {
        GameControl.createNewGame(getPlayer());
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        try {
            GameControl.loadGame();
            out.println("File successfully loaded from " + save);
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.display();
        } catch (GameControlExceptions | IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            MainMenuView mainMenu = new MainMenuView();
            mainMenu.display();
        }
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void saveGame() {
        try {
            GameControl.saveGame(StarFreighter.getCurrentGame());
            out.println("File successfully saved at " + save);
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.display();
        } catch (GameControlExceptions ex) {
            out.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
