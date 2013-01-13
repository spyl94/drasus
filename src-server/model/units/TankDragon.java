package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class TankDragon extends Unit {

    public TankDragon() {
	super(new AttackCaC(), 250, 55, 60, 3, 35, 5, 0, Weapon.LANCE, "Tank");

    }

    @Override
    public void activatePower() {
	pow = true;

    }
}
