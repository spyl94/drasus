package model;

public class DeadBossException extends DeadUnitException {

    public DeadBossException(String str, int dmg) {
	super(str, dmg);
    }

}
