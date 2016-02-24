/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import java.util.Scanner;

/**
 *
 * @author austingolding
 */
class HelpMenuView extends View{

    public HelpMenuView(String message) {
        super(message);
    }


    private void doAction(char value) {
        switch (value) {
            case 'G':
                System.out.println("\nYou are a spaceship captain desiring to be "
                        + "\nThe best and wealthiest in the galaxy. A deep-space"
                        + "\nphenomena has occurred which could lead you to an "
                        + "\nancient alien treasure. You need to earn money "
                        + "\nby completing jobs and selling items to upgrade your"
                        + "\nship.");
                break;
            case 'C':
                System.out.println("\nThere are five roles on your ship"
                        + "\n"
                        + "\n*Pilot: The better they are the faster you travel"
                        + "\nand the less fuel you use"
                        + "\n"
                        + "\n*Mechanic: Upgrades are cheaper and repairs are as "
                        + "\nas well. They might even add some bonus upgrades."
                        + "\n"
                        + "\n*Fighter: Who needs brains when you can beat anyone"
                        + "\nin a fight? The better the fighter the quicker you'll"
                        + "\ndefeat your enemies"
                        + "\n"
                        + "\n*Doctor: When your ego is hurt or you're just injured,"
                        + "\nthe doctor will have you up and going quicker than "
                        + "\nWebMD."
                        + "\n"
                        + "\n*Trader: Who doesn't love some bartering? Sell for "
                        + "\nmore and buy for less."
                        + "\n");
                break;
            case 'I':
                System.out.println("\nYou can access the jobs boards on any planet."
                        + "\nYou'll be given a task to complete and rewarded on"
                        + "\ncompletion. You may receive parts you need for your"
                        + "\nship, money, or items you can sell. Merchants can be "
                        + "\naccessed any time from the game menu.");
                break;
            case 'T':
                System.out.println("\nYou can access the map anytime in the game"
                        + "\nmenu. Each location has a specific distance and fuel"
                        + "\ncost. You don't want to run out of fuel on your way"
                        + "\nto a planet.");
                break;
            case 'R':
                System.out.println("\nMerchants can be accessed in the game menu."
                        + "\nYou can sell items you don't need or buy what you "
                        + "\nneed. You need to upgrade your ship to be able to "
                        + "\nmake it to the phenomena. You can earn parts from"
                        + "\njobs or buy them from merchants. Your ship might get"
                        + "\ndamaged in your travels, you can use parts to repair"
                        + "\nyour ship as well. Repairs and Upgrades options are"
                        + "\nin the game menu.");
                break;
            case 'E':
                this.displayMainMenu();
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;

        }

    }

    private void displayMainMenu() {
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.displayMenu();
    }

    @Override
    public boolean doAction(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
