package model.attack;

import model.exception.DeadUnitException;
import model.units.Unit;

public class AttackCaCIgnoreArmor extends AttackCaC {
   
    @Override
    public String attack(Unit att, Unit def, boolean tank) throws DeadUnitException {
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
	// Ignore Armor

	def.receiveDmg(dmg);

	return "L'attaque de votre " + att.getName() + " a infligé " + dmg
		+ " à " + def.getName() + " en ignorant l'armure.";
    }
}
