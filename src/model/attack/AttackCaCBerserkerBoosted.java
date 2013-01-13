package model.attack;

import model.exception.DeadUnitException;
import model.units.Unit;

/**
 * @author Aurel
 * 
 */
public class AttackCaCBerserkerBoosted extends AttackCaC {

    @Override
    public String attack(Unit att, Unit def, boolean tank)
	    throws DeadUnitException {
	int hit = att.getHit();
	int dmg = att.getDmg();
	int crit = att.getCrit();

	if (trinityAdvantage(def.getWep(), att.getWep()))
	    hit = hit * 1 / 3;
	if (trinityAdvantage(att.getWep(), def.getWep()))
	    crit += 5;

	if (!canHit(hit))
	    return def.getName() + " a esquivé l'attaque !";

	dmg += dmg * ((double) crit / 100);
	dmg -= dmg * ((double) def.getDef() / 100);

	if (tank)
	    dmg = dmg - (dmg / 5);

	def.receiveDmg(dmg);
	if (!((int) (Math.random() * (101)) < 35))
	    return "L'attaque du " + att.getName() + " a infligé " + dmg
		    + " à " + def.getName();
	def.receiveDmg(dmg);
	return "La double attaque du " + att.getName() + " a infligé " + dmg
		* 2 + " à " + def.getName();
    }

}
