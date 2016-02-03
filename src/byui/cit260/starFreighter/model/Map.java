/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author austingolding
 */
public class Map implements Serializable{
    private ArrayList<Planet> planets;
    
    private boolean completed;
    
    public Map() {
        planets = new ArrayList<Planet>();
    }
    
    public void display() {
    
    }
    
    public void selectDestination(){
        
    }
    
    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Planet oPlanet) {
        planets.add(oPlanet);
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
        hash = 19 * hash + Objects.hashCode(this.planets);
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
        final Map other = (Map) obj;
        if (this.completed != other.completed) {
            return false;
        }
        if (!Objects.equals(this.planets, other.planets)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "planets=" + planets + ", completed=" + completed + '}';
    }
    
    
    }
