/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Connor
 */
public class GameMap implements Serializable{
    private final Map<Coordinates, Planet> planetMap;
    
    private boolean completed;
    
    public GameMap() {
        planetMap = new HashMap<>();
    }
    
    public void display() {
    
    }
    
    public void selectDestination(){
        
    }
    
    public Map<Coordinates, Planet> getPlanets() {
        return planetMap;
    }

    public void setPlanets(Planet oPlanet) {
        Coordinates coords = new Coordinates(oPlanet.getCoordX(), oPlanet.getCoordY());
        planetMap.put(coords, oPlanet);
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.planetMap);
        hash = 19 * hash + (this.completed ? 1 : 0);
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
        final GameMap other = (GameMap) obj;
        if (this.completed != other.completed) {
            return false;
        }
        if (!Objects.equals(this.planetMap, other.planetMap)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GameMap{" + "planets=" + planetMap + ", completed=" + completed + '}';
    }

}