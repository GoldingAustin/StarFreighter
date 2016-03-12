/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.controller.MapController;
import byui.cit260.starFreighter.model.Coordinates;
import byui.cit260.starFreighter.model.GameMap;
import byui.cit260.starFreighter.model.Planet;
import static java.lang.Character.toChars;
import static java.lang.Character.toUpperCase;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;


/**
 *
 * @author Connor
 */
public class MapMenuView extends View {
    // Class members
    private final MapController mapController;
    private final GameMap map;

    /**
     * Initialize the controller and populate the map.
     */
    public MapMenuView() {
        super ("\n"
            + "\n--------------------------------"
            + "\n| Map Menu                     |"
            + "\n--------------------------------"
            + "\nM - Display map"
            + "\nT - Travel"
            + "\nE - Exit"
            + "\n--------------------------------");
        
        mapController =  new MapController();
        // For local testing.
        // I assume there's a way to access the game object's map instance, but
        // I won't have time to figure it out tonight! Sorry!
        map = new GameMap(11, 11);
    }

    /**
     * Performs an action based on user input.
     * @param obj - the user input to switch on 
     * @return 
     */
    @Override
    public boolean doAction(Object obj) {
        
        String value = (String) obj; 
        char choice = value.charAt(0);
        // view #1, switch statement
        switch (choice) {
            case 'M':
                this.displayMap();
                break;
            case 'T':
                this.travel();
                break;
            case 'E':
                return true;
            default:
                out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }


    /**
     * Displays the map.
     */
    private void displayMap() {
        this.displayTopLegend();
        this.displayRows();
    }

    
    /**
     * Displays horizontal spacing using ' '
     */
    private void displayHorizontalSpace() {
        for (int i = 0; i < map.getHorizontalSpace(); i++) {
            out.print(' ');
        }
    }

    
    /**
     * Displays vertical spacing using '\n'
     */
    private void displayVerticalSpace() {
        out.print('\n');
        for (int i = 0; i < map.getVerticalSpace(); i++) {
            out.print('\n');
        }
    }


    /**
     * Displays the top row of coordinate identifiers.
     * Called in displayMap.
     */
    private void displayTopLegend() {
        // print a single empty space to offset the legend
        out.print(' ');
        
        this.displayHorizontalSpace();
        
        for (int col = 0; col < map.getColumns(); col++) {
            /* Using characters instead of digits, because double-digit numbers
               make the map really ugly when it's large */
            // offset character by 65, the ASCII value of 'A'
            char colIdentifier = toChars(65 + col)[0];
            out.print(colIdentifier);
            this.displayHorizontalSpace();
        }
        
        // print a single newline to end the legend
        out.print('\n');
    }


    /**
     * Displays each row.
     * Called in displayMap.
     */
    private void displayRows() {
        for (int row = 0; row < map.getRows(); row++) {
            /* Using characters instead of digits, because double-digit numbers
               make the map really ugly when it's large */
            // offset character by 65, the ASCII value of 'A'
            char rowIdentifier = toChars(65 + row)[0];
            out.print(rowIdentifier);
            
            this.displayHorizontalSpace();
            this.displayCells(row);
            this.displayVerticalSpace();
        }
    }
    

    /**
     * Displays the cells in a specified row.
     * Called in displayRows.
     * @param row 
     */
    private void displayCells(int row) {
        for (int col = 0; col < map.getColumns(); col++) {
            out.print(map.getContents()[row][col]);
            this.displayHorizontalSpace();
        }
    }


    /**
     * Travels to another planet.
     */
    private void travel() {
        Planet destination = this.selectDestination();
        // for testing only:
        Planet current = Planet.Redecent;
        // todo: get the player's current location on the map instead
        double distance = mapController.calculateDistance(current, destination);
        out.println(destination.name() + ": " + destination.getDescription());
        out.println("Your destination is " + distance + " light years away.");
        // do something to calculate fuel cost, then update the player's position
        // let's not forget random encounters, either...
        
        // this is as far as I got on my work on the views
    }


    /**
     * Prompts the user to select a destination
     * @return {Planet} the destination planet
     */
    private Planet selectDestination() {
        Planet destination = null;
        
        // view #2, while loop
        while (destination == null) {
            Coordinates coords = this.promptForCoordinates();
            destination = Planet.atCoordinates(coords);
            if (destination == null) {
                out.println("There's no planet at the specified coordinates!");
            }
        }

        return destination;
    }

    
    /**
     * Prompts the user for a single uppercase letter. Uses the character's ASCII
     * value to return an int, offset by 65(value of 'A') to represent a point in
     * a coordinate plane.
     * @param desc - a descriptor to prompt with
     * @param upperLimit - the upper limit of acceptable coordinates
     * @return 
     */
    private int promptSingleCoordinate(String desc, int upperLimit) {
        char coordinate = ' ';
        boolean finished = false;
        Scanner keyboard = new Scanner(in);
        
        // view #2, while loop
        while (!finished) {
            out.print("Select " + desc + " coordinate: ");
            // view #2, two String functions
            String value = keyboard.nextLine().trim();

            if (value.length() != 1) {
                out.println("Invalid input - The coordinate must be one letter");
                continue;
            }

            // Switch to uppercase
            coordinate = toUpperCase(value.charAt(0));

            // Ensure the character returned is a valid uppercase letter
            // view #2, if/else statement
            if (coordinate >= 65 &&
                (coordinate - 65) < upperLimit &&
                (coordinate - upperLimit <= 90)) {
                finished = true;
            }
            else {
                out.println("Invalid " + desc + " coordinate.");
            }
        }
        
        return convertCharToIntCoord(coordinate);
    }


    /**
     * Converts an uppercase character to an int offset by 65, value of 'A'
     * @param coord
     * @return 
     */
    private int convertCharToIntCoord(char coord) {
        // uses 65, the ASCII value of 'A', for the offset
        return (coord - 65);
    }


    /**
     * Prompts the user for a pair of valid coordinates.
     * @return 
     */
    private Coordinates promptForCoordinates() {
        // Get each individual coordinate
        int x = this.promptSingleCoordinate("X", map.getColumns());
        int y = this.promptSingleCoordinate("Y", map.getRows());
        
        // Return a coordinates object
        Coordinates selection = new Coordinates(x, y);
        return selection;
    }
}