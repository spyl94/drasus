package model;

/**
 * @author Aurel
 * 
 */
public class DeadUnitException extends Exception {

    private String name;
    private int dmg;

    /**
     * @param str
     *            the name of the dead unit
     * @param dmg
     *            the number of damage that killed
     */
    public DeadUnitException(String str, int dmg) {
	this.name = str;
	this.dmg = dmg;
    }

    /**
     * Returns the name of the dead unit.
     * 
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * Returns the number of damage that killed the unit.
     * 
     * @return the damages
     */
    public int getDmg() {
	return dmg;
    }

}
