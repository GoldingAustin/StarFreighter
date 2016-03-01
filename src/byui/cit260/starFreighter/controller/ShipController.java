/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.Ship;

/**
 *
 * @author Connor
 */
public class ShipController {
    public ShipController() {
        
    }
    
    /**
     * Removes the specified crew member from their current assignment.
     * @param ship
     * @param crew
     */
    private void removeAssignment(Ship ship, CrewMember crew) {
        if (crew == ship.getCaptain()) {
            ship.setCaptain(null);
        }
        if (crew == ship.getEngineer()) {
            ship.setEngineer(null);
        }
        if (crew == ship.getGunner()) {
            ship.setGunner(null);
        }
        if (crew == ship.getDoctor()) {
            ship.setDoctor(null);
        }
        if (crew == ship.getComms()) {
            ship.setComms(null);
        }
    }
    
    /* Java error shenanigans, can't be bothered to make changes
    public CrewMember getCrewMemberAtPosition(Ship ship, Positions position) {
        CrewMember crewMemberAtPosition;
        switch (position) {
            case CAPTAIN:
                crewMemberAtPosition = ship.getCaptain();
                break;
            case ENGINEER:
                crewMemberAtPosition = ship.getEngineer();
                break;
            case GUNNER:
                crewMemberAtPosition = ship.getGunner();
                break;
            case DOCTOR:
                crewMemberAtPosition = ship.getDoctor();
                break;
            case COMMS:
                crewMemberAtPosition = ship.getComms();
                break;
        }
        return crewMemberAtPosition;
    }
    /*
    
    /**
     *
     * @param ship
     * @param crew
     */
    public void assignPosition(Ship ship, CrewMember crew, Positions position) {
        this.removeAssignment(ship, crew);
        switch (position) {
            case CAPTAIN:
                ship.setCaptain(crew);
                break;
            case ENGINEER:
                ship.setEngineer(crew);
                break;
            case GUNNER:
                ship.setGunner(crew);
                break;
            case DOCTOR:
                ship.setDoctor(crew);
                break;
            case COMMS:
                ship.setComms(crew);
                break;
        }
    }
    
    public static enum Positions {
        CAPTAIN, ENGINEER, GUNNER, DOCTOR, COMMS
    }
}
