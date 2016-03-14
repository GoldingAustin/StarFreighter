/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.CrewMember;
import java.io.Serializable;
import static java.lang.System.out;

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
        switch (stat) {
            case PILOT:
                if (crew.getPilot() < 10) {
                    crew.setPilot(value);
                } else {
                    out.println("Congrats! You have reached the max Pilot level with: " + crew.getName());
                }
                break;
            case MECHANIC:
                if (crew.getMechanic() < 10) {
                    crew.setMechanic(value);
                } else {
                    out.println("Congrats! You have reached the max Mechanic level with: " + crew.getName());
                }
                break;
            case FIGHTER:
                if (crew.getFighter() < 10) {
                    crew.setFighter(value);
                } else {
                    out.println("Congrats! You have reached the max Fighter level with: " + crew.getName());
                }
                break;
            case DOCTOR:
                if (crew.getDoctor() < 10) {
                    crew.setDoctor(value);
                } else {
                    out.println("Congrats! You have reached the max Doctor level with: " + crew.getName());
                }
                break;
            case TRADER:
                if (crew.getTrader() < 10) {
                    crew.setTrader(value);
                } else {
                    out.println("Congrats! You have reached the max Trader level with: " + crew.getName());
                }
                break;
        }
    }

    public static enum Stats {
        PILOT, MECHANIC, FIGHTER, DOCTOR, TRADER
    }
}
