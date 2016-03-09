/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.model;

import java.io.Serializable;


/**
 *
 * @author Connor
 */

public enum Planet implements Serializable {
    /* The size of the map is defined in GameMap on a per-instance basis. If you
    receive an array out of bounds error, it's because one of the planets
    defined below falls outside the bounds of the map size.
    
    With the current setup, coordinates must also be positive. Sorry!
    Still working on figuring out that four-quadrant plane.
     */
    Kryta("A barren desert planet with a few secrets", 1, 1),
    Qualufe("Oceans as far as the eye can see", 3, 4),
    Mezopan("Green forests and tall trees", 5, 4),
    Redecent("Galaxy capital", 7, 8);

    private final String description;
    private final Coordinates coords;

    Planet(String description, int x, int y) {
        this.description = description;
        coords = new Coordinates(x, y);
    }
    
    public String getDescription() {
        return description;
    }
    
    public Coordinates getCoordinates() {
        return coords;
    }

    public static Planet atCoordinates(Coordinates coords) {
        for (Planet planet : values()) {
            /* Comparing objects was being wonky here- comparing values instead,
               for now. */
            if (planet.getCoordinates().getX() == coords.getX() &&
                planet.getCoordinates().getY() == coords.getY()) {
                return planet;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Planet{" + "name= " + name() + ", description= " + description + '}';
    }    
}
