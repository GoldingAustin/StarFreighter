/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.controller.EncounterController;
import byui.cit260.starFreighter.controller.MapController;
import byui.cit260.starFreighter.model.Coordinates;
import byui.cit260.starFreighter.model.GameMap;
import byui.cit260.starFreighter.model.JobBoard;
import byui.cit260.starFreighter.model.Planet;
import static java.lang.Character.toChars;
import static java.lang.Character.toUpperCase;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;
import starfreighter.StarFreighter;

/**
 *
 * @author Connor
 */
public class MapMenuView extends View {

    // Class members
    private final MapController mapController;
    private final GameMap map;
    private static final ArrayList<JobBoard> jobs = StarFreighter.getCurrentGame().getJobs();

    /**
     * Initialize the controller and populate the map.
     */
    public MapMenuView() {
        super("\n"
                + "\n--------------------------------"
                + "\n| Map Menu                     |"
                + "\n--------------------------------"
                + "\nM - Display map"
                + "\nT - Travel"
                + "\nJ - Jobs Board"
                + "\nE - Exit"
                + "\n--------------------------------");

        mapController = new MapController();
        map = StarFreighter.getCurrentGame().getMap();
    }

    /**
     * Performs an action based on user input.
     *
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
            case 'J':
                this.displayBoard();
                break;
            case 'E':
                return true;
            default:
                console.println("\n*** Invalid selection *** Try again");
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
            console.print(' ');
        }
    }

    private void displayBoard() {

        TextBox.displayText("Job          " + "         Planet       " + "         Reward      "
                + "  " + jobs.get(0).getJob() + "         " + jobs.get(0).getLocName() + "                  " + jobs.get(0).getReward() + "       "
                + "  " + jobs.get(1).getJob() + "              " + jobs.get(1).getLocName() + "                  " + jobs.get(1).getReward() + "       "
                + "  " + jobs.get(2).getJob() + "            " + jobs.get(2).getLocName() + "                  " + jobs.get(2).getReward() + "       "
                + "  " + jobs.get(3).getJob() + "     " + jobs.get(3).getLocName() + "                  " + jobs.get(3).getReward() + "       ");
    }

    /**
     * Displays vertical spacing using '\n'
     */
    private void displayVerticalSpace() {
        console.print('\n');
        for (int i = 0; i < map.getVerticalSpace(); i++) {
            console.print('\n');
        }
    }

    /**
     * Displays the top row of coordinate identifiers. Called in displayMap.
     */
    private void displayTopLegend() {
        // print a single empty space to offset the legend
        console.print(' ');

        this.displayHorizontalSpace();

        for (int col = 0; col < map.getColumns(); col++) {
            /* Using characters instead of digits, because double-digit numbers
               make the map really ugly when it's large */
            // offset character by 65, the ASCII value of 'A'
            char colIdentifier = toChars(65 + col)[0];
            console.print(colIdentifier);
            this.displayHorizontalSpace();
        }

        // print a single newline to end the legend
        console.print('\n');
    }

    /**
     * Displays each row. Called in displayMap.
     */
    private void displayRows() {
        for (int row = 0; row < map.getRows(); row++) {
            /* Using characters instead of digits, because double-digit numbers
               make the map really ugly when it's large */
            // offset character by 65, the ASCII value of 'A'
            char rowIdentifier = toChars(65 + row)[0];
            console.print(rowIdentifier);

            this.displayHorizontalSpace();
            this.displayCells(row);
            this.displayVerticalSpace();
        }
    }

    /**
     * Displays the cells in a specified row. Called in displayRows.
     *
     * @param row
     */
    private void displayCells(int row) {
        for (int col = 0; col < map.getColumns(); col++) {
            console.print(map.getContents()[row][col]);
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
        console.println(destination.name() + ": " + destination.getDescription());
        console.println("Your destination is " + distance + " light years away.");
        // do something to calculate fuel cost, then update the player's position
        // let's not forget random encounters, either...
        // this is as far as I got on my work on the views
    }

    /**
     * Prompts the user to select a destination
     *
     * @return {Planet} the destination planet
     */
    private Planet selectDestination() {
        Planet destination = null;

        // view #2, while loop
        while (destination == null) {
            Coordinates coords = this.promptForCoordinates();
            destination = Planet.atCoordinates(coords);
            if (destination == null) {
                console.println("There's no planet at the specified coordinates!");
            }
        }
        EncounterChance();
        return destination;
    }

    public void EncounterChance() {
        EncounterController encounter = new EncounterController();
        int chance = (int) (Math.random() * 100);

        if (chance >= 50) {
            encounter.run();
        }

    }

    /**
     * Prompts the user for a single uppercase letter. Uses the character's
     * ASCII value to return an int, offset by 65(value of 'A') to represent a
     * point in a coordinate plane.
     *
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
            console.print("Select " + desc + " coordinate: ");
            // view #2, two String functions
            String value = keyboard.nextLine().trim();

            if (value.length() != 1) {
                console.println("Invalid input - The coordinate must be one letter");
                continue;
            }

            // Switch to uppercase
            coordinate = toUpperCase(value.charAt(0));

            // Ensure the character returned is a valid uppercase letter
            // view #2, if/else statement
            if (coordinate >= 65
                    && (coordinate - 65) < upperLimit
                    && (coordinate - upperLimit <= 90)) {
                finished = true;
            } else {
                console.println("Invalid " + desc + " coordinate.");
            }
        }

        return convertCharToIntCoord(coordinate);
    }

    /**
     * Converts an uppercase character to an int offset by 65, value of 'A'
     *
     * @param coord
     * @return
     */
    private int convertCharToIntCoord(char coord) {
        // uses 65, the ASCII value of 'A', for the offset
        return (coord - 65);
    }

    /**
     * Prompts the user for a pair of valid coordinates.
     *
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
