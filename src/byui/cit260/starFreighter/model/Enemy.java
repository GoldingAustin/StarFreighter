/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.model;

/**
 *
 * @author austingolding
 */
public class Enemy {
    private int hitpoints;
    private int aModifier;
    private int dModifier;

    /**
     *
     */
    public Enemy () {
        
    }

    /**
     *
     * @return
     */
    public int getHitpoints() {
        return hitpoints;
    }

    /**
     *
     * @param hitpoints
     */
    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    /**
     *
     * @return
     */
    public int getaModifier() {
        return aModifier;
    }

    /**
     *
     * @param aModifier
     */
    public void setaModifier(int aModifier) {
        this.aModifier = aModifier;
    }

    /**
     *
     * @return
     */
    public int getdModifier() {
        return dModifier;
    }

    /**
     *
     * @param dModifier
     */
    public void setdModifier(int dModifier) {
        this.dModifier = dModifier;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.hitpoints;
        hash = 37 * hash + this.aModifier;
        hash = 37 * hash + this.dModifier;
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
        final Enemy other = (Enemy) obj;

        if (this.hitpoints != other.hitpoints) {
            return false;
        }
        if (this.aModifier != other.aModifier) {
            return false;
        }
        if (this.dModifier != other.dModifier) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Enemy{" +  ", hitpoints=" + hitpoints + ", aModifier=" + aModifier + ", dModifier=" + dModifier + '}';
    }


}
