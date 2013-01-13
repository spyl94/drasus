package model.attack;

import model.exception.DeadUnitException;
import model.units.Unit;

/**
 * @author Aurel
 * 
 */
public class AttackDistance extends Attack {

    private int range;

    public AttackDistance() {
	range = 0;
    }

    public AttackDistance(int i) {
	range = i;
    }

    @Override
    public String attack(Unit att, Unit def, boolean tank)
	    throws DeadUnitException {
	int hit = att.getHit();
	int dmg = att.getDmg();
	int crit = att.getCrit();

	if (!canHit(hit))
	    return def.getName() + " a esquivé l'attaque !";

	dmg += dmg * ((double) crit / 100);
	dmg -= dmg * ((double) def.getDef() / 100);
	if (tank)
	    dmg = dmg - (dmg / 5);

	def.receiveDmg(dmg);

	return "L'attaque à distance de " + att.getName() + " a infligé "
		+ dmg + " à " + def.getName();

    }

    @Override
    public boolean canAttackFromRange(int i) {
	return i <= range;
    }

    @Override
    public int getRange() {
	return range;
    }

}
