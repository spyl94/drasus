package view;

import controller.*;

import org.lwjgl.Sys;
import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;

public class MainMenuState extends BasicGameState {

    private int stateID = -1;
    Image background = null;

    public MainMenuState(int stateID) {
	this.stateID = stateID;
    }

    @Override
    public int getID() {
	return stateID;
    }

    float startGameScale = 1;
    float exitScale = 1;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg)
	    throws SlickException {

	background = new Image("res/menu.jpg");

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
	    throws SlickException {

	Input input = gc.getInput();

	int mouseX = input.getMouseX();
	int mouseY = input.getMouseY();

	boolean insideStartGame = false;

	if ((mouseX >= 0 && mouseX <= background.getWidth())
		&& (mouseY >= 0 && mouseY <= background.getHeight()))
	    insideStartGame = true;

	/*
	 * }else if( ( mouseX >= menuX && mouseX <= menuX+
	 * exitOption.getWidth()) && ( mouseY >= menuY+80 && mouseY <= menuY+80
	 * + exitOption.getHeight()) ){ insideExit = true; }
	 */

	if (insideStartGame)
	    sbg.enterState(ViewController.GAMEPLAYSTATE);

    }

    @Override
    public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
	    throws SlickException {
	background.draw(0, 0);
    }

}