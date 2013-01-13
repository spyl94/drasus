package view;

import controller.*;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;


public class VictoryState extends BasicGameState {

    private int stateID = -1;

    Image background = null;
    Image menu = null;
    int mouseX = 0;
    int mouseY = 0;

    public VictoryState(int stateID) {
	this.stateID = stateID;
    }

    @Override
    public int getID() {
	return stateID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg)
	    throws SlickException {
	background = new Image("res/victoire/victoire.png");
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
	    throws SlickException {
	
    }

    @Override
    public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
	    throws SlickException {
	background.draw(0, 0);
	
    }

}