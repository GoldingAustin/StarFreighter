/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.model;

import java.io.Serializable;

/**
 *
 * @author austingolding
 */
public class Game implements Serializable{

    private CombatEncounter[] combat;
    private Coordinates coorD;
    private CrewMember crew;
    private GameMap[] gamem;
    private Item[] item;
    private JobBoard[] jobs;
    private Location[] location;
    private MerchantStock[] merch;
    private Planet[] planet;
    private Ship ship;
    public Game() {
    }

    public CombatEncounter[] getCombat() {
        return combat;
    }

    public void setCombat(CombatEncounter[] combat) {
        this.combat = combat;
    }

    public Coordinates getCoorD() {
        return coorD;
    }

    public void setCoorD(Coordinates coorD) {
        this.coorD = coorD;
    }

    public CrewMember getCrewM() {
        return crew;
    }

    public void setCrewM(CrewMember crew) {
        this.crew = crew;
    }

    public GameMap[] getGamem() {
        return gamem;
    }

    public void setGamem(GameMap[] gamem) {
        this.gamem = gamem;
    }

    public Item[] getItem() {
        return item;
    }

    public void setItem(Item[] item) {
        this.item = item;
    }

    public JobBoard[] getJobs() {
        return jobs;
    }

    public void setJobs(JobBoard[] jobs) {
        this.jobs = jobs;
    }

    public Location[] getLocation() {
        return location;
    }

    public void setLocation(Location[] location) {
        this.location = location;
    }

    public MerchantStock[] getMerch() {
        return merch;
    }

    public void setMerch(MerchantStock[] merch) {
        this.merch = merch;
    }

    public Planet[] getPlanet() {
        return planet;
    }

    public void setPlanet(Planet[] planet) {
        this.planet = planet;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    
    
    
    
}
