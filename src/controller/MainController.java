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
import java.util.Vector;

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
		Unit temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.getTile().x == tile.x && temp.getTile().y == tile.y)
				return false;

		}
		if (b != null) {
			units = b.getUnits();
			if (units != null) {
				it = units.values().iterator();
				while (it.hasNext()) {
					temp = it.next();
					if (temp.getTile().x == tile.x
							&& temp.getTile().y == tile.y)
						return false;
				}
			}
		}
		return true;
	}

	public boolean isPlayerAUnit(Tile tile) {
		Hashtable<String, Unit> units = a.getUnits();
		Iterator<Unit> it = units.values().iterator();
		Unit temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.getTile().x == tile.x && temp.getTile().y == tile.y)
				return true;
		}
		return false;
	}

	public boolean isPlayerBUnit(Tile tile) {
		Hashtable<String, Unit> units = b.getUnits();
		Iterator<Unit> it = units.values().iterator();
		Unit temp;
		while (it.hasNext()) {
			temp = it.next();
			if (temp.getTile().x == tile.x && temp.getTile().y == tile.y)
				return true;
		}
		return false;
	}

	public void addUnit(String name, Tile tile) {
		a.addUnit(name);
		if (a.getUnit(name) != null)
			a.getUnit(name).setTile(tile);
	}

	public String[][] aToTab() {
		String[][] tab;
		int i = 0;
		Hashtable<String, Unit> units = a.getUnits();
		Iterator<Unit> it = units.values().iterator();
		Iterator<String> itKey = units.keySet().iterator();
		tab = new String[units.size()][3];
		Unit temp;
		while (it.hasNext()) {
			temp = it.next();
			tab[i][0] = itKey.next();
			tab[i][1] = String.valueOf(temp.getTile().x);
			tab[i][2] = String.valueOf(temp.getTile().y);
			i++;
		}

		return tab;
	}

	public String[][] bToTab() {
		String[][] tab;
		int i = 0;
		Hashtable<String, Unit> units = b.getUnits();
		Iterator<Unit> it = units.values().iterator();
		Iterator<String> itKey = units.keySet().iterator();
		tab = new String[units.size()][3];
		Unit temp;
		while (it.hasNext()) {
			temp = it.next();
			tab[i][0] = itKey.next();
			tab[i][1] = String.valueOf(temp.getTile().x);
			tab[i][2] = String.valueOf(temp.getTile().y);
			i++;
		}

		return tab;
	}

	public int distance(Tile tile1,Tile tile2){
		int a = tile1.x - tile2.x;
		if(a<0){
			a = a * -1;
		}
		int b = tile1.y - tile2.y;
		if(b<0){
			b = b * -1;
		}
		return a + b;
	}

	public Vector<Tile> canCross(Vector<Tile> tiles,Tile base, int moveNb){
		Tile[] finale = null;
		Vector<Tile> tempo = new Vector<Tile>();
		Vector<Tile> result = new Vector<Tile>();
		boolean temp = false;
		
		for (Tile t : tiles) {
			if(t.x == base.x+1 && t.y == base.y){
				if(t.isBlocked() == false){
					for(Tile p : result){
						if(p == t){
							temp = true;
						}
					}
					if (temp == false){
						result.add(t);
					}
					temp = false;
				}
			}
			
			if(t.x == base.x && t.y+1 == base.y){
				if(t.isBlocked() == false){
					for(Tile p : result){
						if(p == t){
							temp = true;
						}
					}
					if (temp == false){
						result.add(t);
					}
					temp = false;
				}
			}
			
			if(t.x == base.x-1 && t.y == base.y){
				if(t.isBlocked() == false){
					for(Tile p : result){
						if(p == t){
							temp = true;
						}
					}
					if (temp == false){
						result.add(t);
					}
					temp = false;
				}
			}
			
			if(t.x == base.x && t.y-1 == base.y){
				if(t.isBlocked() == false){
					for(Tile p : result){
						if(p == t){
							temp = true;
						}
					}
					if (temp == false){
						result.add(t);
					}
					temp = false;
				}
			}
		}
		finale = new Tile[result.size()];
		int i = 0;
		for(Tile test : result){
			finale[i] = test;
			i++;
		}
		moveNb--;
		if (moveNb == 0 || result.isEmpty()){
			return result;
		}
		//System.out.println(finale.size());
		for(i = 0; i < finale.length; i++){
			tempo = this.canCross(tiles, finale[i],moveNb);
			for(Tile k : tempo){
				for(Tile p : result){
					if(k == p){
						temp = true;
					}
				}
				if(temp == false){
					result.add(k);
				}
				temp = false;
			}
		}
		return result; 
	}
	
	public void move(Tile tile, Tile currentSelected, Vector<Tile> highLight){
		for(Tile t : highLight){
			if (tile == t) {
				if (isFreeTileset(tile) && tile.isBlocked() == false) {

					getPlayerA()
							.getUnit(currentSelected.x, currentSelected.y)
							.setTile(tile);
				} else {
					System.out.println("La case n'est pas libre");
				}
			} else {
				System.out.println("C'est trop loin");
			}
		}
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
		 * 
		 * this.a.addUnit("Eclaireur"); this.a.getUnit("Eclaireur");
		 * this.a.addUnit("Fantassin"); this.a.addUnit("Rodeur");
		 * 
		 * // b est g�r� par le r�seau on ne le cr�� jamais il est r�cup�r� !
		 * this.b.addUnit("Eclaireur"); this.b.addUnit("Tank");
		 * this.b.addUnit("Bretteur");
		 * 
		 * // Pour changer la port� d'un rodeur � 5: exemple de pouvoir
		 * a.getUnit("Rodeur").setIAttack(new AttackDistance(5)); // Pour donner
		 * 15% de double attack a.getUnit("Fantassin").setIAttack(new
		 * AttackCaCBerserker());
		 * 
		 * if (a.getUnit("Rodeur").canAttackFromRange(3))
		 * System.out.println(attack("Rodeur", "Tank"));
		 * 
		 * System.out.println(attack("Eclaireur", "Eclaireur"));
		 * System.out.println(attack("Fantassin", "Tank"));
		 * System.out.println(attack("Fantassin", "Tank"));
		 * System.out.println(attack("Fantassin", "Tank"));
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
			return "L'unit� " + def + " n'�xiste pas !";
		}
	}

	public String attack(Tile att, Tile def) {
		try {
			Unit at = a.getUnit(att.x, att.y);
			Unit de = b.getUnit(def.x, def.y);

			// TODO: v�rif coordonn�es
			// if(at.canAttackFromRange())

			return attack(at.getName(), de.getName());
		} catch (NullPointerException e) {
			return "unit� introuvable";
		}
	}

}
