/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import java.util.Scanner;

/**
 *
 * @author austingolding
 */
public abstract class View implements ViewInterface {

    Scanner keyboard = new Scanner(System.in);
    protected String displayMessage;

    public View(String message) {
        this.displayMessage = message;
    }

    @Override
    public void display() {
        String value = "";
        boolean done = false;

        do {
            System.out.println(this.displayMessage);
            value = this.getInput();
            done = this.doAction(value);

        } while (!done);
    }

    @Override
    public String getInput() {
        boolean valid = false;
        String value = null;
        
        while (!valid) {

            value = keyboard.nextLine();
            value = value.trim();

            if (value.length() != 1) {
                System.out.println("Invalid input - The value must be one letter");
                continue;
            }
            break;
        }
        return value;
    }
}
