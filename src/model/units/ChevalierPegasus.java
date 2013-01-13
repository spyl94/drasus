package model.units;

import model.attack.AttackDistance;

/**
 * @author Aurel
 * 
 */
public class ChevalierPegasus extends Unit {

    public ChevalierPegasus() {
	super(new AttackDistance(1), 240, 60, 90, 4, 25, 10, 0, Weapon.SWORD,
		"Chevalier");
    }

    @Override
    public void activatePower() {
	pow = true;

    }

}
