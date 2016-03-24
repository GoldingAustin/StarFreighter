/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.starFreighter.controller;

/**
 *
 * @author austingolding
 */
public class JobsController {

    private final MerchantController inventory = new MerchantController();
    int quest = 0;

    public JobsController() {
    }

    public void mine() {
        if (inventory.sellItem(inventory.itemList().get(6)) == true) {
            quest++;
        }
    }
}
