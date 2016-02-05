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
    private int fuel;
    private CrewMember captain;
    private CrewMember engineer;
    private CrewMember gunner;
    private CrewMember doctor;
    private CrewMember comms;


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

    /**
     * @return the fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * @param fuel the fuel to set
     */
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    
    /**
     * @return the captain
     */
    public CrewMember getCaptain() {
        return captain;
    }

    /**
     * @param captain the captain to set
     */
    public void setCaptain(CrewMember captain) {
        this.captain = captain;
    }

    /**
     * @return the engineer
     */
    public CrewMember getEngineer() {
        return engineer;
    }

    /**
     * @param engineer the engineer to set
     */
    public void setEngineer(CrewMember engineer) {
        this.engineer = engineer;
    }

    /**
     * @return the gunner
     */
    public CrewMember getGunner() {
        return gunner;
    }

    /**
     * @param gunner the gunner to set
     */
    public void setGunner(CrewMember gunner) {
        this.gunner = gunner;
    }

    /**
     * @return the doctor
     */
    public CrewMember getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(CrewMember doctor) {
        this.doctor = doctor;
    }

    /**
     * @return the comms
     */
    public CrewMember getComms() {
        return comms;
    }

    /**
     * @param comms the comms to set
     */
    public void setComms(CrewMember comms) {
        this.comms = comms;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + this.upgrade;
        hash = 67 * hash + this.repair;
        hash = 67 * hash + this.fuel;
        hash = 67 * hash + Objects.hashCode(this.captain);
        hash = 67 * hash + Objects.hashCode(this.engineer);
        hash = 67 * hash + Objects.hashCode(this.gunner);
        hash = 67 * hash + Objects.hashCode(this.doctor);
        hash = 67 * hash + Objects.hashCode(this.comms);
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
        if (this.fuel != other.fuel) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.captain, other.captain)) {
            return false;
        }
        if (!Objects.equals(this.engineer, other.engineer)) {
            return false;
        }
        if (!Objects.equals(this.gunner, other.gunner)) {
            return false;
        }
        if (!Objects.equals(this.doctor, other.doctor)) {
            return false;
        }
        if (!Objects.equals(this.comms, other.comms)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ship{" + "name=" + name + ", upgrade=" + upgrade + ", repair=" + repair + ", fuel=" + fuel + ", captain=" + captain + ", engineer=" + engineer + ", gunner=" + gunner + ", doctor=" + doctor + ", comms=" + comms + '}';
    }

    
}
