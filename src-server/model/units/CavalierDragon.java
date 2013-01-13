package model.units;

import model.attack.AttackCaC;
import model.attack.AttackCaCBoostedInHill;
import model.attack.AttackDistance;

/**
 * @author Aurel
 * 
 */
public class CavalierDragon extends Unit {

    public CavalierDragon() {
	super(new AttackCaC(), 240, 55, 75, 7, 20, 10, 2, Weapon.LANCE,
		"Cavalier");
    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackCaCBoostedInHill());
    }

}
