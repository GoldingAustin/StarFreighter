/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.CombatEncounter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author austingolding
 */
public class EncounterController {

    Random rand = new Random();
    private ArrayList<CombatEncounter> enemies = new ArrayList<CombatEncounter>();
    CombatEncounter player = new CombatEncounter();
    CombatEncounter enemy = new CombatEncounter();

    /**
     * Generate and populate Enemy ArrayList with enemy stats
     */
    public EncounterController() {
        generateEncounter();
        calculateDamage();
        damageEnemy();

    }

    /**
     *
     */
    public void generateEncounter() {
        for (int i = 0; i <= (ThreadLocalRandom.current().nextInt(0, 6)); i++) {

            enemy.setHitPoints(ThreadLocalRandom.current().nextInt(1, 31));
            enemy.setDamageModifiers(ThreadLocalRandom.current().nextInt(0, 11));
            enemy.setDefenseModifiers((int) ((ThreadLocalRandom.current().nextInt(0, 11) * .1) * enemy.getHitPoints()));
            enemy.setAlive(true);
            player.setAlive(true);
            player.setDamageModifiers(5);
            enemies.add(enemy);
        }
    }

    /**
     *
     */
    public void calculateDamage() {
        int attack;
        int modified;
        attack = (ThreadLocalRandom.current().nextInt(0, 11));
        modified =  (int) (((attack * .1) * player.getDamageModifiers()));
        player.setDamage(attack + modified);

        enemies.add(player);
        System.out.println("enemies=" + enemies + ", player=" + player);

    }

    /**
     *
     */
    public void damageEnemy() {
        if (enemy.isAlive() == true && player.getDamage() > 0 && player.isAlive()) {
            enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

            if (enemy.getHitPoints() <= 0) {
                enemy.setAlive(false);
            }

        } 
        else if (enemy.isAlive() == false){
            System.out.println("Your Enemy is Dead");
        }
        else if (player.getDamage() <= 0){
            System.out.println("You did 0 Damage");
        }

    }

    /**
     *
     * @return
     */
    public ArrayList<CombatEncounter> getEnemies() {
        return enemies;
    }

    /**
     *
     * @param enemies
     */
    public void setEnemies(ArrayList<CombatEncounter> enemies) {
        this.enemies = enemies;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.enemies);
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
        final EncounterController other = (EncounterController) obj;
        if (!Objects.equals(this.enemies, other.enemies)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EncounterController{" + "enemies=" + enemies + ", player=" + player + '}';
    }

}
