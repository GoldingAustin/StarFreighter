/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.view;

import static byui.cit260.starFreighter.controller.GameControl.captain;
import static byui.cit260.starFreighter.controller.GameControl.crewFou;
import static byui.cit260.starFreighter.controller.GameControl.crewOne;
import static byui.cit260.starFreighter.controller.GameControl.crewThr;
import static byui.cit260.starFreighter.controller.GameControl.crewTwo;
import byui.cit260.starFreighter.model.CrewMember;
import byui.cit260.starFreighter.model.Ship;



/**
 *
 * @author austingolding
 */
class ShipMenuView extends View {
    Ship ship = new Ship();
    public ShipMenuView() {
       super("\n"
                + "\n--------------------------------"
                + "\n| Ship Menu                    |"
                + "\n--------------------------------"
                + "\nS - Display Ship Overview" 
                + "\nC - Assign " + captain.getName() + "'s Position " 
                + "\nN - Assign " + crewOne.getName() + "'s Position " 
                + "\nG - Assign " + crewTwo.getName() + "'s Position " 
                + "\nD - Assign " + crewThr.getName() + "'s Position " 
                + "\nM - Assign " + crewFou.getName() + "'s Position " 
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
                this.assignPos(captain);
                break;
            case 'N':
                this.assignPos(crewOne);
                break;
            case 'G':
                this.assignPos(crewTwo);
                break;
            case 'D':
                this.assignPos(crewThr);
                break;
            case 'M':
                this.assignPos(crewFou);
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




