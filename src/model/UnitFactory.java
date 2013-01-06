package model;

/**
 * @author Aurel
 *
 */
public abstract class UnitFactory {
	
	/**
	 * @param str the name of the unit
	 * @return the new unit
	 */
	public abstract Unit getUnit(String str);

}
