package model.units;

import model.attack.AttackCaCCripple;
import model.attack.AttackCaCCrippleLonger;

/**
 * @author Aurel
 * 
 */
public class BretteurPegasus extends Unit {

    public BretteurPegasus() {
	super(new AttackCaCCripple(), 200, 40, 90, 5, 20, 30, 0, Weapon.SWORD,
		"Bretteur");
    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackCaCCrippleLonger());

    }

}
