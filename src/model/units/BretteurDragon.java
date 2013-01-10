package model.units;

import model.attack.AttackCaCCripple;
import model.attack.AttackCaCCrippleLonger;

/**
 * @author Aurel
 * 
 */
public class BretteurDragon extends Unit {

    public BretteurDragon() {
	super(new AttackCaCCripple(), 80, 30, 95, 6, 10, 50, 0, Weapon.SWORD,
		"Bretteur");

    }
    
    public void activatePower() {
	pow = true;
	setIAttack(new AttackCaCCrippleLonger());
    }

}
