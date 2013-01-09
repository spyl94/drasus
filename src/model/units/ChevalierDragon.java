package model.units;

import model.attack.AttackDistance;

/**
 * @author Aurel
 * 
 */
public class ChevalierDragon extends Unit {

    public ChevalierDragon() {
	super(new AttackDistance(1), 120, 25, 75, 8, 35, 25, 0, Weapon.SWORD,
		"Chevalier");

    }

}
