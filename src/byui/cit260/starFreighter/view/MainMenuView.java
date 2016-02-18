/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.controller.GameControl;
import java.util.Scanner;
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
class MainMenuView {

    private final String MENU = "\n"
            + "\n--------------------------------"
            + "\n| Main Menu                    |"
            + "\n--------------------------------"
            + "\nG - Start Game"
            + "\nH - Help Menu"
            + "\nL - Load Saved Game"
            + "\nE - Exit"
            + "\n--------------------------------";

    public void displayMenu() {

        char selection = ' ';
        do {
            System.out.println(MENU);

            String input = this.getInput();
            selection = input.charAt(0);

            this.doAction(selection);

        } while (selection != 'E');
    }

    private String getInput() {
        Scanner keyboard = new Scanner(System.in);
        String value = "";

        boolean valid = false;
        while (!valid) {

            System.out.println("What do you want to do?");

            value = keyboard.nextLine();
            value = value.trim();

            if (value.length() != 1) {
                System.out.println("Invalid input - The value must be one letter");
                continue;
            }
            valid = true;
        }
        return value;
    }

    private void doAction(char value) {

        switch (value) {
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
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;

        }
    }

    private void startNewGame() {
        GameControl.createNewGame(StarFreighter.getPlayer());

        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    private void startExistingGame() {
        System.out.println("\n*** startExistingGame() stub function called ***");
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayMenu();
    }

}
