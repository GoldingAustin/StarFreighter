/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.Ship;
import java.util.ArrayList;
import starfreighter.StarFreighter;



/**
 *
 * @author austingolding
 */
class ShipMenuView extends View {
    static ArrayList<CrewMember> crew = StarFreighter.getCurrentGame().getCrewCon();
    Ship ship = new Ship();
    public ShipMenuView() {
       super("\n"
                + "\n--------------------------------"
                + "\n| Ship Menu                    |"
                + "\n--------------------------------"
                + "\nS - Display Ship Overview" 
                + "\nC - Assign " + crew.get(0).getName() + "'s Position " 
                + "\nN - Assign " + crew.get(1).getName() + "'s Position " 
                + "\nG - Assign " + crew.get(2).getName() + "'s Position " 
                + "\nD - Assign " + crew.get(3).getName() + "'s Position " 
                + "\nM - Assign " + crew.get(4).getName() + "'s Position " 
                + "\nF - Refuel Ship " 
                + "\nR - Repair Ship"
                + "\nE - Exit"
                + "\n--------------------------------");

 
    }

    @Override
    public boolean doAction(Object obj) {

        String value = (String) obj;
        char choice = value.charAt(0);

        switch (choice) {
            case 'S':
             System.out.println("\n"
                     + "Captain" + ship.getCaptain()
                     + "Engineer" + ship.getEngineer()
                     + "Gunner" + ship.getGunner()
                     + "Doctor" + ship.getDoctor()
                     + "Communications" + ship.getComms()
                     + "Fuel" + ship.getFuel());
                break;
            case 'C':
                this.assignPos(crew.get(0));
                break;
            case 'N':
                this.assignPos(crew.get(1));
                break;
            case 'G':
                this.assignPos(crew.get(2));
                break;
            case 'D':
                this.assignPos(crew.get(3));
                break;
            case 'M':
                this.assignPos(crew.get(4));
                break;
            case 'F':
                ship.setFuel(100);
                break;
            case 'R':
                ship.setRepair(100);
                break;
            case 'E':
                return true;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;

        }
        return false;
    }   

    private void assignPos(CrewMember crew) {
        AssignPosView assignP = new AssignPosView(crew);
        assignP.display(crew);
    }

}




