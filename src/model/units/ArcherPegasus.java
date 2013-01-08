package model.units;

import model.attack.AttackDistance;

/**
 * @author Aurel
 * 
 */
public class ArcherPegasus extends Unit {

    public ArcherPegasus() {
	super(new AttackDistance(3), 50, 20, 70, 5, 10, 25, 0, Weapon.BOW,
		"Archer");

    }

}
