package view;

import java.util.Vector;

import controller.*;
import model.*;
import model.exception.VictoryException;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.tiled.TileSet;
import org.newdawn.slick.tiled.TiledMap;

import view.Tile.FIELD;

public class GamePlayState extends BasicGameState {

    private enum STATES {
	START_GAME, NEW_UNIT, START_TURN, PLAY_TURN, END_TURN, SELECTING_UNIT, PAUSE_GAME, GAME_OVER
    }

    private TiledMap grassMap;
    private int stateID = -1;
    private STATES currentState = null;
    private MainController main;
    private Tile currentSelected = null;
    private Vector<Tile> tiles;
    private Image Archer = null;
    private Image ArcherMonte = null;
    private Image Berserker = null;
    private Image Bretteur = null;
    private Image Cavalier = null;
    private Image Chevalier = null;
    private Image Eclaireur = null;
    private Image Fantassin = null;
    private Image Lancier = null;
    private Image Rodeur = null;
    private Image Tank = null;
    private Image Target = null;
    private Image AtkTarget = null;
    private int unitNb = 0;
    private String[][] taba;
    private String[][] tabb;
    private Vector<Tile> highLight = new Vector<Tile>();
    private Vector<Tile> atkHighLight = new Vector<Tile>();
    private SpriteSheet ArcherS;
    private Animation ArcherA;
    private SpriteSheet ArcherR;
    private Animation ArcherAR;
    private SpriteSheet ArcherMonteS;
    private Animation ArcherMonteA;
    private SpriteSheet ArcherMonteR;
    private Animation ArcherMonteAR;
    private SpriteSheet BerserkerS;
    private Animation BerserkerA;
    private SpriteSheet BerserkerR;
    private Animation BerserkerAR;
    private SpriteSheet BretteurS;
    private Animation BretteurA;
    private SpriteSheet BretteurR;
    private Animation BretteurAR;
    private SpriteSheet CavalierS;
    private Animation CavalierA;
    private SpriteSheet CavalierR;
    private Animation CavalierAR;
    private SpriteSheet ChevalierS;
    private Animation ChevalierA;
    private SpriteSheet ChevalierR;
    private Animation ChevalierAR;
    private SpriteSheet EclaireurS;
    private Animation EclaireurA;
    private SpriteSheet EclaireurR;
    private Animation EclaireurAR;
    private SpriteSheet FantassinS;
    private Animation FantassinA;
    private SpriteSheet FantassinR;
    private Animation FantassinAR;
    private SpriteSheet LancierS;
    private Animation LancierA;
    private SpriteSheet LancierR;
    private Animation LancierAR;
    private SpriteSheet RodeurS;
    private Animation RodeurA;
    private SpriteSheet RodeurR;
    private Animation RodeurAR;
    private SpriteSheet TankS;
    private Animation TankA;
    private SpriteSheet TankR;
    private Animation TankAR;

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
	Target = new Image("res/sprites/path.png");
	grassMap = new TiledMap("res/drasus.tmx");
	AtkTarget = new Image("res/sprites/atk.png");
	ArcherS = new SpriteSheet("res/sprites/ArcherS.png", 32, 32);
	ArcherA = new Animation(ArcherS, 0, 0, 1, 0, false, 500, true);
	ArcherR = new SpriteSheet("res/sprites/ArcherR.png", 32, 32);
	ArcherAR = new Animation(ArcherR, 0, 0, 1, 0, false, 500, true);
	ArcherMonteS = new SpriteSheet("res/sprites/ArchermonteS.png", 32, 32);
	ArcherMonteA = new Animation(ArcherMonteS, 0, 0, 1, 0, false, 500, true);
	ArcherMonteR = new SpriteSheet("res/sprites/ArchermonteR.png", 32, 32);
	ArcherMonteAR = new Animation(ArcherMonteR, 0, 0, 1, 0, false, 500, true);
	BerserkerS = new SpriteSheet("res/sprites/BerserkS.png", 32, 32);
	BerserkerA = new Animation(BerserkerS, 0, 0, 1, 0, false, 500, true);
	BerserkerR = new SpriteSheet("res/sprites/BerserkR.png", 32, 32);
	BerserkerAR = new Animation(BerserkerR, 0, 0, 1, 0, false, 500, true);
	BretteurS = new SpriteSheet("res/sprites/BretteurS.png", 32, 32);
	BretteurA = new Animation(BretteurS, 0, 0, 1, 0, false, 500, true);
	BretteurR = new SpriteSheet("res/sprites/BretteurR.png", 32, 32);
	BretteurAR = new Animation(BretteurR, 0, 0, 1, 0, false, 500, true);
	CavalierS = new SpriteSheet("res/sprites/CavalierS.png", 32, 32);
	CavalierA = new Animation(CavalierS, 0, 0, 1, 0, false, 500, true);
	CavalierR = new SpriteSheet("res/sprites/CavalierR.png", 32, 32);
	CavalierAR = new Animation(CavalierR, 0, 0, 1, 0, false, 500, true);
	ChevalierS = new SpriteSheet("res/sprites/ChevalierS.png", 32, 32);
	ChevalierA = new Animation(ChevalierS, 0, 0, 1, 0, false, 500, true);
	ChevalierR = new SpriteSheet("res/sprites/ChevalierR.png", 32, 32);
	ChevalierAR = new Animation(ChevalierR, 0, 0, 1, 0, false, 500, true);
	EclaireurS = new SpriteSheet("res/sprites/EclaireurS.png", 32, 32);
	EclaireurA = new Animation(EclaireurS, 0, 0, 1, 0, false, 500, true);
	EclaireurR = new SpriteSheet("res/sprites/EclaireurR.png", 32, 32);
	EclaireurAR = new Animation(EclaireurR, 0, 0, 1, 0, false, 500, true);
	FantassinS = new SpriteSheet("res/sprites/FantassinS.png", 32, 32);
	FantassinA = new Animation(FantassinS, 0, 0, 1, 0, false, 500, true);
	FantassinR = new SpriteSheet("res/sprites/FantassinR.png", 32, 32);
	FantassinAR = new Animation(FantassinR, 0, 0, 1, 0, false, 500, true);
	LancierS = new SpriteSheet("res/sprites/LancierS.png", 32, 32);
	LancierA = new Animation(LancierS, 0, 0, 1, 0, false, 500, true);
	LancierR = new SpriteSheet("res/sprites/LancierR.png", 32, 32);
	LancierAR = new Animation(LancierR, 0, 0, 1, 0, false, 500, true);
	RodeurS = new SpriteSheet("res/sprites/RodeurS.png", 32, 32);
	RodeurA = new Animation(RodeurS, 0, 0, 1, 0, false, 500, true);
	RodeurR = new SpriteSheet("res/sprites/RodeurR.png", 32, 32);
	RodeurAR = new Animation(RodeurR, 0, 0, 1, 0, false, 500, true);
	TankS = new SpriteSheet("res/sprites/TankS.png", 32, 32);
	TankA = new Animation(TankS, 0, 0, 1, 0, false, 500, true);
	TankR = new SpriteSheet("res/sprites/TankR.png", 32, 32);
	TankAR = new Animation(TankR, 0, 0, 1, 0, false, 500, true);
	
	/* Init Vector tiles */

	for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
	    for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
		int tileID = grassMap.getTileId(xAxis, yAxis, 0);
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
		case "grass":
		    tiles.addElement(new Tile(xAxis, yAxis, block, FIELD.GRASS));
		    break;
		case "forest":
		    tiles.addElement(new Tile(xAxis, yAxis, block, FIELD.FOREST));
		    break;
		case "mountain":
		    tiles.addElement(new Tile(xAxis, yAxis, block,
			    FIELD.MOUNTAIN));
		    break;
		case "fort":
		    tiles.addElement(new Tile(xAxis, yAxis, block, FIELD.FORT));
		    break;
		case "bridge":
		    tiles.addElement(new Tile(xAxis, yAxis, block, FIELD.BRIDGE));
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

	if (highLight.isEmpty() == false) {
	    for (Tile t : highLight) {
		Target.draw(t.x * 32, t.y * 32);
	    }
	}

	if (atkHighLight.isEmpty() == false) {
	    for (Tile t : atkHighLight) {
		AtkTarget.draw(t.x * 32, t.y * 32);
	    }
	}
	
	taba = main.aToTab();
	for (int i = 0; i < taba.length; i++) {
	    switch (taba[i][0]) {
	    case "Archer":
		ArcherA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    case "ArcherMonte":
		ArcherMonteA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    case "Berserker":
		BerserkerA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    case "Bretteur":
		BretteurA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    case "Cavalier":
		CavalierA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    case "Chevalier":
		ChevalierA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    case "Eclaireur":
		EclaireurA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    case "Fantassin":
		FantassinA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    case "Lancier":
		LancierA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    case "Rodeur":
		RodeurA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    case "Tank":
		TankA.draw(Integer.parseInt(taba[i][1]) * 32,
			Integer.parseInt(taba[i][2]) * 32);
		break;
	    }

	}

	tabb = main.bToTab();
	for (int i = 0; i < tabb.length; i++) {
	    switch (tabb[i][0]) {
	    case "Archer":
		ArcherAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    case "ArcherMonte":
		ArcherMonteAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    case "Berserker":
		BerserkerAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    case "Bretteur":
		BretteurAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    case "Cavalier":
		CavalierAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    case "Chevalier":
		ChevalierAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    case "Eclaireur":
		EclaireurAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    case "Fantassin":
		FantassinAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    case "Lancier":
		LancierAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    case "Rodeur":
		RodeurAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    case "Tank":
		TankAR.draw(Integer.parseInt(tabb[i][1]) * 32,
			Integer.parseInt(tabb[i][2]) * 32);
		break;
	    }
	}
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta)
	    throws SlickException {
	switch (currentState) {
	case START_GAME:
	    currentState = STATES.NEW_UNIT;
	    autoGenerateBUnits();
	    // main.connexion("88.180.34.112");
	    break;
	case NEW_UNIT:
	    newUnit(gc, sbg, delta);
	    break;
	case START_TURN:
	    initTurn();
	    currentState = STATES.PLAY_TURN;
	case PLAY_TURN:
	    playTurn(gc, sbg, delta);
	case SELECTING_UNIT:
	    selectingUnit(gc, sbg, delta);
	    break;
	case END_TURN:
	    currentSelected = null;
	    System.out.println("fin du tour");
	    currentState = STATES.PAUSE_GAME;
	    // main.sendEnd();
	    // main.endTurn();
	    // if(main.getPlayerA().getTurn())
	    currentState = STATES.START_TURN;
	    break;
	case PAUSE_GAME:
	    main.recPlayers();
	    if (main.isTurn()) {
		currentState = STATES.START_TURN;
	    }
	    break;
	case GAME_OVER:
	    sbg.enterState(ViewController.MAINMENUSTATE);
	    break;
	}

    }

    private void initTurn() {
	try {
	    main.initNewTurn();
	} catch (VictoryException e) {
	    
	}
    }

    private void newUnit(GameContainer gc, StateBasedGame sbg, int delta) {
	Tile tile = getTileClicked(gc);
	if (tile != null) // si clic
	    if (tile.isBlocked() == false && main.isFreeTileset(tile)) {
		main.addUnit(main.getPlayerAUnitsNames()[unitNb], tile);
		System.out.print("Ajout :");
		System.out.println(main.getPlayerAUnitsNames()[unitNb]);
		unitNb++;
	    } else
		System.out.println("Impossible de placer une unité ici");

	// si il reste des unités à placer
	currentState = STATES.NEW_UNIT;
	// sinon

	if (unitNb == main.getPlayerAUnitsNames().length) {
	    currentState = STATES.START_TURN;
	    // main.sendPlayer();
	    // main.recPlayer();
	    if (main.getPlayerA().getTurn() == false) {
		currentState = STATES.PAUSE_GAME;
	    }
	}

    }

    private void playTurn(GameContainer gc, StateBasedGame sbg, int delta) {
	Tile tile = getTileClicked(gc);
	if (tile != null) {
	    if (main.isPlayerAUnit(tile)) {
		currentState = STATES.SELECTING_UNIT;
		currentSelected = tile;
		if ((!main.getTurn().hasMove(
			main.getUnit(tile)) && !main.getTurn().hasAttack(
					main.getUnit(tile)))) {
		    setHighLight(main.canCross(
			    tiles,
			    currentSelected,
			    main.getPlayerA()
				    .getUnit(currentSelected.x,
					    currentSelected.y).getMove()));
		}
		
		else if((main.getTurn().hasAttack(
					main.getUnit(tile)) && !main.getTurn().hasMoveAfterAttack(main.getUnit(tile)))){
		    setHighLight(main.canCross(
				    tiles,
				    currentSelected,
				    main.getPlayerA()
					    .getUnit(currentSelected.x,
						    currentSelected.y).getMat()));
		}
		
		else if(main.getTurn().hasMove(
				main.getUnit(tile)) && !main.getTurn().hasAttack(
					main.getUnit(tile))){
			setAtkHighLight(main.atkHighLight(tiles, currentSelected));
		}
		// setHighLight(main.canCross(tiles, currentSelected, 6));
	    }
	} else if (gc.getInput().isKeyPressed(Input.KEY_SPACE)) {
	    currentState = STATES.END_TURN;
	}

	// autres...
    }

    private void selectingUnit(GameContainer gc, StateBasedGame sbg, int delta) {
	Tile tile = getTileClicked(gc);
	if (tile != null) {
	    // on clique sur une unité de B
	    if (main.isPlayerBUnit(tile)) {
		try {
		    System.out.println(main.attack(currentSelected, tile));
		} catch (VictoryException e) {
		    // TODO: prévenir l'autre de sa défaite !
		    sbg.enterState(ViewController.MAINMENUSTATE);
		}
		// Si tout c'est bien passé on réinitialise l'état
		currentState = STATES.PLAY_TURN;

	    }

	    else {
		main.move(tile, currentSelected, highLight);
		// main.sendBoth();
		currentState = STATES.PLAY_TURN;
	    }
	    System.out.println(atkHighLight.size());
		highLight.clear();
		atkHighLight.clear();
	}
    }

    private void setHighLight(Vector<Tile> hl) {
	highLight = hl;
    }

    private void setAtkHighLight(Vector<Tile> hl) {
	atkHighLight = hl;
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
	    //System.out.println(mouseX + " x : " + x);
	    //System.out.println(mouseY + " y : " + y);

	    for (Tile t : tiles) {
		if (t.x == x && t.y == y)
		    return t;
	    }
	}
	return null;
    }

    private void autoGenerateBUnits() {
	main.addUnitToB("Eclaireur", tiles.get(800));
	main.addUnitToB("Fantassin", tiles.get(801));
	main.addUnitToB("Tank", tiles.get(802));
	main.addUnitToB("Archer", tiles.get(803));
    }

}
