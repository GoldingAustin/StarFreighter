/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

/**
 *
 * @author austingolding
 */
class GameMenuView extends View {

    public GameMenuView() {
        super("\n"
                + "\n--------------------------------"
                + "\n| Game Menu                     |"
                + "\n--------------------------------"
                + "\nS – Ship Control"
                + "\nC – Captain and Crew"
                + "\nM – Map Menu"
                + "\nX – Inventory and Merchant"
                + "\nH - Help Menu"
                + "\nZ – Save Game"
                + "\nE - Exit to main menu"
                + "\n--------------------------------");
    }

    @Override
    public boolean doAction(Object obj) {

        String value = (String) obj;
        char choice = value.charAt(0);

        switch (choice) {
            case 'S':
                this.ShipMenuView();
                break;
            case 'C':
                this.CrewMenuView();
                break;
            case 'M':
                this.MapMenuView();
                break;
            case 'X':
                this.InmeMenuView();
                break;
            case 'H':
                this.displayHelpMenu();
                break;
            case 'Z':

                break;
            case 'E':
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;

        }
        return false;
    }

    private void ShipMenuView() {
        ShipMenuView shipMenu = new ShipMenuView();
        shipMenu.displayMenu();
    }

    private void CrewMenuView() {
        CrewMenuView crewMenu = new CrewMenuView();
        crewMenu.display();
    }

    private void MapMenuView() {
        MapMenuView mapMenu = new MapMenuView();
        mapMenu.display();
    }

    private void InmeMenuView() {
        InmeMenuView inmeMenu = new InmeMenuView();
        inmeMenu.displayMenu();
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void displayMainMenu() {
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
    }
}
