package model;

/**
 * @author Adrien
 * 
 */

public class Msg {
	private String message;
	private boolean firstCo;
	private boolean okCo;

	public Msg() {
		message = "";
		firstCo = false;
		okCo = false;
	}

	public Msg(String mess) {
		message = mess;
	}

	public Msg(String mess, boolean first) {
		message = mess;
		firstCo = first;
	}

	public Msg(String mess, boolean first, boolean ok) {
		message = mess;
		firstCo = first;
		okCo = ok;
	}

	/**
	 * Returns the boolean firstCo.
	 * 
	 * @return boolean firstCo
	 */
	public boolean getFirstCo() {
		return firstCo;
	}

	/**
	 * Returns the last message received.
	 * 
	 * @return message
	 */
	public String getMsg() {
		return message;
	}

	/**
	 * Returns true if the connection is set.
	 * 
	 * @return okCo
	 */
	public boolean getOkCo() {
		return okCo;
	}

	/**
	 * Set the boolean of first connection.
	 * 
	 * @param first
	 *            the boolean
	 */
	public void setFirstCo(boolean first) {
		firstCo = first;
	}

	/**
	 * Set the string of a Msg.
	 * 
	 * @param mess
	 *            The string we want to put in the Msg.
	 */
	public void setMsg(String mess) {
		message = mess;
	}

	/**
	 * Set the connection granted boolean.
	 * 
	 * @param ok
	 *            the boolean
	 */
	public void setOkCo(boolean ok) {
		okCo = ok;
	}
}
