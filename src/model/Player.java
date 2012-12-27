/**
 * 
 */
package model;

import java.util.Hashtable;

/**
 * @author Aurel
 *
 */
public class Player {
	UnitFactory factory;
	
	private Hashtable<String, Unit> units;

	/**
	 * 
	 */
	public Player() {
		units = new Hashtable<String, Unit>();
		factory = new UnitFactoryPegasus();
	}
	
	public void addUnit(String name)
	{
		units.put(name,factory.getUnit(name));
	}

}
