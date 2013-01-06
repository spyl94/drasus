package view;

public class Tile {

	public enum FIELD {
		DEFAULT, GRASS, FOREST, MOUNTAIN, BRIDGE, FORT
	}

	// let public for easier use
	public final int x;
	public final int y;

	private FIELD field;
	private boolean blocked;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.blocked = false;
		this.field = FIELD.DEFAULT;
	}

	public Tile(int x, int y, boolean block) {
		this(x, y);
		this.blocked = block;
		this.field = FIELD.DEFAULT;
	}

	public Tile(int x, int y, boolean block, FIELD field) {
		this(x, y, block);
		this.field = field;
	}

	public FIELD getField() {
		return field;
	}

	public boolean isBlocked() {
		return blocked;
	}

}
