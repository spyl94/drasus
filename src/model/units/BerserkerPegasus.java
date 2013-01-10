package model.units;

import model.attack.AttackCaCBerserker;
import model.attack.AttackCaCBerserkerBoosted;

/**
 * @author Aurel
 * 
 */
public class BerserkerPegasus extends Unit {

    public BerserkerPegasus() {
	super(new AttackCaCBerserker(), 130, 45, 85, 5, 10, 15, 0, Weapon.AXE,
		"Berserker");

    }
    
    public void activatePower() {
	pow = true;
 	setIAttack(new AttackCaCBerserkerBoosted());
     }

}
