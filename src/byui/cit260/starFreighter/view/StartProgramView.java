/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.controller.GameControl;
import byui.cit260.starFreighter.model.Player;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author austingolding
 */
public final class StartProgramView {


    private boolean doAction;

    public void StartProgramView() {

        this.displayBanner();

        String playersName = this.getPlayersName();

        Player player = GameControl.createPlayer(playersName);

        this.displayNextView(player);

        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();

    }

    public void displayBanner() {
        TextBox.displayText(
            "You are a newly dubbed captain.",
            "A deep space phenomenon has been observed which could be the key" +
                " to finding an ancient alien treasure. You're not the first" +
                " captain to hear about it, you have to hurry! There's no" +
                " chance your ship can get there first with the state it's in.",
            "You're in luck that jobs are popping up all over the galaxy." +
                " Travel to distant planets completing jobs and fighting" +
                " enemies so you can upgrade your ship. There's no time to" +
                " wait, the other captains are on their way to the treasure!",
            "Riches await you out there, it's your chance to become a legend." +
                " Do you have what it takes?"
        );
    }

    public String getPlayersName() {

        Scanner keyboard = new Scanner(in);
        String value = "";

        boolean valid = false;
        while (!valid) {
            System.out.println("\nPlease enter your name: ");

            value = keyboard.nextLine();
            value = value.trim();

            if (value.length() < 2) {
                out.println("\nInvalid players name: "
                        + "The name must be greater than one character in length");
                continue;
            }
            valid = true;
        }
        return value;
    }

    private void displayNextView(Player player) {
        out.println("\n================================="
                + "\n Welcome to the game, " + player.getName() + "!"
                + "\n Good luck in your adventures!"
                + "\n================================="
        );

    }
}
