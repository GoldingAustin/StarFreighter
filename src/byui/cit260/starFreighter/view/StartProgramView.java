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
        out.println(
             "\n***************************************************************"
           + "\n*                                                             *"
           + "\n* You are a newly dubbed captain.                             *"
           + "\n* A deep space phenomenon has been observered which could     *"
           + "\n* be the key to finding an ancient alien treasure. You're     *"
           + "\n* not the first captain to hear about it, you have to hurry!  *"
           + "\n* There's no chance your ship can get there first with the    *"
           + "\n* state it's in.                                              *"
           + "\n*                                                             *"
           + "\n* You're in luck that jobs are popping up all over the galaxy.*"                                                        
           + "\n* Travel to distance planets completing jobs and fighting     *"
           + "\n* enemies so you can upgrade your ship. There's no time to    *"
           + "\n* wait, the other captains are on their way to the treasure   *"
           + "\n*                                                             *"
           + "\n* Riches await you out there, it's your chance to become      *"
           + "\n* a legend. Do you have what it takes?                        *"
           + "\n*                                                             *"         
           + "\n***************************************************************"
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
