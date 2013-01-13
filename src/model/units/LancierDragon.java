package model.units;

import model.attack.AttackDistance;
import model.attack.AttackDistanceDoubledAgainstCavalry;

/**
 * @author Aurel
 * 
 */
public class LancierDragon extends Unit {

    public LancierDragon() {
	super(new AttackDistance(2), 220, 55, 75, 4, 25, 10, 0, Weapon.LANCE,
		"Lancier");

    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackDistanceDoubledAgainstCavalry(2));

    }

}
