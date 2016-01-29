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
 * @author Connor
 */
public class Ship implements Serializable {
    private String name;
    private int upgrade;
    private int repair;
    
    public Ship() {
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the upgrade
     */
    public int getUpgrade() {
        return upgrade;
    }

    /**
     * @param upgrade the upgrade to set
     */
    public void setUpgrade(int upgrade) {
        this.upgrade = upgrade;
    }

    /**
     * @return the repair
     */
    public int getRepair() {
        return repair;
    }

    /**
     * @param repair the repair to set
     */
    public void setRepair(int repair) {
        this.repair = repair;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + this.upgrade;
        hash = 59 * hash + this.repair;
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
        final Ship other = (Ship) obj;
        if (this.upgrade != other.upgrade) {
            return false;
        }
        if (this.repair != other.repair) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ship{" + "name=" + name + ", upgrade=" + upgrade + ", repair=" + repair + '}';
    }
}
