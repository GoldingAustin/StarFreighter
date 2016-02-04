/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;


import byui.cit260.starFreighter.model.MerchantStock;
import byui.cit260.starFreighter.model.Item;


/**
 *
 * @author Connor
 */
public class MerchantController {
    private String name;
    public final MerchantStock inventory = new MerchantStock();
    
    public MerchantController(String name) {
        inventory.setCurrency(10);
        this.name = name;
    }
    
    public void addItem(Item item) {
        inventory.addItem(item);
    }
    
    public void displayCurrency() {
        System.out.println(this.name + " currency: " + inventory.getCurrency());
    }
    
    public void displayStock() {
        System.out.println(this.name + " stock: " + inventory.getItems());
    }
    
    public boolean sellItem(Item item) {
        if (inventory.hasItem(item)) {
            int itemValue = item.getValue();
            inventory.setCurrency(inventory.getCurrency() + itemValue);
            inventory.removeItem(item);
            return true;
        }
        return false;
    }
    
    public boolean buyItem(Item item) {
        if (inventory.getCurrency() >= item.getValue()) {
            inventory.setCurrency(inventory.getCurrency() - item.getValue());
            inventory.addItem(item);
            return true;
        }
        return false;
    }
}