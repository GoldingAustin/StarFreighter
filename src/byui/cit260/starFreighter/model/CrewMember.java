/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.model;

import byui.cit260.starFreighter.controller.CrewController;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Connor
 */
public class CrewMember implements Serializable {
    public static CrewMember crewOne = new CrewMember();
    public static CrewMember crewTwo = new CrewMember();
    public static CrewMember crewThr = new CrewMember();
    public static CrewMember crewFou = new CrewMember();
    public static CrewMember crewFiv = new CrewMember();
    public static CrewMember captain = new CrewMember();
    public static CrewController crewCon = new CrewController();

    private String name;
    private int pilot;
    private int mechanic;
    private int fighter;
    private int doctor;
    private int trader;
    private int hitPoints;



    public CrewMember()  {

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
     * @return the pilot
     */
    public int getPilot() {
        return pilot;
    }

    /**
     * @param pilot the pilot to set
     */
    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    /**
     * @return the mechanic
     */
    public int getMechanic() {
        return mechanic;
    }

    /**
     * @param mechanic the mechanic to set
     */
    public void setMechanic(int mechanic) {
        this.mechanic = mechanic;
    }

    /**
     * @return the fighter
     */
    public int getFighter() {
        return fighter;
    }

    /**
     * @param fighter the fighter to set
     */
    public void setFighter(int fighter) {
        this.fighter = fighter;
    }

    /**
     * @return the doctor
     */
    public int getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(int doctor) {
        this.doctor = doctor;
    }

    /**
     * @return the trader
     */
    public int getTrader() {
        return trader;
    }

    /**
     * @param trader the trader to set
     */
    public void setTrader(int trader) {
        this.trader = trader;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.pilot;
        hash = 97 * hash + this.mechanic;
        hash = 97 * hash + this.fighter;
        hash = 97 * hash + this.doctor;
        hash = 97 * hash + this.trader;
        hash = 97 * hash + this.hitPoints;
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
        final CrewMember other = (CrewMember) obj;
        if (this.pilot != other.pilot) {
            return false;
        }
        if (this.mechanic != other.mechanic) {
            return false;
        }
        if (this.fighter != other.fighter) {
            return false;
        }
        if (this.doctor != other.doctor) {
            return false;
        }
        if (this.trader != other.trader) {
            return false;
        }
        if (this.hitPoints != other.hitPoints) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GameCharacter{" + "name=" + name + ", pilot=" + pilot + ", mechanic=" + mechanic + ", fighter=" + fighter + ", doctor=" + doctor + ", trader=" + trader + ", hitPoints=" + hitPoints + '}';
    }
}
