/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.CrewMember;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author austingolding
 */
class StatMenuView {

    Scanner keyboard = new Scanner(in);
    protected String displayMessage;

    public StatMenuView(CrewMember crew) {
        this.displayMessage = "\n"
                + "\n--------------------------------"
                + "\n| Crew Stat Menu               |"
                + "\n--------------------------------"
                + "\nP - Pilot"
                + "\nM - Mechanic"
                + "\nF - Fighter"
                + "\nD - Doctor"
                + "\nT - Trader"
                + "\nE - Exit"
                + "\n--------------------------------";
    }

    public void display(CrewMember crew) {
        String value = "";
        boolean done = false;

        do {
            out.println(this.displayMessage);
            value = this.getInput();
            done = this.doAction(value, crew);

        } while (!done);
    }

    public String getInput() {
        boolean valid = false;
        String value = null;

        while (!valid) {

            value = keyboard.nextLine();
            value = value.trim();

            if (value.length() != 1) {
                out.println("Invalid input - The value must be one letter");
                continue;
            }
            break;
        }
        return value;
    }

    public boolean doAction(String value, CrewMember crew) {
        char choice = value.charAt(0);
        switch (choice) {
            case 'P':
                crew.setPilot(crew.getPilot() + 1);
                displayStats(crew);
                break;
            case 'M':
                crew.setMechanic(crew.getMechanic() + 1);
                displayStats(crew);
                break;
            case 'F':
                crew.setFighter(crew.getFighter() + 1);
                displayStats(crew);
                break;
            case 'D':
                crew.setDoctor(crew.getDoctor() + 1);
                displayStats(crew);
                break;
            case 'T':
                crew.setTrader(crew.getTrader() + 1);
                displayStats(crew);
                break;
            case 'E':
                return true;
            default:
                out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void displayStats(CrewMember crew) {
              out.println(crew.getName() + ":");
              out.println("\nPilot: " + crew.getPilot()
               + "\nMechanic:" + crew.getMechanic()
               + "\nFighter:" + crew.getFighter()
               + "\nDoctor:" + crew.getDoctor()
               + "\nTrader:" + crew.getTrader());
    }


}
