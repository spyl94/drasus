package model;

public class DeadUnitException extends Exception {

	public DeadUnitException() {
		System.out.println("L'unité est morte !");
	}
	
	public DeadUnitException(String str) {
		System.out.println("L'unité " + str + " est morte !");
	}

}
