package view;

public class Tile {
	
	public int x;
	public int y;

	private FIELD field;
	private boolean blocked;
	
	public enum FIELD {
		DEFAULT, GRASS, FOREST, MOUNTAIN, BRIDGE, FORT
	}
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.blocked = false;
		this.field = FIELD.DEFAULT;
		
	}
	
	public Tile(int x, int y, boolean block)
	{
		this(x,y);
		this.blocked=block;
		this.field = FIELD.DEFAULT;
	}
	public Tile(int x, int y, boolean block, FIELD field)
	{
		this(x,y,block);
		this.field = field;
	}
	public boolean isBlocked()
	{
		return blocked;
	}
	public FIELD getField()
	{
		return field;
	}

}
