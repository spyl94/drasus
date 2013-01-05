package controller;
import view.*;

import java.util.Hashtable;

import model.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import java.util.Hashtable;
import java.util.Iterator;

public class MainController {
	private static MainController controller;
	private Player a;
	private Player b;

	/**
	 * @param args
	 */
	private MainController() {
		a = new Player();
		b = new Player();
	}

	public static MainController getInstance() {
		if (controller == null)
			controller = new MainController();
		return controller;
	}

	public Player getPlayerA() {
		return a;
	}

	public Player getPlayerB() {
		return b;
	}

	public boolean isFreeTileset(Tile tile) {
		Hashtable<String, Unit> units = a.getUnits();
		Iterator<Unit> it = units.values().iterator();
		while (it.hasNext()) {
			if (it.next().getTile().x == tile.x && it.next().getTile().y == tile.y)
				return false;
		}
		if (b != null) {
			units = b.getUnits();
			if(units != null) {
				it = units.values().iterator();
				while (it.hasNext()) {
					if (it.next().getTile().x == tile.x && it.next().getTile().y == tile.y)
						return false;
				}
			}
		}
		return true;
	}
	
	public boolean isPlayerAUnit(Tile tile)
	{
		Hashtable<String, Unit> units = a.getUnits();
		Iterator<Unit> it = units.values().iterator();
		while (it.hasNext()) {
			if (it.next().getTile().x == tile.x && it.next().getTile().y == tile.y)
				return true;
		}
		return false;
	}
	
	public boolean isPlayerBUnit(Tile tile)
	{
		Hashtable<String, Unit> units = b.getUnits();
		Iterator<Unit> it = units.values().iterator();
		while (it.hasNext()) {
			if (it.next().getTile().x == tile.x && it.next().getTile().y == tile.y)
				return true;
		}
		return false;
	}

	public void addUnit(String name, Tile tile) {
		a.addUnit(name);
		if (a.getUnit(name) != null)
			a.getUnit(name).setTile(tile);
	}

	public void init() {

		try {
			AppGameContainer app = new AppGameContainer(new ViewController());
			// app.setShowFPS(false);
			app.setDisplayMode(1280, 704, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		/*

		this.a.addUnit("Eclaireur");
		this.a.getUnit("Eclaireur");
		this.a.addUnit("Fantassin");
		this.a.addUnit("Rodeur");

		// b est géré par le réseau on ne le créé jamais il est récupéré !
		this.b.addUnit("Eclaireur");
		this.b.addUnit("Tank");
		this.b.addUnit("Bretteur");

		// Pour changer la porté d'un rodeur à 5: exemple de pouvoir
		a.getUnit("Rodeur").setIAttack(new AttackDistance(5));
		// Pour donner 15% de double attack
		a.getUnit("Fantassin").setIAttack(new AttackCaCBerserker());

		if (a.getUnit("Rodeur").canAttackFromRange(3))
			System.out.println(attack("Rodeur", "Tank"));

		System.out.println(attack("Eclaireur", "Eclaireur"));
		System.out.println(attack("Fantassin", "Tank"));
		System.out.println(attack("Fantassin", "Tank"));
		System.out.println(attack("Fantassin", "Tank"));
		
		*/

	}

	public static void main(String[] args) {
		MainController.getInstance().init();
	}

	private String attack(String att, String def) {
		try {
			return a.attackWith(a.getUnit(att), b.getUnit(def));
		} catch (DeadUnitException e) {
			b.delUnit(e.getName());
			return e.getName() + " est mort !";
		} catch (NullPointerException e) {
			return "L'unité " + def + " n'éxiste pas !";
		}
	}
	
	public String attack(Tile att, Tile def)
	{
		try
		{
			Unit at = a.getUnit(att.x, att.y);
			Unit de = b.getUnit(def.x, def.y);
			
			//TODO: vérif coordonnées
			//if(at.canAttackFromRange())
			
			return attack(at.getName(), de.getName());
		}
		catch(NullPointerException e)
		{
			return "unité introuvable";
		}
	}

}
