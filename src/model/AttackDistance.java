package model;

/**
 * @author Aurel
 *
 */
public class AttackDistance implements IAttack {

    private int range;


	public AttackDistance() {
		range = 0;
	}
	
	public AttackDistance(int i) {
		range = i;
	}
	
    /**
     * @param i
     *            
     */



    @Override
    public String attack(Unit att, Unit def) throws DeadUnitException {
	int hit = att.getHit();
	int dmg = att.getDmg();
	int crit = att.getCrit();

	if (!canHit(hit))
	    return def.getName() + " a esquivé l'attaque !";

	System.out.println("dmg avant crit: " + dmg);
	dmg += dmg * ((double) crit / 100);
	System.out.println("dmg après crit: " + dmg);
	dmg -= dmg * ((double) def.getDef() / 100);
	System.out.println("dmg après def: " + dmg);

	def.receiveDmg(dmg);

	return "L'attaque à distance de votre " + att.getName() + " a infligé "
		+ dmg + " à " + def.getName();
    }

    @Override
    public boolean canAttackFromRange(int i) {
	return i <= range;
    }

    /**
     * Determine randomly if the unit has touched the target.
     * 
     * @param i
     *            the probability of hit
     * @return true if the attack succeed or false otherwise
     */
    protected boolean canHit(int i) {
	return (int) (Math.random() * (101)) < i;
    }

}
