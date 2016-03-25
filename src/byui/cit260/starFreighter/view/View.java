/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
public abstract class View implements ViewInterface {

    protected final BufferedReader keyboard = StarFreighter.getInFile();
    protected final PrintWriter console = StarFreighter.getOutFile();

    protected String displayMessage;

    public View(String message) {
        this.displayMessage = message;
    }

    @Override
    public void display() {
        String value = "";
        boolean done = false;

        do {
            this.console.println(this.displayMessage);
            value = this.getInput();
            done = this.doAction(value);

        } while (!done);
    }

    @Override
    public String getInput() {
        boolean valid = false;
        String value = null;

        while (!valid) {

            try {
                value = this.keyboard.readLine();
                value = value.trim();

                if (value.length() < 1) {
                    console.println("Invalid input - Please select an option from the menu");
                    continue;
                }
                break;
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return value.toUpperCase();
    }
}
