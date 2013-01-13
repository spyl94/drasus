package model.units;

import model.attack.AttackDistance;
import model.attack.AttackDistanceArcher;

/**
 * @author Aurel
 * 
 */
public class ArcherPegasus extends Unit {

    public ArcherPegasus() {
	super(new AttackDistance(4), 100, 50, 80, 5, 15, 10, 0, Weapon.BOW,
		"Archer");

    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackDistanceArcher(3));
    }
}
