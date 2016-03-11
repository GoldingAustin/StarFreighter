/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.CrewMember;
import java.io.Serializable;

/**
 *
 * @author Connor
 */
public class CrewController implements Serializable {   
    
    public CrewController() {
        
    }

    public void name(CrewMember crew, String name) {
        crew.setName(name);
    }
    
    public void damage(CrewMember crew, int damage) {
        crew.setHitPoints(crew.getHitPoints() - damage);
    }
    
    public void heal(CrewMember crew, int heal) {
        crew.setHitPoints(crew.getHitPoints() + heal);
    }
    
    public void setStat(CrewMember crew, Stats stat, int value) {
        if (value <= 0) {
            throw new NumberFormatException("value is not greater than zero");
        }

        switch(stat) {
            case PILOT:
                crew.setPilot(value);
                break;
            case MECHANIC:
                crew.setMechanic(value);
                break;
            case FIGHTER:
                crew.setFighter(value);
                break;
            case DOCTOR:
                crew.setDoctor(value);
                break;
            case TRADER:
                crew.setTrader(value);
                break;
        }
    }
    
    public static enum Stats {
        PILOT, MECHANIC, FIGHTER, DOCTOR, TRADER
    }
}
