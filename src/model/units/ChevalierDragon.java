package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class ChevalierDragon extends Unit {

    public ChevalierDragon() {
	super(new AttackCaC(), 240, 65, 90, 4, 25, 10, 0, Weapon.UNKNOWN,
		"Chevalier");
    }

    @Override
    public void activatePower() {
	pow = true;

    }

}
