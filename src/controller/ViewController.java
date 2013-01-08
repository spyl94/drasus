package controller;

import view.*;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * 
 * @author Aurel
 * 
 */
public class ViewController extends StateBasedGame {

    public static final int MAINMENUSTATE = 0;
    public static final int GAMEPLAYSTATE = 1;

    public ViewController() {
	super("Drasus");
    }

    @Override
    public void initStatesList(GameContainer gameContainer)
	    throws SlickException {
	this.addState(new MainMenuState(MAINMENUSTATE));
	this.addState(new GamePlayState(GAMEPLAYSTATE));
    }
}