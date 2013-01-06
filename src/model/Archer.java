package model;

/**
 * @author Aurel
 * 
 */
public class Archer extends Unit {

    public Archer() {
	super(new AttackDistance(3), 50, 20, 70, 5, 10, 25, 0, Weapon.BOW,
		"Archer");

    }

}
