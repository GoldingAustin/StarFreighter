/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.CombatEncounter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 *
 * @author austingolding
 */
public final class EncounterController {

    Random rand;
    private ArrayList<CombatEncounter> enemies = new ArrayList<>();
    CombatEncounter player = new CombatEncounter();
    CombatEncounter enemy = new CombatEncounter();

    /**
     * Generate and populate Enemy ArrayList with enemy stats
     */
    public EncounterController() {
        this.rand = new Random();
        //      generateEncounter();
        //     calculateDamage(attack, mod);
        //    damageEnemy();

    }

    /**
     *
     */
    public void generateEncounter() {
        for (int i = 0; i <= (current().nextInt(0, 6)); i++) {

            enemy.setHitPoints(current().nextInt(1, 31));
            enemy.setDamageModifiers(current().nextInt(0, 11));
            enemy.setDefenseModifiers((int) ((current().nextInt(0, 11) * .1) * enemy.getHitPoints()));
            enemy.setAlive(true);
            player.setAlive(true);
            enemies.add(enemy);
        }
    }

    /**
     *
     * @param attack
     * @param mod
     * @return
     */
    public int calculateDamage(int attack, int mod) {
        // attack = (ThreadLocalRandom.current().nextInt(0, 11));
        player.setDamageModifiers((int) (((mod * .1) * attack)));
        player.setDamage(attack + player.getDamageModifiers());

        enemies.add(player);
        return player.getDamage();
    }

    /**
     *
     * @return
     */
    public int damageEnemy() {
        if (enemy.isAlive() == true && player.getDamage() > 0 && player.isAlive()) {
            enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());

            if (enemy.getHitPoints() <= 0) {
                enemy.setAlive(false);
                return enemy.getHitPoints();
            }
           return enemy.getHitPoints();
        }
        if (enemy.isAlive() == false) {
            out.println("Your Enemy is Dead");
            return enemy.getHitPoints();
        }
        if (player.getDamage() <= 0) {
            out.println("You did 0 Damage");
            return enemy.getHitPoints();
        }
        return -1;
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
