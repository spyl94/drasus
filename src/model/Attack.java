package model;

/**
 * @author Aurel
 *
 */
public abstract class Attack implements IAttack {

    public abstract String attack(Unit att, Unit deff) throws DeadUnitException;
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
    
    /**
     * Determine if the weapon has an advantage versus the other weapon.
     * 
     * @param a
     *            weapon of first unit
     * @param b
     *            weapon of second unit
     * @return true if advantage or false otherwise
     */
    protected boolean trinityAdvantage(Weapon a, Weapon b) {
	return (a == Weapon.SWORD && b == Weapon.LANCE)
		|| (a == Weapon.LANCE && b == Weapon.AXE)
		|| (a == Weapon.AXE && b == Weapon.SWORD);
    }
    
    public int getRange() {
	return 0;
    }
}
