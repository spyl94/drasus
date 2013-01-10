package model.units;

import model.attack.AttackDistancePoisoned;
import model.attack.AttackDistancePoisonedLonger;

/**
 * @author Aurel
 * 
 */
public class ArcherMontePegasus extends Unit {

    public ArcherMontePegasus() {
	super(new AttackDistancePoisoned(3), 70, 25, 75, 8, 10, 25, 2, Weapon.BOW,
		"ArcherMonte");

    }
    
    public void activatePower() {
	pow = true;
 	setIAttack(new AttackDistancePoisonedLonger(3));
     }

}
