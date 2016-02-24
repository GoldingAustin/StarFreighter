/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author austingolding
 */
public class Planet implements Serializable{
    private String description;
    private String name;
    public final Coordinates coords;

    /**
     * Initializes a new planet with a pair of specified coordinates.
     * @param x
     * @param y 
     */
    public Planet(int x, int y) {
        coords = new Coordinates(x, y);
    }

    /**
     * Gets the planet's name.
     * @return {String} the planet's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the planet's name.
     * @param name - the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the planet's description.
     * @return {String} the planet's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the planet's description.
     * @param description - the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the coordX
     */
    public int getCoordX() {
        return coords.getX();
    }

    /**
     * @return the coordY
     */
    public int getCoordY() {
        return coords.getY();
    }

    /**
     * @return the coords
     */
    public Coordinates getCoordinates() {
        return coords;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.description);
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Planet other = (Planet) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Planet{" + "name= " + name  + ", description= " + description + '}';
    }    
}
