package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.JobController;
import byui.cit260.starFreighter.model.Job;
import byui.cit260.starFreighter.model.MenuItem;
import java.io.IOException;
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
    
    private void takeJob() {
        ArrayList<Job> available = JobController.getAvailableJobs().get();
          try {
          int index = 1;
          for (Job current : available) {
                // Pad the index with a leading zero for readability's sake.
                CONSOLE.write("[");
                if (index < 10) {
                    CONSOLE.write("0");
                }
                CONSOLE.write(index + "] - " + current.getName() + "\t");
                CONSOLE.write(current.getDesc() + "\n");
                CONSOLE.flush();
                // Increment the index.
                index++;
            }

            // Offset the selection by minus one to make it "computer-readable."
            int selection = Input.getIntSameLine("Choose a Job to take: ") - 1;
            
            // Get the item to sell.
            Job toTake = available.get(selection);

            // If the user got smart and gave us a number that doesn't exist
            // in the inventory ArrayList indices, we need to catch the
            // impending error in addition to the IO exception potentially
            // thrown by Input class's methods.

            
            // Display an explanatory message.
            TextBox.displayText(
                "You took the job " +
                toTake.getName() +
                ". Return when you have completed: " +
                toTake.getDesc()  +
                " " 
            );
        } catch (IOException | IndexOutOfBoundsException error) {
            ErrorView.display(this.getClass().getName(), error.getMessage());
        }
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
                takeJob();
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