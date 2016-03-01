/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;


import byui.cit260.starFreighter.model.CrewMember;
import static byui.cit260.starFreighter.model.CrewMember.captain;
import static byui.cit260.starFreighter.model.CrewMember.crewFou;
import static byui.cit260.starFreighter.model.CrewMember.crewOne;
import static byui.cit260.starFreighter.model.CrewMember.crewThr;
import static byui.cit260.starFreighter.model.CrewMember.crewTwo;
import static java.lang.System.out;


/**
 *
 * @author austingolding
 */
class CrewMenuView extends View {

    CrewMember crew = new CrewMember();
    public CrewMenuView() {
        super("\n"
                + "\n--------------------------------"
                + "\n| Crew Customizaion Menu        |"
                + "\n--------------------------------"
                + "\nC - Captain: " + captain.getName()
                + "\n1 - Crew 1: " + crewOne.getName()
                + "\n2 - Crew 2: " + crewTwo.getName()
                + "\n3 - Crew 3: " + crewThr.getName()
                + "\n4 - Crew 4: " + crewFou.getName()
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
                out.println("\n*** Invalid selection *** Try again");
                break;

        }
        return false;
    }

    
    private void startExistingGame() {
        out.println("\n*** startExistingGame() stub function called ***");
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
