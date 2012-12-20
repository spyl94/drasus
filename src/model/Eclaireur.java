/**
 * 
 */
package model;

/**
 * @author Aurel
 *
 */
public class Eclaireur extends CacUnit {

	/**
	 * 
	 */
	public Eclaireur() {
		super(30, 100, 95, 10, 5, 80, Weapon.SWORD, "Eclaireur");

	}
	
	public String attack(Unit u) {
		u.receiveDmg(10);
		return "";
	}

}
