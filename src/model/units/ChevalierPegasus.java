package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class ChevalierPegasus extends Unit {

	public ChevalierPegasus() {
		super(new AttackCaC(), 240, 60, 90, 4, 25, 10, 0, Weapon.UNKNOWN,
				"Chevalier");
	}

	@Override
	public void activatePower() {
		pow = true;

	}

}
