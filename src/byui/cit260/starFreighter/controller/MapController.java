/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.Map;
import byui.cit260.starFreighter.model.Planet;

/**
 *
 * @author Connor
 */
public class MapController {
    private final Map map = new Map();

    
    public double calculateDistance(Planet currentPlanet, Planet desiredPlanet) {
        /* The distance formula between two points on a coordinate plane
           is given by sqrt( (x2 - x1)^2 + (y2 - y1)^2 ) */

        // Perform subtraction
        int coordX = (desiredPlanet.getCoordX() - currentPlanet.getCoordX());
        int coordY = (desiredPlanet.getCoordY() - currentPlanet.getCoordY());

        // Square the result
        double coordXSquared = Math.pow(coordX, 2);
        double coordYSquared = Math.pow(coordY, 2);

        // Add the squares
        double coordSum = coordXSquared + coordYSquared;

        // Return the square root of the summed squares
        return Math.sqrt(coordSum);
    }
    
    public MapController() {
        
    }
}