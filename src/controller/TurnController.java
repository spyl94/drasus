package controller;

import model.Unit;
import java.util.Hashtable;

public class TurnController {
	
	private Hashtable<Unit, Boolean> hasAttack;
	private Hashtable<Unit, Boolean> hasMove;
	private Hashtable<Unit, Boolean> hasMoveAfterAttack;

	public TurnController(Hashtable<String, Unit> unitsA) {

		hasAttack = new Hashtable<Unit, Boolean>();
		hasMove = new Hashtable<Unit, Boolean>();
		hasMoveAfterAttack = new Hashtable<Unit, Boolean>();
		
		for (Unit u : unitsA.values())
		{
			hasAttack.put(u, false);
			hasMove.put(u, false);
			hasMoveAfterAttack.put(u,false);
		}
	}
	
	public void setHasAttack(Unit u)
	{
		hasAttack.put(u, true);
	}
	
	public void setHasMove(Unit u)
	{
		hasMove.put(u, true);
	}
	
	public void setHasMoveAfterAttack(Unit u)
	{
		hasMoveAfterAttack.put(u, true);
	}
	
	public boolean hasAttack(Unit u)
	{
		return hasAttack.get(u);
	}
	
	public boolean hasMove(Unit u)
	{
		return hasMove.get(u);
	}
	
	public boolean hasMoveAfterAttack(Unit u)
	{
		return hasMoveAfterAttack.get(u);
	}

}
