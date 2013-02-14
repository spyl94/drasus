package model.attack;

import model.exception.DeadUnitException;
import model.units.Unit;

public class AttackDistanceArcher extends AttackDistance {

	public AttackDistanceArcher() {
		super(0);
	}

	public AttackDistanceArcher(int i) {
		super(i);
	}

	@Override
	public String attack(Unit att, Unit def, boolean tank)
			throws DeadUnitException {
		int hit = att.getHit();
		int dmg = att.getDmg();
		int crit = att.getCrit();

		// crit 50%
		if (att.isPowActivate() && !att.hasAttackedPrevious()) {
			crit = 50;
		}

		if (!canHit(hit))
			return def.getName() + " a esquivé l'attaque !";

		dmg += dmg * ((double) crit / 100);
		dmg -= dmg * ((double) def.getDef() / 100);

		if (tank)
			dmg = dmg - (dmg / 5);

		def.receiveDmg(dmg);

		return "L'attaque à distance de l'" + att.getName() + " a infligé "
				+ dmg + " à " + def.getName();
	}

}
