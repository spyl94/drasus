package model.units;

import model.attack.AttackDistance;
import model.attack.AttackDistanceArcher;

/**
 * @author Aurel
 * 
 */
public class ArcherDragon extends Unit {

    public ArcherDragon() {
	super(new AttackDistance(3), 50, 20, 70, 5, 10, 25, 0, Weapon.BOW,
		"Archer");

    }
    
    public void activatePower() {
	pow = true;
	setIAttack(new AttackDistanceArcher(3));
    }

}
