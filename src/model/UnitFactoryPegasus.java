package model;

public class UnitFactoryPegasus extends UnitFactory {

	@Override
	public Unit getUnit(String str) {
		
			if(str == "Eclaireur")
				return new Eclaireur();
			
		return null;
	}

}
