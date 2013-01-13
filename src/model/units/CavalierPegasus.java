package model.units;

import model.attack.AttackCaC;
import model.attack.AttackCaCBoostedInHill;


/**
 * @author Aurel
 * 
 */
public class CavalierPegasus extends Unit {

    public CavalierPegasus() {
	super(new AttackCaC(), 240, 50, 75, 7, 20, 10, 2, Weapon.LANCE,
		"Cavalier");
    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackCaCBoostedInHill());

    }

}
