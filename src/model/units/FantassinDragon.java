package model.units;

import model.attack.AttackCaC;

/**
 * @author Aurel
 * 
 */
public class FantassinDragon extends Unit {

    public FantassinDragon() {
	super(new AttackCaC(), 100, 20, 80, 5, 35, 20, 0, Weapon.SWORD,
		"Fantassin");

    }

    @Override
    public void activatePower() {
	pow = true;
	
    }
    
    @Override
    public void addRegeneration() {
	this.hp += 10;
	if (this.hp > this.maxHp)
	    this.hp = this.maxHp;
    }

}
