/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

import byui.cit260.starFreighter.model.CombatEncounter;
import byui.cit260.starFreighter.model.CrewMember;
import java.io.Serializable;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
public class EncounterController implements Serializable {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static final ArrayList<CrewMember> crew = StarFreighter.getCurrentGame().getCrewCon();

    private final ArrayList<CombatEncounter> enemies = new ArrayList<>();
    private final ArrayList<CombatEncounter> allies = new ArrayList<>();
    int h = 0;
    int z = 0;
    int r = 0;
    int y = 0;

    /**
     * Generate and populate Enemy ArrayList with enemy stats
     */
    public EncounterController() {

    }

    public void run() {
        generateEncounter();
//        battleboard();
        for (int l = 0; l <= 4; l++) {
            calculateDamage();
            damageEnemy();
        }
        out.println("You've defeated " + ANSI_YELLOW + y + ANSI_RED + " Space Pirates!");
    }

    /**
     *
     */
    public void generateEncounter() {

        Random rand = new Random();

        for (int j = 0; j < 4; j++) {
            CombatEncounter enemy = new CombatEncounter();
            int hitpoints = (rand.nextInt(30 - 1) + 1);
            enemy.setHitPoints(hitpoints);
            int dmgmod = (rand.nextInt(10 - 1) + 1);
            enemy.setDamageModifiers(dmgmod);
            int defmod = (int) (((rand.nextInt(10 - 1) + 1) * .1) * enemy.getHitPoints());
            enemy.setDefenseModifiers(defmod);
            enemy.setAlive(true);
            enemy.setName("Space Pirate");
            out.println(j);
            enemies.add(j, enemy);
        }
    }

    /**
     *
     */
    public void calculateDamage() {

        Random rand = new Random();
        for (int i = 0; i <= 4; i++) {
            CombatEncounter player = new CombatEncounter();
            int attack = rand.nextInt(10 - 1) + 1;
            int mod = crew.get(i).getFighter();
            player.setDamageModifiers((int) (((mod * .1) * attack)));
            player.setAlive(true);
            player.setHitPoints(crew.get(i).getHitPoints());
            player.setDamage(attack + player.getDamageModifiers());
            allies.add(i, player);
        }
    }

    /**
     *
     */
    public void damageEnemy() {

        while (z <= 3) {

            if (enemies.get(z).getHitPoints() <= 0) {
                out.println("You have defeated " + ANSI_RED + enemies.get(z).getName() + ANSI_RESET);
                z++;
                y++;

            } else {
                enemies.get(z).setHitPoints(enemies.get(z).getHitPoints() - allies.get(h).getDamage());
                out.println(ANSI_GREEN + crew.get(h).getName() + ANSI_RESET + " Did " + ANSI_BLUE + allies.get(h).getDamage() + ANSI_RESET + " damage! to " + ANSI_RED + enemies.get(z).getName() + ANSI_RESET);
                out.println(ANSI_RED + enemies.get(z).getName() + ANSI_RESET + ": " + ANSI_PURPLE + enemies.get(z).getHitPoints() + ANSI_RESET);
                h++;
                if (h == 4) {

                    while (r <= 3) {
                        Random rand = new Random();
                        int damage = rand.nextInt(10 - 1) + 1;
                        allies.get(r).setHitPoints(allies.get(r).getHitPoints() - damage);
                        crew.get(r).setHitPoints(crew.get(r).getHitPoints() - damage);
                        out.println(ANSI_RED + enemies.get(r).getName() + ANSI_RESET + " Did " + damage + " damage! to " + ANSI_GREEN + (crew.get(r).getName()) + ANSI_RESET);
                        r++;
                    }
                    r = 0;
                    h = 0;
                }
            }
            
        }

    }

//    public static void battleboard() throws InterruptedException {
//        Thread th = new Thread() {
//                Console.Write("\r" + "Battle Live Feed");
//                System.out.write(     "\r" +  "Enemies");
//                 System.out.write(    "\r" +  enemies.get(0).getName() + "---" + enemies.get(0).getHitPoints());
//                 System.out.write(    "\r" +  enemies.get(1).getName() + "---" + enemies.get(1).getHitPoints() );
//                 out.println(    "\r" +  enemies.get(2).getName() + "---" + enemies.get(2).getHitPoints() );
//                 out.println(    "\r" +  enemies.get(3).getName() + "---" + enemies.get(3).getHitPoints()); 
//                 out.println(    "\r" +  "----------------------------"  ); 
//                 out.println(    "\r" +  "Allies" );
//                 out.println(    "\r" +  crew.get(0).getName() + "---" + crew.get(0).getHitPoints());
//                 out.println(    "\r" +  crew.get(1).getName() + "---" + crew.get(1).getHitPoints() );
//                 out.println(    "\r" +  crew.get(2).getName() + "---" + crew.get(2).getHitPoints() );
//                 out.println(   "\r" +  crew.get(3).getName() + "---" + crew.get(3).getHitPoints() );
//                 out.println(    "\r" +  crew.get(4).getName() + "---" + crew.get(4).getHitPoints() );
//                  out.println(   "\r" +  crew.get(5).getName() + "---" + crew.get(5).getHitPoints() );
//        try {
//            Thread.sleep(500);
//        } 
//        };
//        th.start();
//    }
//        if (enemy.isAlive() == true && player.getDamage() > 0 && player.isAlive()) {
//            enemy.setHitPoints(enemy.getHitPoints() - player.getDamage());
//
//            if (enemy.getHitPoints() <= 0) {
//                enemy.setAlive(false);
//                return enemy.getHitPoints();
//            }
//            return enemy.getHitPoints();
//        }
//        if (enemy.isAlive() == false) {
//            out.println("Your Enemy is Dead");
//            return enemy.getHitPoints();
//        }
//        if (player.getDamage() <= 0) {
//            out.println("You did 0 Damage");
//            return enemy.getHitPoints();
//        }
//
    /**
     *
     * @return
     */
    public ArrayList<CombatEncounter> getEnemies() {
        return enemies;
    }

    /**
     *
     */
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
        return "EncounterController{" + "enemies=" + enemies + ", player=" + allies + '}';
    }

}
