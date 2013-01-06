package model;

/**
 * @author Aurel
 * 
 */
public class Lancier extends Unit {

    public Lancier() {
	super(new AttackDistance(2), 60, 25, 75, 5, 25, 30, 0, Weapon.LANCE,
		"Lancier");

    }

}
