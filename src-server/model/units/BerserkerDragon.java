package model.units;

import model.attack.AttackCaCBerserker;
import model.attack.AttackCaCBerserkerBoosted;

/**
 * @author Aurel
 * 
 */
public class BerserkerDragon extends Unit {

    public BerserkerDragon() {
	super(new AttackCaCBerserker(), 240, 65, 80, 4, 5, 10, 0, Weapon.AXE,
		"Berserker");

    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackCaCBerserkerBoosted());
    }

}
