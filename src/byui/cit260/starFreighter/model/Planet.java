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
    Kryta("A barren desert planet with a few secrets", 1, 1, 'K'),
    Qualufe("Oceans as far as the eye can see", 3, 4, 'Q'),
    Mezopan("Green forests and tall trees", 5, 4, 'M'),
    Redecent("Galaxy capital", 7, 8, 'R');

    private final String description;
    private final Coordinates coords;
    private final char symbol;
    private final MerchantStock shop;

    Planet(String description, int x, int y, char symbol) {
        this.description = description;
        this.coords = new Coordinates(x, y);
        this.symbol = symbol;
        this.shop = new MerchantStock();
        this.shop.setCurrency(1000);
        this.shop.addItem(new Item("hey", 100));
    }

    public String getDescription() {
        return description;
    }

    public Coordinates getCoordinates() {
        return coords;
    }

    public char getSymbol() {
        return symbol;
    }
    
    public MerchantStock shop() {
        return shop;
    }

    public static Planet atCoordinates(Coordinates coords) {
        for (Planet planet : values()) {
            /* Comparing objects was being wonky here- comparing values instead,
               for now. */
            if (planet.getCoordinates().getX() == coords.getX()
                    && planet.getCoordinates().getY() == coords.getY()) {
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
