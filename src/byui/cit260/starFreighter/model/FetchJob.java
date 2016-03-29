package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.FetchJobList;
import java.io.Serializable;

/**
 * A basic data model for jobs that involve acquiring or trading something.
 */
public class FetchJob extends Job implements JobInterface, Serializable {
    /**
     * Class constants.
     */
    private final int quantity;
    
    /**
     * Class members.
     */
    private int acquired;
    
    /**
     * Class constructor.
     * @param job 
     */
    public FetchJob(FetchJobList job) {
       super(job);
       this.quantity = job.getQuantity();
    }
    
    /**
     * Gets the number of items fetched for this job.
     * @return 
     */
    public int getAcquired() {
        return acquired;
    }
    
    /**
     * Sets the number of items fetched for this job.
     * @param value 
     */
    public void setAcquired(int value) {
        acquired = value;
    }
    
    @Override
    public void progress() {
        
    }
}