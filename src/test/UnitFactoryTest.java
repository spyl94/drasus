package test;

import static org.junit.Assert.assertNotNull;
import model.UnitFactory;
import model.UnitFactoryDragon;
import model.UnitFactoryPegasus;

import org.junit.Test;

public class UnitFactoryTest {

    @Test
    public void testNames() {
	UnitFactory u;
	u = new UnitFactoryPegasus();
	for (String str : u.getNamesOfUnits())
	    assertNotNull(u.getUnit(str));
	u = new UnitFactoryDragon();
	for (String str : u.getNamesOfUnits())
	    assertNotNull(u.getUnit(str));
    }

}
