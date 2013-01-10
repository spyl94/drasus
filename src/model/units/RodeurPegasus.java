package model.units;

import model.attack.AttackDistance;
import model.attack.AttackDistanceDoubledInForest;

/**
 * @author Aurel
 * 
 */
public class RodeurPegasus extends Unit {

    public RodeurPegasus() {
	super(new AttackDistance(3), 80, 30, 80, 7, 15, 35, 0, Weapon.BOW,
		"Rodeur");

    }

    @Override
    public void activatePower() {
	pow = true;
	setIAttack(new AttackDistanceDoubledInForest(3));
	
    }

}
