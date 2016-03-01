/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.Coordinates;
import byui.cit260.starFreighter.model.GameMap;
import byui.cit260.starFreighter.model.Planet;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Map;

/**
 *
 * @author Connor
 */
public class MapController {
    private final GameMap map;
    /**
     * Initializes the list of planets; adds a few planets to the list
     */
    public MapController() {
        map = new GameMap();
        
        Planet earth = new Planet(1, 1);
        earth.setName("Earth");
        earth.setDescription("Third rock from the sun.");
        map.setPlanets(earth);
        
        Planet mars = new Planet(2, 4);
        mars.setName("Mars");
        mars.setDescription("The red planet.");
        map.setPlanets(mars);
    }

    /**
     * Returns the list of planets in the game's map.
     * @return {Map<Coordinates, Planet>} the list of planets
     */
    public Map<Coordinates, Planet> getPlanets() {
        return map.getPlanets();
    }
    
    /**
     * Fetches a planet from the game's map with the specified coordinates.
     * @param coords
     * @return {Planet} the planet at (x, y)
     */
    public Planet getPlanetByCoords(Coordinates coords) {
        return getPlanets().get(coords);
    }
    
    /**
     * Calculates the distance between two planets using the distance formula
     * @param current
     * @param desired
     * @return {double} the distance between the two planets
     */
    public double calculateDistance(Coordinates current, Coordinates desired) {
        /* The distance formula between two points on a coordinate plane
           is given by sqrt( (x2 - x1)^2 + (y2 - y1)^2 ) */

        // Perform subtraction
        int coordX = (desired.getX() - current.getX());
        int coordY = (desired.getY() - current.getY());

        // Square the result
        double coordXSquared = pow(coordX, 2);
        double coordYSquared = pow(coordY, 2);

        // Add the squares
        double coordSum = coordXSquared + coordYSquared;

        // Return the square root of the summed squares
        return sqrt(coordSum);
    }
    


}