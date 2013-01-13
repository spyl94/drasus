package model.attack;

import model.exception.DeadUnitException;
import model.units.Unit;

public class AttackCaCBoostedInHill extends AttackCaC {

    @Override
    public String attack(Unit att, Unit def, boolean tank)
	    throws DeadUnitException {
	int hit = 85;
	int dmg = 60;
	int crit = 20;

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

	return "L'attaque du  " + att.getName() + " a infligé " + dmg + " à "
		+ def.getName();
    }

}
