package view;

import java.util.Vector;

import controller.*;
import model.*;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.tiled.TileSet;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.geom.Vector2f;

public class GamePlayState extends BasicGameState {

	private enum STATES {
		START_GAME, NEW_UNIT, START_TURN, PLAY_TURN, SELECTING_UNIT, PAUSE_GAME, GAME_OVER
	}

	private TiledMap grassMap;
	private boolean[][] blocked;
	private int stateID = -1;
	private STATES currentState = null;
	private MainController main;
	private Tile currentSelected = null;
	private Vector<Tile> tiles;
	Image Archer = null;
	Image ArcherMonte = null;
	Image Berserker = null;
	Image Bretteur = null;
	Image Cavalier = null;
	Image Chevalier = null;
	Image Eclaireur = null;
	Image Fantassin = null;
	Image Lancier = null;
	Image Rodeur = null;
	Image Tank = null;

	public GamePlayState(int stateID) {
		this.stateID = stateID;
		currentState = STATES.START_GAME;
		tiles = new Vector<Tile>();
		main = MainController.getInstance();
	}

	@Override
	public int getID() {
		return stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		Archer = new Image("res/sprites/Archer.png");
		ArcherMonte = new Image("res/sprites/Archermonte.png");
		Berserker = new Image("res/sprites/Berserk.png");
		Bretteur = new Image("res/sprites/Bretteur.png");
		Cavalier = new Image("res/sprites/Cavalier.png");
		Chevalier = new Image("res/sprites/Chevalier.png");
		Eclaireur = new Image("res/sprites/Eclaireur.png");
		Fantassin = new Image("res/sprites/Fantassin.png");
		Lancier = new Image("res/sprites/Lancier.png");
		Rodeur = new Image("res/sprites/Rodeur.png");
		Tank = new Image("res/sprites/Tank.png");

		grassMap = new TiledMap("res/drasus.tmx");

		/* Init Vector tiles */

		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
				int tileID = grassMap.getTileId(xAxis, yAxis, 0);
				System.out.println(tileID);
				boolean block = false;
				String value = grassMap.getTileProperty(tileID, "blocked",
						"false");
				if ("true".equals(value)) {
					block = true;
				}
				value = grassMap.getTileProperty(tileID, "field", "default");
				switch (value) {
				case "default":
					tiles.addElement(new Tile(xAxis, yAxis, block));
					break;

				default:
					break;
				}
			}
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics arg2)
			throws SlickException {
		grassMap.render(0, 0);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		switch (currentState) {
		case START_GAME:
			currentState = STATES.NEW_UNIT;
			break;
		case NEW_UNIT:
			newUnit(gc, sbg, delta);
			break;
		case START_TURN:
			currentState = STATES.PLAY_TURN;
		case PLAY_TURN:
			playTurn(gc, sbg, delta);
		case SELECTING_UNIT:
			selectingUnit(gc, sbg, delta);
			break;
		case PAUSE_GAME:
			break;
		case GAME_OVER:
			sbg.enterState(ViewController.MAINMENUSTATE);
			break;
		}

	}

	private void newUnit(GameContainer gc, StateBasedGame sbg, int delta) {
		Tile tile = getTileClicked(gc);
		if (tile != null) // si clic
			if (tile.isBlocked() == false && main.isFreeTileset(tile))
				main.addUnit("Eclaireur", tile);
			else
				System.out.println("Impossible de placer une unité ici");

		// si il reste des unités à placer
		currentState = STATES.NEW_UNIT;
		// sinon
		// currentState = STATES.START_TURN

	}

	private void playTurn(GameContainer gc, StateBasedGame sbg, int delta) {
		Tile tile = getTileClicked(gc);
		if (tile != null) {
			if (main.isPlayerAUnit(tile)) {
				currentState = STATES.SELECTING_UNIT;
				currentSelected = tile;
			}
		}

		// autres...
	}

	private void selectingUnit(GameContainer gc, StateBasedGame sbg, int delta) {
		Tile tile = getTileClicked(gc);
		if (tile != null) {
			// on clique sur une unité de B
			if (main.isPlayerBUnit(tile)) {
				System.out.println(main.attack(currentSelected, tile));
				// Si tout c'est bien passé on réinitialise l'état
				currentState = STATES.PLAY_TURN;

			}
			// si on clic que une case vide déplacement
			if (main.isFreeTileset(tile) && tile.isBlocked() == false) {
				// move
			}
		}
	}

	private Tile getTileClicked(GameContainer gc) {
		Input input = gc.getInput();
		if (input.isMousePressed(0)) {
			
			int mouseX = input.getMouseX();
			int mouseY = input.getMouseY();
			int x = 0;
			int y = 0;
			
			x = mouseX / grassMap.getTileWidth();
			y = mouseY / grassMap.getTileHeight();
			System.out.println(mouseX + " x : " + x);
			System.out.println(mouseY + " y : " + y);

			for (Tile t : tiles) {
				if (t.x == x && t.y == y)
					return t;
			}
		}
		return null;
	}

}
