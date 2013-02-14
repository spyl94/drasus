package model.units;

import model.attack.AttackDistance;
import model.attack.AttackDistanceDoubledAgainstCavalry;

/**
 * @author Aurel
 * 
 */
public class LancierPegasus extends Unit {

	public LancierPegasus() {
		super(new AttackDistance(2), 220, 50, 75, 5, 25, 10, 0, Weapon.LANCE,
				"Lancier");
	}

	@Override
	public void activatePower() {
		pow = true;
		setIAttack(new AttackDistanceDoubledAgainstCavalry(2));

	}

}
