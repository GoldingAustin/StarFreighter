/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.controller.GameControl;
import byui.cit260.starFreighter.controller.MerchantController;
import byui.cit260.starFreighter.model.Item;
import byui.cit260.starFreighter.model.MerchantStock;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import starfreighter.StarFreighter;

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
                + "\nR - Inventory Report"
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
            case 'R':
                this.inventoryReport();
                break;
            case 'T':
                this.totalValue();
                break;
            case 'E':
                return true;
            default:
                console.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void displayContents() {
        console.println("You have " + playerInventory.currency() + " " + this.CURRENCY);
        console.println("[Item name]\t[Value]");
        for (Item current : playerInventory.itemList()) {
            this.printItem(current);
        }
    }

    // From who?
    private void buyItem() {
        MerchantStock store = StarFreighter.getCurrentGame().getShip().getCurrentLocation().shop();
        console.println("Which item do you want to buy?");
        for (Item current : store.getItems()) {
            this.printItemNumber(current);
            this.printItem(current);
        }
        int itemToSellIndex = this.promptInteger() - 1;
        Item itemToSell = store.getItems().get(itemToSellIndex);
        // not done at all. sorry...
    }

    // To who?
    // Is the "to" even necessary?
    // Maybe if a player wants to buy back something they sold...
    // oh well for now
    private void sellItem() {
        console.println("Which item do you want to sell?");
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
        console.println("Sold " + itemName + " for " + itemValue + " " + this.CURRENCY);
        console.println("You had " + previousCurrency + " " + this.CURRENCY + ".");
        console.println("You now have " + playerInventory.currency() + " " + this.CURRENCY);
    }

    private int promptInteger() {
        // Additional scanner is necessary to avoid collisions with the default one
        // Dunno how to work around that to get pure integers, but hey.
        Scanner intPrompt = new Scanner(in);
        int number;
        do {
            while (!intPrompt.hasNextInt()) {
                console.println("Please enter a number.");
            }
            number = intPrompt.nextInt();
        } while (number <= 0);
        return number;
    }

    private void printItemNumber(Item item) {
        int index = playerInventory.itemList().indexOf(item) + 1;
        console.print("[");
        if (index < 10) {
            console.print("0");
        }
        console.print(index + "] ");
    }

    private void printItem(Item item) {
        console.print(item.getName());
        console.print("\t");
        console.print(item.getResaleValue() + " " + playerInventory.currencyUnit() + "\n");
    }

    private void totalValue() {
        int totalValue = playerInventory.calculateTotalValue();
        int resaleValue = playerInventory.calculateTotalResaleValue();

        console.println("The items in your inventory are worth "
                + totalValue + " "
                + playerInventory.currencyUnit()
                + ".");
        console.println("You can resell them for " + resaleValue
                + " " + playerInventory.currencyUnit() + ".");
    }
    
    private void inventoryReport() {
        console.println("Filepath to save report to:");
        String filePath = promptFilePath();
        writeReportToFile(filePath);
    }
    
    private String promptFilePath() {
        String value = null;
        try {
            value = this.keyboard.readLine();
            value = value.trim();
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        return value;
    }
    
    private void writeReportToFile(String filePath) {
        try(PrintWriter out = new PrintWriter(filePath)) {
            out.println("\n\n       Inventory Report");
            out.printf("%n%-20s%10s", "Name", "Value");
            out.printf("%n%-20s%10s", "--------------------", "-----");
            for (Item current : playerInventory.itemList()) {
                out.printf("%n%-20s%10s", current.getName(),
                                          current.getValue());
            }
        } catch (IOException ex) {
            Logger.getLogger(InventoryMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
