package model;

/**
 * @author Aurel
 *
 */
public interface IAttack {
	
	/**
	 * @param att
	 * @param deff
	 * @return
	 * @throws DeadUnitException
	 */
	String attack(Unit att, Unit deff) throws DeadUnitException;

	/**
	 * Returns if the behavior of attack can attack from a certain range
	 * 
	 * @param i the range
	 * @return true if the behavior of attack can attack or false otherwise
	 */
	boolean canAttackFromRange(int i);
}
