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
 * @author austingolding
 */
public class JobBoard implements Serializable {

    private String job;
    private Planet planet;
    private String locName;
    private int reward;
    
    public JobBoard(String job, Planet planet, String locName, int reward) {
        this.job = job;
        this.planet = planet;
        this.reward = reward;
        this.locName = locName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Planet getLocation() {
        return planet;
    }

    public void setLocation(Planet planet) {
        this.planet = planet;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.job);
        hash = 83 * hash + Objects.hashCode(this.planet);
        hash = 83 * hash + this.reward;
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
        final JobBoard other = (JobBoard) obj;
        if (this.reward != other.reward) {
            return false;
        }
        if (!Objects.equals(this.job, other.job)) {
            return false;
        }
        if (!Objects.equals(this.planet, other.planet)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "JobBoard{" + "job=" + job + ", location=" + planet + ", reward=" + reward + '}';
    }

}
