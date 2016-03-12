/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.controller.MerchantController;
import byui.cit260.starFreighter.model.Item;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author austingolding
 */
class InventoryMenuView extends View {
    private final String CURRENCY = "credits";
    private final MerchantController playerInventory = new MerchantController();
    private MerchantController otherInventory;

    public InventoryMenuView() {
        super("\n"
                + "\n--------------------------------"
                + "\n| Inventory                     |"
                + "\n--------------------------------"
                + "\nC - Contents"
                + "\nB - Buy"
                + "\nS - Sell"
                + "\nT - Total Value"
                + "\nE - Exit"
                + "\n--------------------------------");
        
        // Testing stuff
        

    }

    public void setOtherInventory(MerchantController other) {
        otherInventory = other;
    }

    @Override
    public boolean doAction(Object obj) {

        String value = (String) obj;
        char choice = value.charAt(0);

        switch (choice) {
            case 'C':
                this.displayContents();
                break;
            case 'B':
                this.buyItem();
                break;
            case 'S':
                this.sellItem();
                break;
            case 'T':
                this.totalValue();
                break;
            case 'E':
                return true;
            default:
                out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void displayContents() {
        out.println("You have " + playerInventory.currency() +  " " + this.CURRENCY);
        out.println("[Item name]\t[Value]");
        for (Item current : playerInventory.itemList()) {
            this.printItem(current);
        }
    }
    
    // From who?
    private void buyItem() {
        // not done at all. sorry...
    }
    
    // To who?
    // Is the "to" even necessary?
    // Maybe if a player wants to buy back something they sold...
    // oh well for now
    private void sellItem() {
        out.println("Which item do you want to sell?");
        for (Item current : playerInventory.itemList()) {
            this.printItemNumber(current);
            this.printItem(current);
        }
        int itemToSellIndex = this.promptInteger() - 1;
        Item itemToSell = playerInventory.itemList().get(itemToSellIndex);
        String itemName = itemToSell.getName();
        int itemValue = itemToSell.getResaleValue();
        int previousCurrency = playerInventory.currency();
        playerInventory.sellItem(itemToSell);
        out.println("Sold " + itemName + " for " + itemValue + " " + this.CURRENCY);
        out.println("You had " + previousCurrency + " " + this.CURRENCY + ".");
        out.println("You now have " + playerInventory.currency() + " " + this.CURRENCY);
    }
    
    private int promptInteger() {
        // Additional scanner is necessary to avoid collisions with the default one
        // Dunno how to work around that to get pure integers, but hey.
        Scanner intPrompt = new Scanner(in);
        int number;
        do {
            while (!intPrompt.hasNextInt()) {
                out.println("Please enter a number.");
            }
            number = intPrompt.nextInt();
        } while(number <= 0);
        return number;
    }
    
    private void printItemNumber(Item item) {
        int index = playerInventory.itemList().indexOf(item) + 1;
        out.print("[");
        if (index < 10) {
            out.print("0");
        }
        out.print(index + "] ");
    }
    
    private void printItem(Item item) {
        out.print(item.getName());
        out.print("\t");
        out.print(item.getResaleValue() + " " + playerInventory.currencyUnit() + "\n");
    }

    private void totalValue() {
        int totalValue = playerInventory.calculateTotalValue();
        int resaleValue = playerInventory.calculateTotalResaleValue();
        
        out.println("The items in your inventory are worth " +
                totalValue + " " +
                playerInventory.currencyUnit() +
                ".");
        out.println("You can resell them for " + resaleValue +
                " " + playerInventory.currencyUnit() + ".");
    }
}