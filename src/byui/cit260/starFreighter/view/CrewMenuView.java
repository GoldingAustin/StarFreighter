/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.CrewMember;

/**
 *
 * @author austingolding
 */
class CrewMenuView extends View {

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
                CrewMember captain = new CrewMember();
                this.displayStatMenu(CrewMember captain);
                break;
            case '1':
                CrewMember captain = new CrewMember();
                this.displayStatMenu(CrewMember crew1);
                break;
            case '2':
                this.displayStatMenu(CrewMember crew2);
                break;
            case '3':
                this.displayStatMenu(CrewMember crew3);
                break;
            case '4':
                this.displayStatMenu(CrewMember crew4);
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

    private void displayStatMenu(Object crw) {
        
        StatMenuView statMenu = new StatMenuView(Object crw);
        statMenu.display();
    }

    void displayMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
