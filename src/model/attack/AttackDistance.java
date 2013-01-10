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
    public String attack(Unit att, Unit def) throws DeadUnitException {
	int hit = att.getHit();
	int dmg = att.getDmg();
	int crit = att.getCrit();
	
	// crit 50%
	if(att.isPowActivate())
	    crit = 50;

	if (!canHit(hit))
	    return def.getName() + " a esquiv� l'attaque !";

	dmg += dmg * ((double) crit / 100);
	dmg -= dmg * ((double) def.getDef() / 100);

	def.receiveDmg(dmg);

	return "L'attaque � distance de votre " + att.getName() + " a inflig� "
		+ dmg + " � " + def.getName();
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
