package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class FantassinPegasus extends Unit {

    public FantassinPegasus() {
	super(new AttackCaC(), 100, 20, 80, 5, 35, 20, 0, Weapon.SWORD,
		"Fantassin");

    }

    @Override
    public void activatePower() {
	pow = true;
    }

}
