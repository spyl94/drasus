package model.units;

import model.attack.AttackDistance;

/**
 * @author Aurel
 * 
 */
public class LancierPegasus extends Unit {

    public LancierPegasus() {
	super(new AttackDistance(2), 60, 25, 75, 5, 25, 30, 0, Weapon.LANCE,
		"Lancier");

    }

}
