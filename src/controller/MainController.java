package controller;

import model.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MainController {

	private Player a;
	private Player b;

	/**
	 * @param args
	 */
	public MainController() {
		a = new Player();
		b = new Player();
	}

	public void init() {
		
		/*
		try
		{
			AppGameContainer app = new AppGameContainer(new ViewController());
			//app.setShowFPS(false);
			app.setDisplayMode(500, 400, false);
			app.start();
		}
		catch (SlickException e)
		{
			e.printStackTrace();
		}
		*/
		

		this.a.addUnit("Eclaireur");
		this.a.addUnit("Fantassin");
		this.a.addUnit("Rodeur");
		

		// b est géré par le réseau on ne le créé jamais il est récupéré !
		this.b.addUnit("Eclaireur");
		this.b.addUnit("Tank");
		this.b.addUnit("Bretteur");
		
		
		//Pour changer la porté d'un rodeur à 5: exemple de pouvoir
		a.getUnit("Rodeur").setIAttack(new AttackDistance(5));
		//Pour donner 15% de double attack
		a.getUnit("Fantassin").setIAttack(new AttackCaCBerserker());
		
		if (a.getUnit("Rodeur").canAttackFromRange(3))
			System.out.println(attack("Rodeur","Tank"));

		System.out.println(attack("Eclaireur", "Eclaireur"));
		System.out.println(attack("Fantassin", "Tank"));
		System.out.println(attack("Fantassin", "Tank"));
		System.out.println(attack("Fantassin", "Tank"));

	}

	public static void main(String[] args) {

		MainController controller = new MainController();

		controller.init();

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

}
