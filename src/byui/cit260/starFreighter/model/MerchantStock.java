/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author austingolding
 */
public class MerchantStock implements Serializable {
    private final ArrayList<Item> itemList = new ArrayList<>();
    private int currency;
    

    public MerchantStock() {

    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }
    
    public boolean hasItem(Item item) {
        return itemList.contains(item);
    }
    public String getItems() {
        return itemList.toString();
    }
    public void addItem(Item item) {
        itemList.add(item);
    }  
    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.currency;
        hash = 97 * hash + Objects.hashCode(this.itemList);
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
        final MerchantStock other = (MerchantStock) obj;
        if (this.currency != other.currency) {
            return false;
        }
        if (!Objects.equals(this.itemList, other.itemList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventory{" + "currency=" + currency + ", itemList=" + itemList + '}';
    }
      
}
