package model.units;

import model.attack.AttackDistance;

/**
 * @author Aurel
 * 
 */
public class CavalierDragon extends Unit {

    public CavalierDragon() {
	super(new AttackDistance(1), 120, 30, 70, 8, 35, 35, 2, Weapon.LANCE,
		"Cavalier");
	setCavalry();
    }

    @Override
    public void activatePower() {
	pow = true;

    }

}
