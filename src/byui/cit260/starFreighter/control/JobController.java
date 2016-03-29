package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.JobRegistry;
import starfreighter.StarFreighter;

/**
 * A job controller.
 */
public class JobController {
    
    /**
     * Private constructor prevents instantiation.
     */
    private JobController() {
        
    }
    
    /**
     * Creates a new job list.
     * @return 
     */
    public static JobRegistry createJobRegistry() {
        return new JobRegistry();
    }
    
    /**
     * Gets the player's job list.
     * @return 
     */
    public JobRegistry getJobList() {
        return StarFreighter.getCurrentGame().getJobRegistry();
    }
}