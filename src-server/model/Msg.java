package model;

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

    public String getMsg() {
	return message;
    }

    public boolean getFirstCo() {
	return firstCo;
    }

    public boolean getOkCo() {
	return okCo;
    }

    public void setMsg(String mess) {
	message = mess;
    }

    public void setFirstCo(boolean first) {
	firstCo = first;
    }

    public void setOkCo(boolean ok) {
	okCo = ok;
    }
}
