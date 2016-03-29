package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.ItemList;
import java.io.Serializable;
import java.util.Objects;

/**
 * A basic data structure for items in an inventory.
 */
public class InventoryItem implements Serializable {
    /**
     * Class instance members.
     */
    private String name;
    private int value;

    /**
     * Class constructor.
     * @param name
     * @param value 
     */
    public InventoryItem(String name, int value) {
        this.name = name;
        this.value = value;
    }
    
    /**
     * Alternative class constructor.
     * @param item 
     */
    public InventoryItem(ItemList item) {
        this.name = item.getName();
        this.value = item.getValue();
    }

    /**
     * Gets the item's name.
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the item's name.
     * @param newName 
     */
    public void setName(String newName) {
        name = newName;
    }
    
    /**
     * Gets the item's value.
     * @return 
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Sets the item's value.
     * @param newValue 
     */
    public void setValue(int newValue) {
        value = newValue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + this.value;
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
        final InventoryItem other = (InventoryItem) obj;
        if (this.value != other.value) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return "InventoryItem{" + "name=" + name + ", value=" + value + '}';
    }
}