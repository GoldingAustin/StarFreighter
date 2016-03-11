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
public enum Item implements Serializable {
    cheese,
    bandages,
    oldparts,
    newparts,
    junk,
    powerbar,
    ore,
    weaponparts,
    weapon,
    armor,
    coins,
    map;

    private String name;
    private int value;

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
     * @return the value
     */
    public int getValue() {
        return value;
    }

    public int getResaleValue() {
        return (int) ((int) value * 0.75);
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", value=" + value + '}';
    }
}
