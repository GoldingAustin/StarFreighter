/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starfreighter;

import byui.cit260.starFreighter.model.*;
import byui.cit260.starFreighter.view.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author austingolding
 */
public class StarFreighter {

    private static Game currentGame = null;
    private static Player player = null;
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        try {
            
            StarFreighter.inFile = new BufferedReader(new InputStreamReader(System.in));
            StarFreighter.outFile = new PrintWriter(System.out, true);
            StartProgramView startProgram = new StartProgramView();
            startProgram.StartProgramView();
            
        } catch (Throwable start) {
            
            System.out.println("Exception: " + start.toString()
                    + "\nCause: " + start.getCause()
                    + "\nMessage: " + start.getMessage());
            
        } 
        finally {
            
            try {
                if (StarFreighter.inFile != null) {
                    StarFreighter.inFile.close();
                }

                if (StarFreighter.outFile != null) {
                    StarFreighter.outFile.close();
                }

                if (StarFreighter.logFile != null) {
                    StarFreighter.outFile.close();
                }

            } 
            
            catch (IOException ex) { 
                System.out.println("Error closing files");
                return;   
            }
        }
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        StarFreighter.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        StarFreighter.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        StarFreighter.logFile = logFile;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        StarFreighter.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        StarFreighter.player = player;
    }

}
