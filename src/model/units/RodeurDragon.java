package model.units;

import model.attack.AttackCaCIgnoreArmor;
import model.attack.AttackDistance;
import model.attack.AttackDistanceDoubledInForest;

/**
 * @author Aurel
 * 
 */
public class RodeurDragon extends Unit {

    public RodeurDragon() {
	super(new AttackDistance(3), 80, 30, 80, 7, 15, 35, 0, Weapon.BOW,
		"Rodeur");

    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackDistanceDoubledInForest(3));
	
    }
    
    @Override
    public void addRegenerationForest() {
	this.hp += 10;
	if (this.hp > this.maxHp)
	    this.hp = this.maxHp;
    }

}
