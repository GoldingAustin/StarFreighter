/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import static byui.cit260.starFreighter.controller.CrewController.captain;
import static byui.cit260.starFreighter.controller.CrewController.crewFou;
import static byui.cit260.starFreighter.controller.CrewController.crewOne;
import static byui.cit260.starFreighter.controller.CrewController.crewThr;
import static byui.cit260.starFreighter.controller.CrewController.crewTwo;
import byui.cit260.starFreighter.model.CrewMember;


/**
 *
 * @author austingolding
 */
class CrewMenuView extends View {

    public CrewMember crew;
    public CrewMenuView() {
        super("\n"
                + "\n--------------------------------"
                + "\n| Crew Customizaion Menu        |"
                + "\n--------------------------------"
                + "\nC - Captain"
                + "\n1 - Crew 1"
                + "\n2 - Crew 2"
                + "\n3 - Crew 3"
                + "\n4 - Crew 4"
                + "\nE - Exit"
                + "\n--------------------------------");
    }

    @Override
    public boolean doAction(Object obj) {

        String value = (String) obj;
        char choice = value.charAt(0);

        switch (choice) {
            case 'C':
                this.displayStatMenu(captain);
                break;
            case '1':
                this.displayStatMenu(crewOne);
                break;
            case '2':
                this.displayStatMenu(crewTwo);
                break;
            case '3':
                this.displayStatMenu(crewThr);
                break;
            case '4':
                this.displayStatMenu(crewFou);
                break;
            case 'E':
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;

        }
        return false;
    }

    
    private void startExistingGame() {
        System.out.println("\n*** startExistingGame() stub function called ***");
    }

    private void displayStatMenu(CrewMember crew) {
        StatMenuView statMenu = new StatMenuView(crew);       
        statMenu.display(crew);
    }

    void displayMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public CrewMember getCrew() {
        return crew;
    }

    public void setCrew(CrewMember crew) {
        this.crew = crew;
    }
    
    

}
