package model.exception;

/**
 * @author Aurel
 * 
 */
public class DeadBossException extends DeadUnitException {

    public DeadBossException(String str, int dmg) {
	super(str, dmg);
    }

}
