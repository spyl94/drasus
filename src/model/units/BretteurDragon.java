package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class BretteurDragon extends Unit {

    public BretteurDragon() {
	super(new AttackCaC(), 80, 30, 95, 6, 10, 50, 0, Weapon.SWORD,
		"Bretteur");

    }

}
