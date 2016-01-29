/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.ArrayList; // Such a lifesaver
import java.util.Objects;

/**
 *
 * @author Connor
 */
public class Shop implements Serializable {
    private ArrayList<ShopItem> itemlist;
    private int currency;
    
    public Shop() {
        itemlist = new ArrayList<ShopItem>();
    }

    /**
     * @return the itemlist
     */
    public ArrayList<ShopItem> getItemlist() {
        return itemlist;
    }
    
    /**
     * Adds an item to the itemlist
     * @param item 
     */
    public void addItem(ShopItem item) {
        itemlist.add(item);
    }
    
    public void removeItem(ShopItem item) {
        itemlist.remove(item);
    }

    /**
     * @return the currency
     */
    public int getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(int currency) {
        this.currency = currency;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.itemlist);
        hash = 97 * hash + this.currency;
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
        final Shop other = (Shop) obj;
        if (this.currency != other.currency) {
            return false;
        }
        if (!Objects.equals(this.itemlist, other.itemlist)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Shop{" + "itemlist=" + itemlist + ", currency=" + currency + '}';
    }
}
