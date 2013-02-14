package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class Pegasus extends Unit {

	public Pegasus() {
		super(new AttackCaC(), 250, 60, 80, 0, 10, 10, 0, Weapon.HEROIC,
				"Pegasus");

	}

	@Override
	public void activatePower() {
		pow = true;

	}

}
