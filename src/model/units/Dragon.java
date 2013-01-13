package model.units;

import model.attack.AttackCaC;
import model.units.Unit.Weapon;

/**
 * @author Aurel
 * 
 */
public class Dragon extends Unit {

    public Dragon() {
	super(new AttackCaC(), 250, 60, 80, 0, 10, 10, 0, Weapon.HEROIC, "Dragon");

    }

    @Override
    public void activatePower() {
	pow = true;
    }

}
