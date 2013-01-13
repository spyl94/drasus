package model.units;

import model.attack.AttackCaC;
import model.attack.AttackCaCIgnoreArmor;

/**
 * @author Aurel
 * 
 */
public class EclaireurPegasus extends Unit {

    public EclaireurPegasus() {
	super(new AttackCaC(), 180, 40, 95, 6, 20, 50, 0, Weapon.DAGGER,
		"Eclaireur");

    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackCaCIgnoreArmor());

    }

}
