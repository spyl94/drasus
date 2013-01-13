package model.exception;

/**
 * @author Aurel
 * 
 */
@SuppressWarnings("serial")
public class DeadBossException extends DeadUnitException {

    public DeadBossException(String str, int dmg) {
	super(str, dmg);
    }

}
