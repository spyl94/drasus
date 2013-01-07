package model;

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
    public Unit getUnit(String str) {

	if (str == "Eclaireur")
	    return new Eclaireur();
	if (str == "Berserker")
	    return new Berserker();
	if (str == "Fantassin")
	    return new Fantassin();
	if (str == "Archer")
	    return new Archer();
	if (str == "Lancier")
	    return new Lancier();
	if (str == "Rodeur")
	    return new Rodeur();
	if (str == "Tank")
	    return new Tank();
	if (str == "ArcherMonte")
	    return new ArcherMonte();
	if (str == "Bretteur")
	    return new Bretteur();
	if (str == "Cavalier")
	    return new Cavalier();
	if (str == "Chevalier")
	    return new Chevalier();

	return null;
    }

    @Override
    public String[] getNamesOfUnits() {
	return this.names;
    }

}
