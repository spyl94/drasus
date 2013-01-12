package controller;

import model.units.Unit;

import java.util.Hashtable;

public class TurnController {

    public static int numberTurn = 0;

    private Hashtable<Unit, Boolean> hasAttack;
    private Hashtable<Unit, Boolean> hasMove;
    private Hashtable<Unit, Boolean> hasMoveAfterAttack;
    private Hashtable<Unit, Boolean> isCrippled;
    private Hashtable<Unit, Boolean> isPoisoned;

    /**
     * It should be called exactly once each turn.
     */
    public TurnController(Hashtable<String, Unit> unitsA) {

	numberTurn++;

	hasAttack = new Hashtable<Unit, Boolean>();
	hasMove = new Hashtable<Unit, Boolean>();
	hasMoveAfterAttack = new Hashtable<Unit, Boolean>();
	isCrippled = new Hashtable<Unit, Boolean>();
	isPoisoned = new Hashtable<Unit, Boolean>();

	for (Unit u : unitsA.values()) {
	    hasAttack.put(u, false);
	    hasMove.put(u, false);
	    hasMoveAfterAttack.put(u, false);
	    int i = u.getTurnsCripple();
	    if (i > 1) {
		isCrippled.put(u, true);
		u.setTurnsCripple(i - 1);
	    } else {
		isCrippled.put(u, false);
		u.setTurnsCripple(0);
	    }

	    i = u.getTurnsPoisoned();
	    if (i > 1) {
		isPoisoned.put(u, true);
		u.setTurnsPoisoned(i - 1);
	    } else {
		isPoisoned.put(u, false);
		u.setTurnsPoisoned(0);
	    }
	}
    }

    /**
     * Returns if a unit is crippled.
     * 
     * @param u
     *            the unit
     * @return true if the unit is crippled false otherwise
     */
    public boolean isCrippled(Unit u) {
	try {
	    return isCrippled.get(u);
	} catch (NullPointerException e) {
	    System.out.println("Erreur isCrippled");
	    return false;
	}

    }

    /**
     * Returns if a unit is poisoned.
     * 
     * @param u
     *            the unit
     * @return true if the unit is poisoned false otherwise
     */
    public boolean isPoisoned(Unit u) {
	try {
	    return isPoisoned.get(u);
	} catch (NullPointerException e) {
	    System.out.println("Erreur isPoisoned");
	    return false;
	}
    }

    /**
     * Set the unit already attacked.
     * 
     * @param u
     *            the unit
     */
    public void setHasAttack(Unit u) {
	hasAttack.put(u, true);
    }

    /**
     * Set the unit already moved.
     * 
     * @param u
     *            the unit
     */
    public void setHasMove(Unit u) {
	hasMove.put(u, true);
    }

    /**
     * Set the unit already moved after attacking.
     * 
     * @param u
     *            the unit
     */
    public void setHasMoveAfterAttack(Unit u) {
	hasMoveAfterAttack.put(u, true);
    }

    /**
     * Returns if a unit already attacked.
     * 
     * @param u
     *            the unit
     * @return true if the unit already attacked false otherwise
     */
    public boolean hasAttack(Unit u) {
	return hasAttack.get(u);
    }

    /**
     * Returns if a unit already moved.
     * 
     * @param u
     *            the unit
     * @return true if the unit already moved false otherwise
     */
    public boolean hasMove(Unit u) {
	return hasMove.get(u);
    }

    /**
     * Returns if a unit already moved after attacking.
     * 
     * @param u
     *            the unit
     * @return true if the unit already moved after attacking false otherwise
     */
    public boolean hasMoveAfterAttack(Unit u) {
	return hasMoveAfterAttack.get(u);
    }

}
