package model.attack;

import model.exception.DeadUnitException;
import model.units.Unit;

/**
 * @author Aurel
 * 
 */
public interface IAttack {

	/**
	 * Attack between two units.
	 * 
	 * @param att
	 *            the attacking unit
	 * @param deff
	 *            the defending unit
	 * @param tank
	 *            if the tank is in range of defending unit
	 * @return the string containing the result of the fight
	 * @throws DeadUnitException
	 *             if the defending unit is dead
	 */
	String attack(Unit att, Unit deff, boolean tank) throws DeadUnitException;

	/**
	 * Returns if the behavior of attack can attack from a certain range.
	 * 
	 * @param i
	 *            the range
	 * @return true if the behavior of attack can attack or false otherwise
	 */
	boolean canAttackFromRange(int i);

	/**
	 * Returns the range of the behavior of attack.
	 * 
	 * @return the range
	 */
	int getRange();
}
