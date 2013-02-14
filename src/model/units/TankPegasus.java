package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class TankPegasus extends Unit {

	public TankPegasus() {
		super(new AttackCaC(), 250, 50, 60, 4, 35, 5, 0, Weapon.LANCE, "Tank");

	}

	@Override
	public void activatePower() {
		pow = true;

	}
}
