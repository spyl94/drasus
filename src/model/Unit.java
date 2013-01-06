package model;

import view.Tile;
/**
 * @author Aurel
 * 
 */
public abstract class Unit {
	
	protected IAttack attack;
	protected int hp;
	protected int dmg;
	protected int hit;
	protected int move;
	protected int def;
	protected int crit;
	protected int mat;
	protected Weapon wep;
	protected String name; 
	protected Tile tile;

	/**
	 * @param attack behavior of attack
	 * @param hp life points
	 * @param dmg damage
	 * @param hit probability of hitting (%)
	 * @param move number of moves
	 * @param def damage reduction (%)
	 * @param crit probability of critical attack (%)
	 * @param mat number of moves after attack
	 * @param wep type of weapon
	 * @param name name of unit
	 */
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

	/**
	 * Attack an other unit.
	 * 
	 * @param u the defender
	 * @return result of the fight
	 * @throws DeadUnitException if the defender is dead
	 */
	public String attack(Unit u) throws DeadUnitException {
		return this.attack.attack(this, u);
	}

	/**
	 * Returns if a unit can attack from a certain range.
	 * 
	 * @param i the range
	 * @return true if the unit can attack or false otherwise
	 */
	public boolean canAttackFromRange(int i) {
		return this.attack.canAttackFromRange(i);
	}

	/**
	 * Returns the probability of critical attack.
	 * 
	 * @return the probability of critical attack
	 */
	public int getCrit() {
		return crit;
	}

	/**
	 * Returns the damage reduction.
	 * 
	 * @return the damage reduction
	 */
	public int getDef() {
		return def;
	}

	/**
	 * Returns the number of damages.
	 * 
	 * @return the damages
	 */
	public int getDmg() {
		return dmg;
	}

	/**
	 * Returns the probability of hit another unit.
	 * 
	 * @return the probability of hit
	 */
	public int getHit() {
		return hit;
	}

	/**
	 * Returns the number of life points.
	 * 
	 * @return the number of hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Returns the number of movements.
	 * 
	 * @return the number of movements
	 */
	public int getMove() {
		return move;
	}

	/**
	 * Returns the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Tile getTile() {
		return tile;
	}

	/**
	 * Returns the kind of weapon.
	 * 
	 * @return the weapon
	 */
	public Weapon getWep() {
		return wep;
	}

	/**
	 * Reduce the number of life points.
	 * 
	 * @param dmg the damages
	 * @throws DeadUnitException if the unit is dead
	 */
	public void receiveDmg(int dmg) throws DeadUnitException {
		this.hp -= dmg;
		if (this.hp <= 0)
			throw new DeadUnitException(this.name, dmg);
	}
	
	/**
	 * Set a new behavior of attack.
	 * 
	 * @param a behavior of attack
	 */
	public void setIAttack(IAttack a) {
		this.attack = a;
	}
	
	/**
	 * Set a new Tile on which is the unit.
	 * 
	 * @param tile the tile on which is the unit
	 */
	public void setTile(Tile tile){
		this.tile = tile;
	}
	
}
