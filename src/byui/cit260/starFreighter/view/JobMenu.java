package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.control.InventoryController;
import byui.cit260.starFreighter.control.JobController;
import byui.cit260.starFreighter.control.ShipController;
import byui.cit260.starFreighter.model.FetchJob;
import byui.cit260.starFreighter.model.Inventory;
import byui.cit260.starFreighter.model.Job;
import byui.cit260.starFreighter.model.MenuItem;
import byui.cit260.starFreighter.model.Planet;
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
        menuItems.add(new MenuItem('T', "Turn in job"));
        menuItems.add(new MenuItem('E', "Exit"));
    }

    /**
     * Displays the jobs available at the player's current location.
     *
     * @todo Pretty up this display some.
     */
    private void displayAvailableJobs() {
        ArrayList<Job> available = JobController.getAvailableJobs().get();
        available.stream().forEach((current) -> {
            if (!current.isComplete()) {
            CONSOLE.println(current.getName() + " - " + current.getDesc());
            }
        });
    }

    private void turnIn() {
        ArrayList<Job> available = JobController.getAvailableJobs().get();
        Planet currentLocation = ShipController.getShip().getLocation();
        Inventory otherInventory = currentLocation.getShop();
        Inventory playerInventory = InventoryController.getPlayerInventory();
        
        try {
            int index = 1;
            for (Job current : available) {
                if (!current.isComplete()) {
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
            }

            // Offset the selection by minus one to make it "computer-readable."
            int selection = Input.getIntSameLine("Choose a Job turn in: ") - 1;

            // Get the job to turn in.
            FetchJob turnIn = (FetchJob) available.get(selection);

            // If the user got smart and gave us a number that doesn't exist
            // in the job ArrayList indices, we need to catch the
            // impending error in addition to the IO exception potentially
            // thrown by Input class's methods.
            if (turnIn.progress(turnIn, otherInventory)) {

                // Display an explanatory message.
                TextBox.displayText("You completed the job "
                        + turnIn.getName()
                        + ". You have earned: "
                        + turnIn.getRewards().getCurrency()
                        + " "
                );
                playerInventory.addCurrency(turnIn.getRewards().getCurrency());
            } else {
                TextBox.displayText("Not enough " + turnIn.getName() + "'s sold, you "
                        + "have sold " + turnIn.getAcquired() + " so far.");
            }
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
            case 'T': {
                turnIn();
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
