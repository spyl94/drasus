/**
 * 
 */
package model;

import view.Tile;
/**
 * @author Aurel
 * 
 */
public abstract class Unit {
	protected IAttack attack; // Behavior of Attack
	protected int hp; // Life points
	protected int dmg; // Damage
	protected int hit; // Probability of hitting (%)
	protected int move; // Number of moves
	protected int def; // Damage reduction (%)
	protected int crit; // Probability of critical attack (%)
	protected int mat; // Number of moves after attack
	protected Weapon wep; // Type of Weapon
	protected String name; // Name
	
	protected Tile tile;
	public Tile getTile() {
		return tile;
	}
	public void setTile(Tile tile){
		this.tile = tile;
	}
	

	public Unit(IAttack attack, int hp, int dmg, int hit, int move, int def,
			int crit, int mat, Weapon wep, String name) {
		this.attack = attack;
		this.hp = hp;
		this.dmg = dmg;
		this.hit = hit;
		this.move = move;
		this.def = def;
		this.crit = crit;
		this.mat = mat;
		this.wep = wep;
		this.name = name;
	}

	public void setIAttack(IAttack a) {
		this.attack = a;
	}

	public String attack(Unit u) throws DeadUnitException {
		return this.attack.attack(this, u);
	}

	public boolean canAttackFromRange(int i) {
		return this.attack.canAttackFromRange(i);
	}

	/**
	 * @param dmg
	 */
	public void receiveDmg(int dmg) throws DeadUnitException {
		this.hp -= dmg;
		if (this.hp <= 0)
			throw new DeadUnitException(this.name, dmg);
	}

	public int getHp() {
		return hp;
	}

	public int getDmg() {
		return dmg;
	}

	public int getHit() {
		return hit;
	}

	public int getMove() {
		return move;
	}

	public int getDef() {
		return def;
	}

	public int getCrit() {
		return crit;
	}

	public Weapon getWep() {
		return wep;
	}

	public String getName() {
		return name;
	}
}
