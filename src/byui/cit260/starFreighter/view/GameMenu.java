package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.MenuItem;

/**
 * The in-game menu view.
 */
public final class GameMenu extends MenuView {
    /**
     * Class properties. Additional views called by this view.
     */
    private final ShipMenu shipMenu = new ShipMenu();
    private final CrewMenu crewMenu = new CrewMenu();
    private final InventoryMenu inventoryMenu = new InventoryMenu();
    private final HelpMenu helpMenu = new HelpMenu();
    
    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public GameMenu() {
        menuTitle = "Game Menu";
        menuItems.add(new MenuItem('S', "Ship"));
        menuItems.add(new MenuItem('C', "Crew"));
        menuItems.add(new MenuItem('T', "Travel"));
        menuItems.add(new MenuItem('I', "Inventory"));
        menuItems.add(new MenuItem('H', "Help"));
        menuItems.add(new MenuItem('E', "Exit to main menu"));
    }
    
    /**
     * Displays a game over message.
     */
    private void displayGameOver() {
        TextBox.displayText(
            "Your ship was destroyed and your quest is at an end. Perhaps " +
                "your next venture will be more successful?",
            "GAME OVER"
        );
    }

    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'S': {
                shipMenu.display();
                break;
            }
            case 'C': {
                crewMenu.display();
                break;
            }
            case 'T': {
                // Display the travel view.
                TravelView.display();
                
                // Did the player die?
                if (ShipController.getShip().getHull() <= 0) {
                    displayGameOver();
                    return true;
                }
                break;
            }
            case 'I': {
                inventoryMenu.display();
                break;
            }
            case 'H': {
                helpMenu.display();
                break;
            }
            case 'E': {
                return true;
            }
            default: {
                CONSOLE.println(INVALID);
                break;
            }
        }
        return false;
    }
}