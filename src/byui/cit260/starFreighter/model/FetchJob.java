package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.ItemList;
import java.io.Serializable;
import java.util.Objects;

/**
 * 
 */
public class FetchJob extends Job implements JobInterface, Serializable {
    // Class constants.
    private final String itemName;
    private final int quantity;
    
    /**
     * Class constructor.
     * @param item
     * @param quantity 
     */
    public FetchJob(ItemList item, int quantity) {
        this.itemName = item.getName();
        this.quantity = quantity;
    }
    
    /**
     *
     */
    @Override
    public void progress() {
        
    }
    
    /**
     * Gets the target item name.
     * @return 
     */
    public String getItemName() {
        return itemName;
    }
    
    /**
     * Gets the target item quantity.
     * @return 
     */
    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.itemName);
        hash = 61 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FetchJob other = (FetchJob) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        return Objects.equals(this.itemName, other.itemName);
    }

    @Override
    public String toString() {
        return "FetchJob{" + "itemName=" + itemName + ", quantity=" + quantity + '}';
    }
}