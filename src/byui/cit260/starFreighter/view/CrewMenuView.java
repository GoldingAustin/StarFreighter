/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.CrewMember;

import static java.lang.System.out;
import java.util.ArrayList;
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
class CrewMenuView extends View {

    private static final ArrayList<CrewMember> crew = StarFreighter.getCurrentGame().getCrewCon();

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

}
