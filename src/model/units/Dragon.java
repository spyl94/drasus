package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class Dragon extends Unit {

    public Dragon() {
	super(new AttackCaC(), 80, 30, 80, 7, 15, 35, 0, Weapon.BOW, "Dragon");

    }

    @Override
    public void activatePower() {
	pow = true;
    }

}
