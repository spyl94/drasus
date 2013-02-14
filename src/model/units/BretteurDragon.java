package model.units;

import model.attack.AttackCaCCripple;
import model.attack.AttackCaCCrippleLonger;

/**
 * @author Aurel
 * 
 */
public class BretteurDragon extends Unit {

	public BretteurDragon() {
		super(new AttackCaCCripple(), 200, 45, 90, 5, 20, 30, 0, Weapon.SWORD,
				"Bretteur");
	}

	@Override
	public void activatePower() {
		pow = true;
		setIAttack(new AttackCaCCrippleLonger());
	}

}
