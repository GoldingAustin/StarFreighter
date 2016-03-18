/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/**
 *
 * @author austingolding
 */
public abstract class View implements ViewInterface {

    Scanner keyboard = new Scanner(in);
    protected String displayMessage;

    public View(String message) {
        this.displayMessage = message;
    }

    @Override
    public void display() {
        String value = "";
        boolean done = false;

        do {
            out.println(this.displayMessage);
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

            if (value.length() < 1) {
                out.println("Invalid input - Please select an option from the menu");
                continue;
            }
            break;
        }
        return value.toUpperCase();
    }
}
