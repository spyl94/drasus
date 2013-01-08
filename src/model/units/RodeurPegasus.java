package model.units;

import model.attack.AttackDistance;

/**
 * @author Aurel
 * 
 */
public class RodeurPegasus extends Unit {

    public RodeurPegasus() {
	super(new AttackDistance(3), 80, 30, 80, 7, 15, 35, 0, Weapon.BOW,
		"Rodeur");

    }

}
