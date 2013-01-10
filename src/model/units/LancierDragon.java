package model.units;

import model.attack.AttackDistance;
import model.attack.AttackDistanceDoubledAgainstCavalry;

/**
 * @author Aurel
 * 
 */
public class LancierDragon extends Unit {

    public LancierDragon() {
	super(new AttackDistance(2), 60, 25, 75, 5, 25, 30, 0, Weapon.LANCE,
		"Lancier");

    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackDistanceDoubledAgainstCavalry(2));
	
    }

}
