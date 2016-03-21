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
import starfreighter.StarFreighter;

/**
 *
 * @author austingolding
 */
public class EncounterController implements Serializable {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32;1;2m";
    public static final String ANSI_YELLOW = "\u001B[33;1;2m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35;1m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static final ArrayList<CrewMember> crew = StarFreighter.getCurrentGame().getCrewCon();

    private final ArrayList<CombatEncounter> enemies = new ArrayList<>();
    private final ArrayList<CombatEncounter> allies = new ArrayList<>();
    int h = 0;
    int z = 0;
    int r = 0;
    int y = 0;
    int a = 0;

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
        int numEn = rand.nextInt(5 - 2) + 2;
        for (int j = 0; j < numEn; j++) {
            CombatEncounter enemy = new CombatEncounter();
            int hitpoints = (rand.nextInt(30 - 25) + 25);
            enemy.setHitPoints(hitpoints);
            int dmgmod = (rand.nextInt(10 - 1) + 1);
            enemy.setDamageModifiers(dmgmod);
            int defmod = (int) (((rand.nextInt(10 - 1) + 1) * .1) * enemy.getHitPoints());
            enemy.setDefenseModifiers(defmod);
            enemy.setAlive(true);
            enemy.setName("Space Pirate" + " " + (j + 1));
            enemies.add(j, enemy);
        }
    }

    /**
     *
     */
    public void calculateDamage() {

        Random rand = new Random();
        for (int i = 0; i <= 5; i++) {
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
        out.println(" ");
        while (z < enemies.size()) {

            if (enemies.get(z).getHitPoints() <= 0) {
                out.println("You have defeated " + ANSI_RED + enemies.get(z).getName() + ANSI_RESET);
                enemies.get(z).setAlive(false);
                out.println(" ");
                out.println("------------------ ");
                z++;
                y++;

            } else {
                out.println(" ");
                enemies.get(z).setHitPoints(enemies.get(z).getHitPoints() - allies.get(h).getDamage());
                out.println(ANSI_GREEN + crew.get(h).getName() + ANSI_RESET + " Did " + ANSI_BLUE + allies.get(h).getDamage() + ANSI_RESET + " damage! to " + ANSI_RED + enemies.get(z).getName() + ANSI_RESET);
                out.println(ANSI_RED + enemies.get(z).getName() + ANSI_RESET + ": " + ANSI_PURPLE + enemies.get(z).getHitPoints() + ANSI_RESET);
                out.println(" ");
                h++;
                if (h == (allies.size() - 1)) {

                    out.println(" ");
                    while (r < enemies.size()) {
                        if (enemies.get(r).isAlive()) {
                            Random rand = new Random();
                            int damage = rand.nextInt(10 - 1) + 1;
                            allies.get(a).setHitPoints(allies.get(a).getHitPoints() - damage);
                            crew.get(a).setHitPoints(crew.get(a).getHitPoints() - damage);
                            out.println(ANSI_RED + enemies.get(r).getName() + ANSI_RESET + " Did " + damage + " damage! to " + ANSI_GREEN + (crew.get(a).getName()) + ANSI_RESET);
                            out.println(ANSI_GREEN + crew.get(a).getName() + ": " + ANSI_CYAN + crew.get(a).getHitPoints() + ANSI_RESET);
                            out.println(" ");
                            if (crew.get(a).getHitPoints() <= 0) {
                                out.println(ANSI_RED + enemies.get(r).getName() + ANSI_RESET + " has defeated " + ANSI_GREEN + crew.get(a).getName());
                                allies.get(a).setAlive(false);
                            }
                            if (a == (allies.size() - 1)) {
                                a = 0;
                            }
                            a++;

                        }
                        r++;
                    }
                    r = 0;
                    h = 0;
                }
            }

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
