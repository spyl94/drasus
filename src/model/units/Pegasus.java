package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class Pegasus extends Unit {

    public Pegasus() {
	super(new AttackCaC(), 80, 30, 80, 7, 15, 35, 0, Weapon.BOW, "Pegasus");

    }

    @Override
    public void activatePower() {
	pow = true;

    }

}
