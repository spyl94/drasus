package view;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class Tile {

    public enum FIELD {
	DEFAULT, GRASS, FOREST, MOUNTAIN, BRIDGE, FORT
    }

    public Tile() {
	x = 0;
	y = 0;
	this.blocked = false;
	this.field = FIELD.DEFAULT;
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
    
    @Override
    public boolean equals(Object o){
	 if ( this == o ) return true;
	 if (!(o instanceof Tile) ) return false;
	 Tile t = (Tile) o;
	 return this.x == t.x && this.y == t.y;
    }

    public FIELD getField() {
	return field;
    }

    public boolean isBlocked() {
	return blocked;
    }

}
