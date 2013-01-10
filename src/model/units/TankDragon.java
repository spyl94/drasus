package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class TankDragon extends Unit {

    public TankDragon() {
	super(new AttackCaC(), 100, 10, 70, 3, 65, 5, 0, Weapon.LANCE, "Tank");

    }

    @Override
    public void activatePower() {
	pow = true;
	
    }
}
