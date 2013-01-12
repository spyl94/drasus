package model.attack;

import view.Tile.FIELD;
import model.exception.DeadUnitException;
import model.units.Unit;

public class AttackDistanceDoubledInForest extends AttackDistance {

    public AttackDistanceDoubledInForest() {
   	super(0);
      }
    
    public AttackDistanceDoubledInForest(int i) {
	super(i);
    }
    
    @Override
    public String attack(Unit att, Unit def, boolean tank) throws DeadUnitException {
	int hit = att.getHit();
	int dmg = att.getDmg();
	int crit = att.getCrit();

	if (!canHit(hit))
	    return def.getName() + " a esquivé l'attaque !";

	dmg += dmg * ((double) crit / 100);
	dmg -= dmg * ((double) def.getDef() / 100);
	
	if (tank)
	    dmg = dmg - (dmg/5);

	def.receiveDmg(dmg);
	
	if(att.getTile().getField() == FIELD.FOREST) {
	    def.receiveDmg(dmg);
	    return "La double attaque à distance du " + att.getName() + " a infligé "
		+ dmg*2 + " à " + def.getName();
	}

	return "L'attaque à distance du " + att.getName() + " a infligé "
		+ dmg + " à " + def.getName();
    }
}
