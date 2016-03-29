package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.MenuItem;

/**
 *
 */
public final class JobMenu extends MenuView {
    /**
     * Class constructor. Sets menu title and defines all menu items.
     */
    public JobMenu() {
        menuTitle = "Job Menu";
        menuItems.add(new MenuItem('A', "Available jobs"));
        menuItems.add(new MenuItem('C', "Currently active jobs"));
        menuItems.add(new MenuItem('T', "Take job"));
        menuItems.add(new MenuItem('E', "Exit"));
    }
    
    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'A': {
                // something
                break;
            }
            case 'C': {
                // something
                break;
            }
            case 'T': {
                // something
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