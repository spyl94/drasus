package model.attack;

import model.exception.DeadUnitException;
import model.units.Unit;

public class AttackDistancePoisoned extends AttackDistance {

    public AttackDistancePoisoned() {
	super(0);
    }

    public AttackDistancePoisoned(int i) {
	super(i);
    }
    
    @Override
    public String attack(Unit att, Unit def, boolean tank) throws DeadUnitException {
	int hit = att.getHit();
	int dmg = att.getDmg();
	int crit = att.getCrit();
	int poison = 2;

	if (!canHit(hit))
	    return def.getName() + " a esquivé l'attaque !";

	dmg += dmg * ((double) crit / 100);
	dmg -= dmg * ((double) def.getDef() / 100);
	
	if (tank)
	    dmg = dmg - (dmg/5);
	
	def.receiveDmg(dmg);
	def.setTurnsPoisoned(def.getTurnsPoisoned() + poison);

	return "L'attaque à distance de votre " + att.getName() + " a infligé "
		+ dmg + " à " + def.getName() + "ainsi que le poison pendant " + poison + " tours.";
    }

}
