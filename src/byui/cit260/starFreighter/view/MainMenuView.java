/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import static java.lang.System.out;

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
     //   GameControl.createNewGame(StarFreighter.getPlayer());
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        out.println("\nPlease enter the file path in which you'd like to save your game");
    String file = this.getInput();
    
    GameMenuView gameMenu = new GameMenuView();
    gameMenu.display();   
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void saveGame() {
        out.println("\nPlease enter the file path in which you'd like to save your game");
    String file = this.getInput();
    
    }

}
