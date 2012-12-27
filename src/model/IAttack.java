package model;

public interface IAttack {
	String attack(Unit att, Unit deff) throws DeadUnitException ;
	boolean canAttackFromRange(int i);
}
