package model.units;

import model.attack.AttackDistance;
import model.attack.AttackDistanceDoubledInForest;

/**
 * @author Aurel
 * 
 */
public class RodeurPegasus extends Unit {

    public RodeurPegasus() {
	super(new AttackDistance(3), 210, 45, 85, 5, 20, 25, 0, Weapon.BOW,
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
