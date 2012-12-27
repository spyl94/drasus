package model;

public class AttackDistance implements IAttack {

	private int range;
	public AttackDistance(int i)
	{
		range = i;
	}
	@Override
	public String attack(Unit att, Unit deff) throws DeadUnitException {
		int dmg = att.getDmg();
		
		deff.receiveDmg(att.getDmg());
		
		return "L'attaque de " + att.getName() + " a infligé " + dmg + " à " + deff.getName();
	}
	
	@Override
	public boolean canAttackFromRange(int i) {
		return i <= range;
	}
}
