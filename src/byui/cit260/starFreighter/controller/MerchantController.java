/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;


import byui.cit260.starFreighter.model.Item;
import byui.cit260.starFreighter.model.MerchantStock;
import static java.lang.System.out;
import java.util.ArrayList;


/**
 *
 * @author Connor
 */
public class MerchantController {
    private final String CURRENCY = "credits";
    
    /**
     *
     */
    public final MerchantStock inventory = new MerchantStock();
    
    /**
     *
     */
    public MerchantController() {
        inventory.setCurrency(100);
    }
    
    /**
     *
     * @param item
     */
    public void addItem(Item item) {
        inventory.addItem(item);
    }
    
    /**
     *
     */
    public void displayCurrency() {
        out.println("Currency: " + inventory.getCurrency() + " " + this.CURRENCY);
    }
    
    public int currency() {
        return inventory.getCurrency();
    }
    
    public String currencyUnit(){
        return this.CURRENCY;
    }
    
    public ArrayList<Item> itemList() {
        return inventory.getItemList();
    }
    
    /**
     * Calculates the total value of the inventory.
     * @return totalValue
     */
    public int calculateTotalValue() {
        int totalValue = 0;
        for (Item current : inventory.getItemList()) {
            totalValue += current.getValue();
        }
        return totalValue;
    }

    /**
     * Calculates total resale value of the inventory.
     * @return totalResaleValue
     */
    public int calculateTotalResaleValue() {
        int totalResaleValue= 0;
        for (Item current : inventory.getItemList()) {
            totalResaleValue += current.getResaleValue();
        }
        return totalResaleValue;
    }

    /**
     * I don't even know where I'm going with this. Putting it on the back
     * burner for now, I don't have time to figure it out
     * @param original
     * @return 
     */
    public ArrayList<Item> sortByValue(ArrayList<Item> original) {
        ArrayList<Item> sorted = new ArrayList<>();
        for (Item current : original) {
            if (sorted.size() == 0) {
                sorted.add(current);
            }
            
            // probably not correct, but whatever
            if (current.getValue() > sorted.get(sorted.size()).getValue()) {
                sorted.add(current);
            }
            else {
                sorted.add(0, current);
            }
        }
        return sorted;
    }
    
    /**
     *
     * @param item
     * @return
     */
    public boolean sellItem(Item item) {
        if (inventory.hasItem(item)) {
            int itemValue = item.getResaleValue();
            inventory.setCurrency(inventory.getCurrency() + itemValue);
            inventory.removeItem(item);
            return true;
        }
        return false;
    }
    
    /**
     *
     * @param item
     * @return
     */
    public boolean buyItem(Item item) {
        if (inventory.getCurrency() >= item.getValue()) {
            inventory.setCurrency(inventory.getCurrency() - item.getValue());
            inventory.addItem(item);
            return true;
        }
        return false;
    }
}