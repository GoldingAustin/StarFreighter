/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;


import byui.cit260.starFreighter.controller.CrewController;
import byui.cit260.starFreighter.model.CrewMember;
import static byui.cit260.starFreighter.model.CrewMember.captain;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author austingolding
 */
public final class StartProgramView {
    
    
    private final String promptMessage;
    private boolean doAction;
    private String playersName;
    

    public StartProgramView() {
        this.promptMessage = "\nPlease enter your name: ";
        this.displayBanner();
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

    public void displayStartProgramView() {
        boolean done = false;
        do {
            
            playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(playersName);
        } while (!done);
    }

    public String getPlayersName() {
        Scanner keyboard = new Scanner(in);
        String value = "";
        
        boolean valid = false;
        while(!valid) {
            
            out.println(this.promptMessage);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                out.println("Invalid value - the value can not be blank");
                continue;
            }
            valid = true;
        }
        return value;
    }

    private boolean doAction(String playersName) {
        
        if (playersName.length() < 2) {
            out.println("\nInvalid players name: "
                    + "The name must be greater than one character in length");
            return false;
        }
        
        CrewController crewCon = new CrewController();
        crewCon.name(captain, playersName);

        if (captain == null) {
            out.println("\nError creating the player.");
            return false;
        }
        
        this.displayNextView(captain);
        
        return true;
    }

    private void displayNextView(CrewMember captain) {
        out.println("\n================================="
                          +"\n Welcome to the game, " + captain.getName() + "!"
                          +"\n Good luck in your adventures!"
                          +"\n================================="
                          );
        
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.display();
    }
}
