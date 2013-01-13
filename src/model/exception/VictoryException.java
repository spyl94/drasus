package model.exception;

/**
 * @author Aurel
 * 
 */
@SuppressWarnings("serial")
public class VictoryException extends Exception {

    private String name;

    public VictoryException(DeadBossException e) {
	name = e.getName() + "est mort ! Victoire !";
    }

    public String getName() {
	return name;
    }

}
