/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.Ship;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/**
 *
 * @author austingolding
 */
class AssignPosView {

    Ship ship = new Ship();
    Scanner keyboard = new Scanner(in);
    protected String displayMessage;

    public AssignPosView(CrewMember crew) {
        this.displayMessage = "\n"
                + "\n--------------------------------"
                + "\n| Ship Assignment Menu         |"
                + "\n--------------------------------"
                + "\nC - Assign Captain Position "
                + "\nN - Assign Engineer Position "
                + "\nG - Assign Gunner Position "
                + "\nD - Assign Doctor Position "
                + "\nM - Assign Communication Position "
                + "\nE - Exit"
                + "\n--------------------------------";
    }

    public void display(CrewMember crew) {
        String value = "";
        boolean done = false;

        do {
            out.println(this.displayMessage);
            value = this.getInput();
            done = this.doAction(value, crew);

        } while (!done);
    }

    public String getInput() {
        boolean valid = false;
        String value = null;

        while (!valid) {

            value = keyboard.nextLine();
            value = toUpperCase(value);
            value = value.trim();

            if (value.length() != 1) {
                out.println("Invalid input - The value must be one letter");
                continue;
            }
            break;
        }
        return value;
    }

    public boolean doAction(String value, CrewMember crew) {
        char choice = value.charAt(0);
        switch (choice) {
            case 'C':
                ship.setCaptain(crew);
                displayPos(crew);
                break;
            case 'N':
                ship.setEngineer(crew);
                displayPos(crew);
                break;
            case 'G':
                ship.setGunner(crew);
                displayPos(crew);
                break;
            case 'D':
                ship.setDoctor(crew);
                displayPos(crew);
                break;
            case 'M':
                ship.setComms(crew);
                displayPos(crew);
                break;
            case 'E':
            ShipMenuView shipMenu = new ShipMenuView();
            shipMenu.display();
            default:
                out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void displayPos(CrewMember crew) {

        System.out.println("\n"
                + "Captain" + ship.getCaptain()
                + "Engineer" + ship.getEngineer()
                + "Gunner" + ship.getGunner()
                + "Doctor" + ship.getDoctor()
                + "Communications" + ship.getComms()
                + "Fuel" + ship.getFuel());
    }

}
