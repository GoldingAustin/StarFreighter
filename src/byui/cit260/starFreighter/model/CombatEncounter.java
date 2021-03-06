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
public class CombatEncounter implements Serializable {

    private int hitPoints;
    private int damage;
    private int damageModifiers;
    private int defenseModifiers;
    private boolean alive;
    private String name;

    public CombatEncounter() {

    }

    /**
     * @return the hitPoints
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * @param hitPoints the hitPoints to set
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * @param damage the damage to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @return the damageModifiers
     */
    public int getDamageModifiers() {
        return damageModifiers;
    }

    /**
     * @param damageModifiers the damageModifiers to set
     */
    public void setDamageModifiers(int damageModifiers) {
        this.damageModifiers = damageModifiers;
    }

    public int getDefenseModifiers() {
        return defenseModifiers;
    }

    public void setDefenseModifiers(int defenseModifiers) {
        this.defenseModifiers = defenseModifiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.hitPoints;
        hash = 41 * hash + this.damage;
        hash = 41 * hash + this.damageModifiers;
        hash = 41 * hash + this.defenseModifiers;
        hash = 41 * hash + (this.alive ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.name);
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
        final CombatEncounter other = (CombatEncounter) obj;
        if (this.hitPoints != other.hitPoints) {
            return false;
        }
        if (this.damage != other.damage) {
            return false;
        }
        if (this.damageModifiers != other.damageModifiers) {
            return false;
        }
        if (this.defenseModifiers != other.defenseModifiers) {
            return false;
        }
        if (this.alive != other.alive) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CombatEncounter{" + "hitPoints=" + hitPoints + ", damage=" + damage + ", damageModifiers=" + damageModifiers + ", defenseModifiers=" + defenseModifiers + ", alive=" + alive + ", name=" + name + '}';
    }

}
