package view;
import controller.*;

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
import org.newdawn.slick.tiled.TiledMap;

public class GamePlayState extends BasicGameState {

	
	private TiledMap grassMap;
	private enum STATES {
        START_GAME, NEW_UNIT, SELECTING_UNIT, LINE_DESTRUCTION_STATE,
        PAUSE_GAME_STATE, HIGHSCORE_STATE, GAME_OVER_STATE
    }
	private int stateID = -1;
	private STATES currentState = null;
	
	public GamePlayState(int stateID) {
		this.stateID = stateID;
		currentState = STATES.START_GAME;
	}
	
	@Override
	public int getID() {
		return stateID;
	}


	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		grassMap = new TiledMap("res/sans-titre.tmx");
		
	}


	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics arg2)
			throws SlickException {
		grassMap.render(0, 0);
		
	}


	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
        switch(currentState)
        {
            case START_GAME:
                currentState = STATES.NEW_UNIT;
                break;
            case NEW_UNIT:
                
                break;
            case SELECTING_UNIT:
                //updatePiece( gc, sb, delta);
                break;
            case PAUSE_GAME_STATE:
                break;
            case GAME_OVER_STATE:
                //sbg.enterState(ViewController.MAINMENUSTATE);
                break;
        }
		
	}
	
	

}
