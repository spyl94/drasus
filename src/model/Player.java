/**
 * 
 */
package model;

import java.util.Hashtable;
import java.util.Iterator;

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

	public void addUnit(String name) {
		units.put(name, factory.getUnit(name));
	}

	public void delUnit(String name) {
		units.remove(name);
	}

	public Unit getUnit(String name) {
		return units.get(name);
	}
	
	public Unit getUnit(int x, int y)
	{
		Iterator<Unit> it = units.values().iterator();
		while (it.hasNext()) {
			if (it.next().getX() == x && it.next().getY() == y)
				return it.next();
		}
		return null;
	}
	
	public Hashtable<String, Unit> getUnits() {
		return units;
	}

	public String attackWith(Unit att, Unit def) throws DeadUnitException {
		return att.attack(def);
	}

}
