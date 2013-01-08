package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class EclaireurPegasus extends Unit {

    public EclaireurPegasus() {
	super(new AttackCaC(), 30, 10, 95, 10, 5, 80, 0, Weapon.SWORD,
		"Eclaireur");

    }

}
