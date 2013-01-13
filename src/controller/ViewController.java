package controller;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import view.GamePlayState;
import view.LoseState;
import view.MainMenuState;
import view.VictoryState;

/**
 * 
 * @author Aurel
 * 
 */
public class ViewController extends StateBasedGame {

    public static final int MAINMENUSTATE = 0;
    public static final int GAMEPLAYSTATE = 1;
    public static final int VICTORYSTATE = 2;
    public static final int LOSESTATE = 3;

    public ViewController() {
	super("Drasus");
    }

    @Override
    public void initStatesList(GameContainer gameContainer)
	    throws SlickException {
	
	this.addState(new MainMenuState(MAINMENUSTATE));
	this.addState(new GamePlayState(GAMEPLAYSTATE));
	this.addState(new VictoryState(VICTORYSTATE));
	this.addState(new LoseState(LOSESTATE));
    }
}