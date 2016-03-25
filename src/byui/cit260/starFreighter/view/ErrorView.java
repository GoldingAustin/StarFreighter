/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import java.io.PrintWriter;
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
public class ErrorView {

    private static final PrintWriter errorFile = StarFreighter.getOutFile();
    private static final PrintWriter logFile = StarFreighter.getLogFile();

    public static void display(String className, String errorMessage) {

        errorFile.println(
                "-----------------------------------------"
                + "\n- ERROR - " + errorMessage
                + "\n-----------------------------------------");

        logFile.println(className + " - " + errorMessage);
    }
}