/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.Ship;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
class CrewMenuView extends View {

    private static final ArrayList<CrewMember> crew = StarFreighter.getCurrentGame().getCrewCon();
    Ship ship = new Ship();
    
    public CrewMenuView() {

        super("\n"
                + "\n--------------------------------"
                + "\n| Crew Customizaion Menu        |"
                + "\n--------------------------------"
                + "\nC - Captain: " + crew.get(0).getName()
                + "\n1 - Crew 1: " + crew.get(1).getName()
                + "\n2 - Crew 2: " + crew.get(2).getName()
                + "\n3 - Crew 3: " + crew.get(3).getName()
                + "\n4 - Crew 4: " + crew.get(4).getName()
                + "\n4 - Crew 5: " + crew.get(5).getName()
                + "\nR - Get Crew Report"
                + "\nE - Exit"
                + "\n--------------------------------");
    }

    @Override
    public boolean doAction(Object obj) {

        String value = (String) obj;
        char choice = value.charAt(0);

        switch (choice) {
            case 'C':
                this.displayStatMenu(crew.get(0));
                break;
            case '1':
                this.displayStatMenu(crew.get(1));
                break;
            case '2':
                this.displayStatMenu(crew.get(2));
                break;
            case '3':
                this.displayStatMenu(crew.get(3));
                break;
            case '4':
                this.displayStatMenu(crew.get(4));
                break;
            case '5':
                this.displayStatMenu(crew.get(5));
                break;
            case 'R':
                this.crewReport();
                break;
            case 'E':
                return true;
            default:
                console.println("\n*** Invalid selection *** Try again");
                break;

        }
        return false;
    }

    private void startExistingGame() {
        console.println("\n*** startExistingGame() stub function called ***");
    }

    private void displayStatMenu(CrewMember crew) {
        StatMenuView statMenu = new StatMenuView(crew);
        statMenu.display(crew);
    }
    
        private void crewReport() {
        console.println("Filepath to save report to:");
        String filePath =  promptFilePath() + File.separator + "crewreport.txt";
        writeReportToFile(filePath);
        console.println("Crew Report successfully printed at " + filePath);
    }
    
    private String promptFilePath() {
        String value = null;
        try {
            value = this.keyboard.readLine();
            value = value.trim();
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        return value;
    }
    
    private void writeReportToFile(String filePath) {
        try(PrintWriter out = new PrintWriter(filePath)) {
            out.println("\n\n      Crew Report");
            out.printf("%n%-20s%20s%20s%20s%20s%20s%20s", "Name", "HitPoints", "Pilot Points", "Fighter Points", "Doctor Points", "Mechanic Points", "Trader Points");
            out.printf("%n%-20s%20s%20s%20s%20s%20s%20s", "--------------------", "-------", "-------", "-------", "-------", "-------", "-------");
            for (CrewMember current : crew) {
                out.printf("%n%-20s%20s%20s%20s%20s%20s%20s", current.getName(), current.getHitPoints(), current.getPilot(), current.getFighter(), current.getDoctor(), current.getMechanic(), current.getTrader());
            }
        } catch (IOException ex) {
            Logger.getLogger(CrewMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
