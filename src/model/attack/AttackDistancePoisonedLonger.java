package model.attack;

import model.exception.DeadUnitException;
import model.units.Unit;

public class AttackDistancePoisonedLonger extends AttackDistance {

    public AttackDistancePoisonedLonger() {
	super(0);
    }

    public AttackDistancePoisonedLonger(int i) {
	super(i);
    }
    
    @Override
    public String attack(Unit att, Unit def) throws DeadUnitException {
	int hit = att.getHit();
	int dmg = att.getDmg();
	int crit = att.getCrit();
	int poison = 4;

	if (!canHit(hit))
	    return def.getName() + " a esquivé l'attaque !";

	dmg += dmg * ((double) crit / 100);
	dmg -= dmg * ((double) def.getDef() / 100);
	
	def.receiveDmg(dmg);
	def.setTurnsPoisoned(def.getTurnsPoisoned() + poison);

	return "L'attaque à distance de votre " + att.getName() + " a infligé "
		+ dmg + " à " + def.getName() + "ainsi que le poison pendant " + poison + " tours.";
    }

}
