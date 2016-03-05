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