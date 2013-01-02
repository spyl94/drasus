package view;

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

	public GamePlayState(int stateID) {
		this.stateID = stateID;
		currentState = STATES.START_GAME;
		main = MainController.getInstance();
	}

	@Override
	public int getID() {
		return stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		grassMap = new TiledMap("res/sans-titre.tmx");
		blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];
		for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
			for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
				int tileID = grassMap.getTileId(xAxis, yAxis, 0);
				String value = grassMap.getTileProperty(tileID, "blocked",
						"false");
				if ("true".equals(value)) {
					blocked[xAxis][yAxis] = true;
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
			if (blocked[tile.x][tile.y] == false
					&& main.isFreeTileset(tile.x, tile.y))
				main.addUnit("Eclaireur", tile.x, tile.y);
			else
				System.out.println("Impossible de placer une unité ici");
		
		//si il reste des unités à placer
		currentState = STATES.NEW_UNIT;
		//sinon
		//currentState = STATES.START_TURN
		
	}
	private  void playTurn(GameContainer gc, StateBasedGame sbg, int delta)
	{
		Tile tile = getTileClicked(gc);
		if (tile != null)
		{
			if(main.isPlayerAUnit(tile.x, tile.y))
			{
				currentState = STATES.SELECTING_UNIT;
				currentSelected = tile;
			}
		}
			

		//autres...
	}
	
	private void selectingUnit(GameContainer gc, StateBasedGame sbg, int delta)
	{
		Tile tile = getTileClicked(gc);
		if (tile != null)
		{
			//on clique sur une unité de B
			if(main.isPlayerBUnit(tile.x, tile.y))
			{
				System.out.println(main.attack(currentSelected, tile));
				// Si tout c'est bien passé on réinitialise l'état
				currentState = STATES.PLAY_TURN;
				
			}
			//si on clic que une case vide déplacement
			if(main.isFreeTileset(tile.x, tile.y) && blocked[tile.x][tile.y] == false)
			{
				//move
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
			return new Tile(x, y);
		}
		return null;
	}

}
