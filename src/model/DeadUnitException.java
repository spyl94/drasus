package model;

public class DeadUnitException extends Exception {

	private String name;
	private int dmg;
	public DeadUnitException() {
		System.out.println("L'unité est morte !");
	}
	
	public DeadUnitException(String str, int dmg) {
		this.name = str;
		this.dmg = dmg;
	}

	public String getName() {
		return name;
	}
	public int getDmg() {
		return dmg;
	}

}
