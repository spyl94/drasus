package model;

/**
 * @author Aurel
 *
 */
public class AttackCaC implements IAttack {

	@Override
	public String attack(Unit att, Unit def) throws DeadUnitException {
		int hit = att.getHit();
		int dmg = att.getDmg();
		int crit = att.getCrit();

		if (trinityAdvantage(def.getWep(), att.getWep()))
			hit = hit * 1 / 3;
		if (trinityAdvantage(att.getWep(), def.getWep()))
			crit += 5;

		if (!canHit(hit))
			return def.getName() + " a esquivé l'attaque !";

		System.out.println("dmg avant crit: " + dmg);
		dmg += dmg * ((double) crit / 100);
		System.out.println("dmg après crit: " + dmg);
		dmg -= dmg * ((double) def.getDef() / 100);
		System.out.println("dmg après def: " + dmg);

		def.receiveDmg(dmg);

		return "L'attaque de votre " + att.getName() + " a infligé " + dmg
				+ " à " + def.getName();
	}

	@Override
	public boolean canAttackFromRange(int i) {
		return false;
	}

	/**
	 * Determine randomly if the unit has touched the target.
	 * 
	 * @param i the probability of hit
	 * @return true if the attack succeed or false otherwise
	 */
	protected boolean canHit(int i) {
		return (int) (Math.random() * (101)) < i;
	}

	/**
	 *  Determine if the weapon has an advantage versus the other weapon.
	 *  
	 * @param a weapon of first unit
	 * @param b weapon of second unit
	 * @return true if advantage or false otherwise
	 */
	protected boolean trinityAdvantage(Weapon a, Weapon b) {
		return (a == Weapon.SWORD && b == Weapon.LANCE)
				|| (a == Weapon.LANCE && b == Weapon.AXE)
				|| (a == Weapon.AXE && b == Weapon.SWORD);
	}

}
