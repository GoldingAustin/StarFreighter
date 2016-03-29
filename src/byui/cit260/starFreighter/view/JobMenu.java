package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.JobController;
import byui.cit260.starFreighter.model.Job;
import byui.cit260.starFreighter.model.JobRegistry;
import byui.cit260.starFreighter.model.MenuItem;
import java.util.ArrayList;

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
    
    /**
     * Displays the jobs available at the player's current location.
     * @todo Pretty up this display some.
     */
    private void displayAvailableJobs() {
        ArrayList<Job> available = JobController.getAvailableJobs().get();
        available.stream().forEach((current) -> {
            CONSOLE.println(current.getName() + " - " + current.getDesc());
        });
    }
    
    @Override
    public boolean doAction(char action) {
        switch (action) {
            case 'A': {
                displayAvailableJobs();
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