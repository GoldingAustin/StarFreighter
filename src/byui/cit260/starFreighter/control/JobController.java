package byui.cit260.starFreighter.control;

import byui.cit260.starFreighter.model.JobRegistry;

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
    public static JobRegistry createJobList() {
        return new JobRegistry();
    }
}