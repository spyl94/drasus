package controller;

import model.units.Unit;

import java.util.Hashtable;

public class TurnController {

    public static int numberTurn = 0;

    private Hashtable<Unit, Boolean> hasAttack;
    private Hashtable<Unit, Boolean> hasMove;
    private Hashtable<Unit, Boolean> hasMoveAfterAttack;
    private Hashtable<Unit, Integer> isCrippled;
    private Hashtable<Unit, Integer> isPoisoned;

    public TurnController(Hashtable<String, Unit> unitsA) {

	numberTurn++;

	hasAttack = new Hashtable<Unit, Boolean>();
	hasMove = new Hashtable<Unit, Boolean>();
	hasMoveAfterAttack = new Hashtable<Unit, Boolean>();
	isCrippled = new Hashtable<Unit, Integer>();
	isPoisoned = new Hashtable<Unit, Integer>();

	for (Unit u : unitsA.values()) {
	    hasAttack.put(u, false);
	    hasMove.put(u, false);
	    hasMoveAfterAttack.put(u, false);
	    isCrippled.put(u, 0);
	    isPoisoned.put(u, 0);
	}
    }

    public TurnController(Hashtable<String, Unit> unitsA, TurnController t) {
	this(unitsA);
	for (Unit u : unitsA.values()) {
	    Object o = getTurnsCrippled(u);
	    int i = 0;
	    if (o != null) {
		i = (int) o;
		if (i > 1)
		    isCrippled.put(u, i - 1);
	    }
	    o = getTurnsPoisoned(u);
	    if (o != null) {
		i = (int) o;
		if (i > 1)
		    isPoisoned.put(u, i - 1);
	    }
	}
    }

    public void setIsCrippled(Unit u, int i) {
	isCrippled.put(u, i);
    }

    public void setIsPoisoned(Unit u, int i) {
	isPoisoned.put(u, i);
    }

    public boolean isCrippled(Unit u) {
	return isCrippled.get(u) > 0;
    }

    public boolean isPoisoned(Unit u) {
	return isPoisoned.get(u) > 0;
    }

    public int getTurnsCrippled(Unit u) {
	return isCrippled.get(u);
    }

    public int getTurnsPoisoned(Unit u) {
	return isPoisoned.get(u);
    }

    public void setHasAttack(Unit u) {
	hasAttack.put(u, true);
    }

    public void setHasMove(Unit u) {
	hasMove.put(u, true);
    }

    public void setHasMoveAfterAttack(Unit u) {
	hasMoveAfterAttack.put(u, true);
    }

    public boolean hasAttack(Unit u) {
	return hasAttack.get(u);
    }

    public boolean hasMove(Unit u) {
	return hasMove.get(u);
    }

    public boolean hasMoveAfterAttack(Unit u) {
	return hasMoveAfterAttack.get(u);
    }

}
