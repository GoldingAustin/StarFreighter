/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.Planet;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Connor
 */
public class MapController {
    /**
     * Does nothin' much, really.
     */
    public MapController() {
    }
    

    /**
     * Calculates the distance between two planets using the distance formula
     * @param current
     * @param desired
     * @return {double} the distance between the two planets
     */
    public double calculateDistance(Planet current, Planet desired) {
        /* The distance formula between two points on a coordinate plane
           is given by sqrt( (x2 - x1)^2 + (y2 - y1)^2 ) */

        // Perform subtraction
        int coordX = (desired.getCoordinates().getX() - current.getCoordinates().getX());
        int coordY = (desired.getCoordinates().getY() - current.getCoordinates().getY());

        // Square the result
        double coordXSquared = pow(coordX, 2);
        double coordYSquared = pow(coordY, 2);

        // Add the squares
        double coordSum = coordXSquared + coordYSquared;

        // Return the square root of the summed squares
        return sqrt(coordSum);
    }
}