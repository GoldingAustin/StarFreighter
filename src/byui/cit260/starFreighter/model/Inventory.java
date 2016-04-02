package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.constants.ItemList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A data structure to encapsulate collections of items- inventories.
 */
public class Inventory implements Serializable {
    /**
     * Class members.
     */
    private ArrayList<InventoryItem> contents;
    private int currency;
    
    /**
     * Class constructor.
     */
    public Inventory() {
        contents = new ArrayList<>();
        currency = 0;
    }
    
    /**
     * Gets the inventory's currency.
     * @return 
     */
    public int getCurrency() {
        return currency;
    }
    
    /**
     * Sets the inventory's currency.
     * @param value 
     */
    public void setCurrency(int value) {
        currency = value;
    }
    
    /**
     * Adds to the inventory's currency.
     * @param value 
     */
    public void addCurrency(int value) {
        setCurrency(value + getCurrency());
    }
    
    /**
     * Removes from the inventory's currency.
     * @param value 
     */
    public void removeCurrency(int value) {
        setCurrency(getCurrency() - value);
    }
    
    /**
     * Gets the contents of the inventory.
     * @return 
     */
    public ArrayList<InventoryItem> getContents() {
        return contents;
    }
    
    /**
     * Sets the inventory's contents.
     * @param contents 
     */
    public void setContents(ArrayList<InventoryItem> contents) {
        this.contents = contents;
    }
    
    /**
     * Adds an item to the inventory.
     * @param item 
     */
    public void addItem(InventoryItem item) {
        contents.stream().filter((current) -> (current.getName().equals(item.getName()))).forEach((current) -> {
            current.setQuantity(current.getQuantity() + 1);
        });
        contents.add(item);
    }
    
    /**
     * Adds an item to the inventory.
     * @param item 
     */
    public void addItem(ItemList item) {

        InventoryItem newItem = new InventoryItem(item.getName(), item.getValue(), item.getQuantity());
        contents.add(newItem);
    }
    
    /**
     * Removes an item from the inventory.
     * @param item 
     */
    public void removeItem(InventoryItem item) {
        contents.remove(item);
    }
    
    /**
     * Clears the contents of this inventory.
     */
    public void empty() {
        contents.clear();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.contents);
        hash = 59 * hash + this.currency;
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
        final Inventory other = (Inventory) obj;
        if (this.currency != other.currency) {
            return false;
        }
        return Objects.equals(this.contents, other.contents);
    }

    @Override
    public String toString() {
        return "Inventory{" + "contents=" + contents + ", currency=" + currency + '}';
    }
}