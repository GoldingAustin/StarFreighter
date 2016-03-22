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
import java.util.Collections;
import starfreighter.StarFreighter;

/**
 *
 * @author Connor
 */
public class MerchantController {

    private final String CURRENCY = "credits";

    /**
     *
     */
      public final MerchantStock inventory = StarFreighter.getCurrentGame().getMerch();
    //public final MerchantStock inventory = new MerchantStock();

    /**
     *
     */
    public MerchantController() {
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

    public String currencyUnit() {
        return this.CURRENCY;
    }

    public ArrayList<Item> itemList() {
        return inventory.getItemList();
    }

    /**
     * Calculates the total value of the inventory.
     *
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
     *
     * @return totalResaleValue
     */
    public int calculateTotalResaleValue() {
        int totalResaleValue = 0;
        for (Item current : inventory.getItemList()) {
            totalResaleValue += current.getResaleValue();
        }
        return totalResaleValue;
    }

    /**
     * I tried being original, but it was way too hard on my puny brain. CS124
     * made us reinvent the wheel for strings. I am _not_ doing that again.
     * Thank you for a working solution, Google!
     *
     * Note: would probably have been easier for me to understand with an Array
     * of primitives instead of an ArrayList of objects, comparing based on
     * those object's attributes.
     *
     * And on this subject, I refuse to make a test matrix for this. Working
     * with tables in Microsoft Word is backwards enough without the added
     * complexity working with objects introduces, thanks.
     *
     * @param original
     * @return
     */
    public ArrayList<Item> sortByValue(ArrayList<Item> original) {
        Collections.sort(original, (Item itemOne, Item itemTwo) -> {
            if (itemOne.getValue() > itemTwo.getValue()) {
                return 1;
            }
            if (itemOne.getValue() < itemTwo.getValue()) {
                return -1;
            }
            return 0;
        });
        return original;
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
