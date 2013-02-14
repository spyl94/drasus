package model.units;

import model.attack.AttackCaCBerserker;
import model.attack.AttackCaCBerserkerBoosted;

/**
 * @author Aurel
 * 
 */
public class BerserkerPegasus extends Unit {

	public BerserkerPegasus() {
		super(new AttackCaCBerserker(), 240, 60, 80, 5, 5, 10, 0, Weapon.AXE,
				"Berserker");

	}

	@Override
	public void activatePower() {
		pow = true;
		setIAttack(new AttackCaCBerserkerBoosted());
	}

}
