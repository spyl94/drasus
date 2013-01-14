package view;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import controller.MainController;
import controller.ViewController;

/**
 * @author Adrien
 * 
 */
public class MainMenuState extends BasicGameState {

	private int stateID = -1;
	private MainController main;

	private Image background = null;
	private Image startGame = null;
	private Image dragonSilver = null;
	private Image dragonGold = null;
	private Image pegasusSilver = null;
	private Image pegasusGold = null;
	private int mouseX = 0;
	private int mouseY = 0;
	private boolean isPegasus = true;
	private Font awtFont;
	private TrueTypeFont message;
	private boolean insideStartGame = false;
	private Image calque;
	
	public MainMenuState(int stateID) {
		this.stateID = stateID;
		main = MainController.getInstance();
	}

	@Override
	public int getID() {
		return stateID;
	}

	/**
	 * Send the position of the mouse when it clicked.
	 * 
	 * @param gc
	 *            gc is the game container created by slick
	 */
	private void getPosClicked(GameContainer gc) {
		Input input = gc.getInput();
		if (input.isMousePressed(0)) {
			mouseX = input.getMouseX();
			mouseY = input.getMouseY();
		}
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		background = new Image("res/menu/drasus.png");
		pegasusSilver = new Image("res/menu/pegasusSilver.png");
		pegasusGold = new Image("res/menu/pegasusGold.png");
		dragonGold = new Image("res/menu/dragonGold.png");
		dragonSilver = new Image("res/menu/dragonSilver.png");
		startGame = new Image("res/menu/jouer.png");
		awtFont = new Font("Times New Roman", Font.BOLD, 24);
		message = new TrueTypeFont(awtFont, false);
		calque = new Image("res/sprites/calqueblanc.png");
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		background.draw(0, 0);
		startGame.draw(530, 500);
		if(insideStartGame){
			calque.draw(32, 673);
			message.drawString(35, 675, "En attende d'un autre joueur", Color.black);
		}
		if (isPegasus) {
			pegasusGold.draw(270, 200);
			dragonSilver.draw(865, 200);
		} else {
			pegasusSilver.draw(270, 200);
			dragonGold.draw(865, 200);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		getPosClicked(gc);

		if (main.isAuto()) {
			main.setPlayerA("Pegasus");
			insideStartGame = true;
		}

		if ((mouseX >= 270 && mouseX <= pegasusGold.getWidth() + 270)
				&& (mouseY >= 200 && mouseY <= pegasusGold.getHeight() + 200)) {
			isPegasus = true;
		}

		if ((mouseX >= 865 && mouseX <= pegasusGold.getWidth() + 865)
				&& (mouseY >= 200 && mouseY <= pegasusGold.getHeight() + 200)) {
			isPegasus = false;
		}

		if (insideStartGame)
			sbg.enterState(ViewController.GAMEPLAYSTATE);

		if ((mouseX > 530 && mouseX < startGame.getWidth() + 530)
				&& (mouseY >= 500 && mouseY <= startGame.getHeight() + 500)) {
			insideStartGame = true;
			if (isPegasus) {
				main.setPlayerA("Pegasus");
			} else {
				main.setPlayerA("Dragon");
			}
		}

	}
}