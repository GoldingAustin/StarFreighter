/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;
import byui.cit260.starFreighter.model.Enemy;
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
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
   
    /**
     * Generate and populate Enemy ArrayList with enemy stats
     */
    public EncounterController() {
         for (int i = 0; i <= (ThreadLocalRandom.current().nextInt(0, 6)); i++) {
          Enemy enemy = new Enemy();
          enemy.setHitpoints(ThreadLocalRandom.current().nextInt(1, 31));
          enemy.setaModifier(ThreadLocalRandom.current().nextInt(0, 11));
          enemy.setdModifier(ThreadLocalRandom.current().nextInt(0, 11));
          enemies.add(enemy);
      }
    }

    /**
     *
     * @param firstEnemy
     */
    public void addEnemy(Enemy firstEnemy) {
        enemies.add(firstEnemy);
    }  

    /**
     *
     * @return
     */
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    /**
     *
     * @param enemies
     */
    public void setEnemies(ArrayList<Enemy> enemies) {
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
        return "Encounter{" + "enemies=" + enemies + '}';
    }

   
    
}
