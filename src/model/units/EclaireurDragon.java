package model.units;

import model.attack.AttackCaC;
import model.attack.AttackCaCIgnoreArmor;

/**
 * @author Aurel
 * 
 */
public class EclaireurDragon extends Unit {

	public EclaireurDragon() {
		super(new AttackCaC(), 180, 45, 95, 6, 20, 50, 0, Weapon.DAGGER,
				"Eclaireur");

	}

	@Override
	public void activatePower() {
		pow = true;
		setIAttack(new AttackCaCIgnoreArmor());

	}

}
