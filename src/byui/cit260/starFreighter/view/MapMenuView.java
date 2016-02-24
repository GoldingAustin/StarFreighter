/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.controller.MapController;
import byui.cit260.starFreighter.model.Coordinates;
import byui.cit260.starFreighter.model.Planet;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author Connor
 */
public class MapMenuView {
    // Class constants
    private final String MENU = "\n"
            + "\n--------------------------------"
            + "\n| Map Menu                     |"
            + "\n--------------------------------"
            + "\nM - Display map"
            + "\nT - Travel"
            + "\nE - Exit"
            + "\n--------------------------------";
    private final int ROWS = 6; // number of horizontal rows in the map
    private final int COLS = 11; // number of vertical columns in the map
    private final char SYMBOL_EMPTY = '.'; // used to display empty space
    private final char SYMBOL_PLANET = 'O'; // used to indicate a planet
    private final int MAP_HSPACE = 1; // how much horizontal space in the grid
    private final int MAP_VSPACE = 0; // how much vertical space in the grid


    // Class members
    private final MapController mapController;
    private final char[][] displayMap;


    /**
     * Initialize the controller and populate the map.
     */
    public MapMenuView() {
        mapController =  new MapController();
        displayMap = new char[ROWS][COLS];


        // fill the map with a bunch of initial values
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                displayMap[row][col] = SYMBOL_EMPTY;
            }
        }
        // next, fill in the planets
        /* todo: "can use functional operations"? I don't get it,
           sticking with syntax I understand */
        for (Map.Entry<Coordinates, Planet> entry : mapController.getPlanets().entrySet()) {
            Coordinates coords = entry.getKey();
            /* If we wanted the planet too, it would be
               Planet planet = entry.getValue(); */
            int x = coords.getX();
            int y = coords.getY();
            displayMap[y][x] = SYMBOL_PLANET;
        }
    }


    /**
     * Displays the map menu.
     */
    public void displayMenu() {
        char selection;
        // view #1, do/while loop
        do {
            System.out.println(MENU);
            selection = this.getInput();
            this.doAction(selection);
        } while (selection != 'E');
    }


    /**
     * Gets a single character, uppercase if applicable.
     * @return {char} input - a single, uppercase character
     */
    private char getInput() {
        Scanner keyboard = new Scanner(System.in);
        char input = ' ';

        boolean valid = false;
        while (!valid) {
            System.out.print("What do you want to do? ");
            // view #1, two String functions
            String value = keyboard.nextLine().trim();
            
            if (value.length() != 1) {
                System.out.println("Invalid input - The value must be one letter");
                continue;
            }
            
            input = Character.toUpperCase(value.charAt(0));
            valid = true;
        }
        return input;
    }


    /**
     * Performs an action based on user input.
     * @param value - the user input to switch on
     */
    private void doAction(char value) {
        // view #1, switch statement
        switch (value) {
            case 'M':
                this.displayMap();
                break;
            case 'T':
                this.travel();
                break;
            case 'E':
                return;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
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
        for (int i = 0; i < MAP_HSPACE; i++) {
            System.out.print(' ');
        }
    }

    
    /**
     * Displays vertical spacing using '\n'
     */
    private void displayVerticalSpace() {
        System.out.print('\n');
        for (int i = 0; i < MAP_VSPACE; i++) {
            System.out.print('\n');
        }
    }


    /**
     * Displays the top row of coordinate identifiers.
     * Called in displayMap.
     */
    private void displayTopLegend() {
        // print a single empty space to offset the legend
        System.out.print(' ');
        
        this.displayHorizontalSpace();
        
        for (int col = 0; col < COLS; col++) {
            /* Using characters instead of digits, because double-digit numbers
               make the map really ugly when it's large */
            // offset character by 65, the ASCII value of 'A'
            char colIdentifier = Character.toChars(65 + col)[0];
            System.out.print(colIdentifier);
            this.displayHorizontalSpace();
        }
        
        // print a single newline to end the legend
        System.out.print('\n');
    }


    /**
     * Displays each row.
     * Called in displayMap.
     */
    private void displayRows() {
        for (int row = 0; row < ROWS; row++) {
            /* Using characters instead of digits, because double-digit numbers
               make the map really ugly when it's large */
            // offset character by 65, the ASCII value of 'A'
            char rowIdentifier = Character.toChars(65 + row)[0];
            System.out.print(rowIdentifier);
            
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
        for (int col = 0; col < COLS; col++) {
            System.out.print(displayMap[row][col]);
            this.displayHorizontalSpace();
        }
    }


    /**
     * Travels to another planet.
     */
    private void travel() {
        Planet destination = this.selectDestination();
        // for testing only:
        Coordinates current = new Coordinates(0, 0);
        // todo: get the player's current location on the map instead
        double distance = mapController.calculateDistance(current, destination.getCoordinates());
        System.out.println(destination.getName() + ": " + destination.getDescription());
        System.out.println("Your destination is " + distance + " light years away.");
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
            destination = mapController.getPlanetByCoords(coords);
            if (destination == null) {
                System.out.println("There's no planet at the specified coordinates!");
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
        Scanner keyboard = new Scanner(System.in);
        
        // view #2, while loop
        while (!finished) {
            System.out.print("Select " + desc + " coordinate: ");
            // view #2, two String functions
            String value = keyboard.nextLine().trim();

            if (value.length() != 1) {
                System.out.println("Invalid input - The coordinate must be one letter");
                continue;
            }

            // Switch to uppercase
            coordinate = Character.toUpperCase(value.charAt(0));

            // Ensure the character returned is a valid uppercase letter
            // view #2, if/else statement
            if (coordinate >= 65 &&
                (coordinate - 65) < upperLimit &&
                (coordinate - upperLimit <= 90)) {
                finished = true;
            }
            else {
                System.out.println("Invalid " + desc + " coordinate.");
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
        int x = this.promptSingleCoordinate("X", COLS);
        int y = this.promptSingleCoordinate("Y", ROWS);
        
        // Return a coordinates object
        Coordinates selection = new Coordinates(x, y);
        return selection;
    }
}