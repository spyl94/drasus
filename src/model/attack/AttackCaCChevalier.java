package model.attack;

import model.exception.DeadUnitException;
import model.units.Unit;

public class AttackCaCChevalier extends AttackCaC {

    @Override
    protected boolean trinityAdvantage(Unit.Weapon a, Unit.Weapon b) {
	return (int) (Math.random() * (2)) < 1;
    }

    @Override
    public String attack(Unit att, Unit def, boolean tank)
	    throws DeadUnitException {
	int hit = att.getHit();
	int dmg = att.getDmg();
	int crit = att.getCrit();

	// 1 chance sur 2 de la gagner
	if (trinityAdvantage(def.getWep(), att.getWep()))
	    hit = hit * 1 / 3;
	// ne perd jamais la trinité

	if (!canHit(hit))
	    return def.getName() + " a esquivé l'attaque !";

	dmg += dmg * ((double) crit / 100);
	dmg -= dmg * ((double) def.getDef() / 100);

	if (tank)
	    dmg = dmg - (dmg / 5);

	def.receiveDmg(dmg);

	return "L'attaque du " + att.getName() + " a infligé " + dmg + " à "
		+ def.getName();

    }
}
