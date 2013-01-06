package model;

/**
 * @author Aurel
 * 
 */
public class Cavalier extends Unit {

    public Cavalier() {
	super(new AttackDistance(1), 120, 30, 70, 8, 35, 35, 2, Weapon.LANCE,
		"Cavalier");

    }

}
