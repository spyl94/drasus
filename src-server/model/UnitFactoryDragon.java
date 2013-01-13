package model;

import model.units.ArcherDragon;
import model.units.ArcherMonteDragon;
import model.units.BerserkerDragon;
import model.units.BretteurDragon;
import model.units.CavalierDragon;
import model.units.ChevalierDragon;
import model.units.Dragon;
import model.units.EclaireurDragon;
import model.units.FantassinDragon;
import model.units.LancierDragon;
import model.units.RodeurDragon;
import model.units.TankDragon;
import model.units.Unit;

/**
 * @author Aurel
 * 
 */
public class UnitFactoryDragon extends UnitFactory {

    private String[] names;

    public UnitFactoryDragon() {
	this.names = new String[] { "Tank", "Fantassin", "Chevalier",
		"Berserker", "Bretteur", "Eclaireur", "Lancier", "Archer",
		"Rodeur", "ArcherMonte", "Cavalier" };
    }

    @Override
    public Unit getUnit(String str) {

	if (str == "Dragon")
	    return new Dragon();
	if (str == "Eclaireur")
	    return new EclaireurDragon();
	if (str == "Berserker")
	    return new BerserkerDragon();
	if (str == "Fantassin")
	    return new FantassinDragon();
	if (str == "Archer")
	    return new ArcherDragon();
	if (str == "Lancier")
	    return new LancierDragon();
	if (str == "Rodeur")
	    return new RodeurDragon();
	if (str == "Tank")
	    return new TankDragon();
	if (str == "ArcherMonte")
	    return new ArcherMonteDragon();
	if (str == "Bretteur")
	    return new BretteurDragon();
	if (str == "Cavalier")
	    return new CavalierDragon();
	if (str == "Chevalier")
	    return new ChevalierDragon();

	return null;
    }

    @Override
    public String[] getNamesOfUnits() {
	return this.names;
    }

}
