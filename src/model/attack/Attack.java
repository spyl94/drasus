package model.attack;

import model.exception.DeadUnitException;
import model.units.Unit;

/**
 * @author Aurel
 * 
 */
public abstract class Attack implements IAttack {

    @Override
    public abstract String attack(Unit att, Unit deff, boolean tank)
	    throws DeadUnitException;

    @Override
    public abstract boolean canAttackFromRange(int i);

    /**
     * Determine randomly if the unit has touched the target.
     * 
     * @param i
     *            the probability of hit
     * @return true if the attack succeed or false otherwise
     */
    protected boolean canHit(int i) {
	return (int) (Math.random() * (101)) < i;
    }

    @Override
    public int getRange() {
	return 1;
    }

    /**
     * Determine if the weapon has an advantage versus the other weapon.
     * 
     * @param a
     *            weapon of first unit
     * @param b
     *            weapon of second unit
     * @return true if advantage or false otherwise
     */
    protected boolean trinityAdvantage(Unit.Weapon a, Unit.Weapon b) {
	return (a == Unit.Weapon.SWORD && b == Unit.Weapon.LANCE)
		|| (a == Unit.Weapon.LANCE && b == Unit.Weapon.AXE)
		|| (a == Unit.Weapon.AXE && b == Unit.Weapon.SWORD);
    }

}
