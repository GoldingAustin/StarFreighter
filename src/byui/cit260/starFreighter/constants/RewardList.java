package byui.cit260.starFreighter.constants;

import byui.cit260.starFreighter.model.Inventory;
import byui.cit260.starFreighter.model.InventoryItem;
import java.util.ArrayList;

/**
 * A list of the jobs in the game.
 */
public enum RewardList {
    TRADE_NEW_PARTS(100, new ArrayList<InventoryItem>() {{
        add(new InventoryItem(ItemList.JUNK));
    }});
    
    /**
     * Constants.
     */
    private final int cash;
    private final ArrayList<InventoryItem> items;
    
    /**
     * Constructor.
     */
    RewardList(int cash, ArrayList<InventoryItem> items) {
        this.cash = cash;
        this.items = items;
    }
    
    /**
     * Clones the reward into a new inventory.
     * @return 
     */
    public Inventory cloneReward() {
        Inventory newInventory = new Inventory();
        newInventory.setCurrency(this.cash);
        newInventory.setContents(this.items);
        return newInventory;
    }
}