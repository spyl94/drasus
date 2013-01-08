package model.units;

import model.attack.AttackDistance;

/**
 * @author Aurel
 * 
 */
public class ArcherMontePegasus extends Unit {

    public ArcherMontePegasus() {
	super(new AttackDistance(3), 70, 25, 75, 8, 10, 25, 2, Weapon.BOW,
		"Archer");

    }

}
