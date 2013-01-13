package model.units;

import model.attack.AttackDistance;

/**
 * @author Aurel
 * 
 */
public class ChevalierDragon extends Unit {

    public ChevalierDragon() {
	super(new AttackDistance(1), 240, 65, 90, 4, 25, 10, 0, Weapon.UNKNOWN,
		"Chevalier");
    }

    @Override
    public void activatePower() {
	pow = true;

    }

}
