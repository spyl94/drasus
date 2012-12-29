package model;

public class UnitFactoryPegasus extends UnitFactory {

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

}
