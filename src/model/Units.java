/**
 * 
 */
package model;

/**
 * @author Aurel
 *
 */
public interface Unit {
	public int hp; 	// Life points
	public int dmg;	// Damage
	public int hit;	// Probability of hitting (%)
	public int move; // Number of moves
	public int def;  // Damage reduction (%)
	public int crit; // Probability of critical attack (%)
	
	public String attack(Unit u)
}
