package test;

import static org.junit.Assert.*;

import model.Player;
import model.UnitFactory;
import model.UnitFactoryPegasus;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.MainController;

public class PlayerTest {

    public static Player p;

    @BeforeClass
    public static void init() {
	p = new Player();
    }

    @Test
    public void testDefaultConstructor() {
	assertNotNull(p.getBoss());
	assertNotNull(p.getNamesOfUnits());
    }

    @Test
    public void testContructor() {
	for (String boss : MainController.BOSS) {
	    p = new Player(boss);
	    assertNotNull(p.getBoss());
	    assertNotNull(p.getNamesOfUnits());
	}
    }

    @Test
    public void testAddUnit() {
	UnitFactory u;
	u = new UnitFactoryPegasus();
	for (String str : u.getNamesOfUnits()) {
	    p.addUnit(u.getUnit(str).getName());
	    assertNotNull(p.getUnit(u.getUnit(str).getName()));
	}

    }

    @Test
    public void testDelUnit() {
	UnitFactory u;
	u = new UnitFactoryPegasus();
	for (String str : u.getNamesOfUnits()) {
	    u.getUnit(str).getName();
	    p.delUnit(u.getUnit(str).getName());
	    assertNull(p.getUnit(u.getUnit(str).getName()));
	}
    }

}
