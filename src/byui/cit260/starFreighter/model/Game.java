/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author austingolding
 */
public class Game implements Serializable {

    private CombatEncounter combat;
    private Coordinates coorD;
    private Item[] item;
    private ArrayList<CrewMember> crewC;
    private ArrayList<JobBoard> jobs;
    private Location[] location;
    private Planet[] planet;
    private MerchantStock merch;
    private GameMap gameMap;
    private Ship ship;

    public Game() {
    }

    public CombatEncounter getCombat() {
        return combat;
    }

    public void setCombat(CombatEncounter combat) {
        this.combat = combat;
    }

    public Coordinates getCoorD() {
        return coorD;
    }

    public void setCoorD(Coordinates coorD) {
        this.coorD = coorD;
    }

    public ArrayList<CrewMember> getCrewCon() {
        return crewC;
    }

    public void setCrewCon(ArrayList<CrewMember> crewC) {
        this.crewC = crewC;
    }

    public Item[] getItem() {
        return item;
    }

    public void setItem(Item[] item) {
        this.item = item;
    }

    public ArrayList<JobBoard> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<JobBoard> jobs) {
        this.jobs = jobs;
    }

    public Location[] getLocation() {
        return location;
    }

    public void setLocation(Location[] location) {
        this.location = location;
    }

    public MerchantStock getMerch() {
        return merch;
    }

    public void setMerch(MerchantStock merch) {
        this.merch = merch;
    }

    public GameMap getMap() {
        return this.gameMap;
    }

    public void setGameMap(GameMap newMap) {
        this.gameMap = newMap;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

}
