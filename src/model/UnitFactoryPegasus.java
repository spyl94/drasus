package model;

import model.units.ArcherMontePegasus;
import model.units.ArcherPegasus;
import model.units.BerserkerPegasus;
import model.units.BretteurPegasus;
import model.units.CavalierPegasus;
import model.units.ChevalierPegasus;
import model.units.EclaireurPegasus;
import model.units.FantassinPegasus;
import model.units.LancierPegasus;
import model.units.Pegasus;
import model.units.RodeurPegasus;
import model.units.TankPegasus;
import model.units.Unit;

/**
 * @author Aurel
 * 
 */
public class UnitFactoryPegasus extends UnitFactory {

    private String[] names;

    public UnitFactoryPegasus() {
	this.names = new String[] { "Tank", "Fantassin", "Chevalier",
		"Berserker", "Bretteur", "Eclaireur", "Lancier", "Archer",
		"Rodeur", "ArcherMonte", "Cavalier" };
    }

    @Override
    public String[] getNamesOfUnits() {
	return this.names;
    }

    @Override
    public Unit getUnit(String str) {

	if (str == "Pegasus")
	    return new Pegasus();
	if (str == "Eclaireur")
	    return new EclaireurPegasus();
	if (str == "Berserker")
	    return new BerserkerPegasus();
	if (str == "Fantassin")
	    return new FantassinPegasus();
	if (str == "Archer")
	    return new ArcherPegasus();
	if (str == "Lancier")
	    return new LancierPegasus();
	if (str == "Rodeur")
	    return new RodeurPegasus();
	if (str == "Tank")
	    return new TankPegasus();
	if (str == "ArcherMonte")
	    return new ArcherMontePegasus();
	if (str == "Bretteur")
	    return new BretteurPegasus();
	if (str == "Cavalier")
	    return new CavalierPegasus();
	if (str == "Chevalier")
	    return new ChevalierPegasus();

	return null;
    }

}
