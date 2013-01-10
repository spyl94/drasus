package model.units;

import model.attack.AttackCaC;
import model.attack.AttackCaCIgnoreArmor;

/**
 * @author Aurel
 * 
 */
public class EclaireurPegasus extends Unit {

    public EclaireurPegasus() {
	super(new AttackCaC(), 30, 10, 95, 10, 5, 80, 0, Weapon.SWORD,
		"Eclaireur");

    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackCaCIgnoreArmor());
	
    }

}