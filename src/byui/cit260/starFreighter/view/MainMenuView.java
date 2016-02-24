/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.controller.GameControl;
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
class MainMenuView extends View{

    public MainMenuView() {
        super("\n"
            + "\n--------------------------------"
            + "\n| Main Menu                    |"
            + "\n--------------------------------"
            + "\nG - Start Game"
            + "\nH - Help Menu"
            + "\nL - Load Saved Game"
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
            case 'E':
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
       
        }
        return false;
    }

    private void startNewGame() {
     //   GameControl.createNewGame(StarFreighter.getPlayer());
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        System.out.println("\n*** startExistingGame() stub function called ***");
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

}
