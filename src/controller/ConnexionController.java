package controller;

import java.io.IOException;

import model.*;

import com.esotericsoftware.kryo.*;
import com.esotericsoftware.kryonet.*;
import controller.ConnexionController;

public class ConnexionController {

    /**
     * @param args
     */

    private Client client;
    private Msg msg = new Msg();
    private Player[] envoi;
    private Player[] recu;

    public ConnexionController(String adr) {

	client = new Client();

	Kryo kryo = client.getKryo();
	kryo.register(model.Player.class);
	kryo.register(model.Msg.class);
	kryo.register(model.UnitFactoryPegasus.class);
	kryo.register(java.util.Hashtable.class);
	kryo.register(model.units.ArcherPegasus.class);
	kryo.register(model.units.ArcherMontePegasus.class);
	kryo.register(model.attack.AttackCaC.class);
	kryo.register(model.attack.AttackCaCBerserker.class);
	kryo.register(model.attack.AttackDistance.class);
	kryo.register(model.units.BerserkerPegasus.class);
	kryo.register(model.units.BretteurPegasus.class);
	kryo.register(model.units.CavalierPegasus.class);
	kryo.register(model.units.ChevalierPegasus.class);
	kryo.register(model.exception.DeadUnitException.class);
	kryo.register(model.units.EclaireurPegasus.class);
	kryo.register(model.units.FantassinPegasus.class);
	kryo.register(model.attack.IAttack.class);
	kryo.register(model.units.LancierPegasus.class);
	kryo.register(model.units.RodeurPegasus.class);
	kryo.register(model.units.TankPegasus.class);
	kryo.register(model.units.Unit.class);
	kryo.register(model.UnitFactory.class);
	kryo.register(model.UnitFactoryPegasus.class);
	kryo.register(model.units.Unit.Weapon.class);
	kryo.register(view.Tile.class);
	kryo.register(model.Player[].class);
	kryo.register(view.Tile.FIELD.class);
	kryo.register(String[].class);

	client.start();

	client.addListener(new Listener() {
	    public void received(Connection connection, Object object) {
		if (object instanceof Player[]) {
		    recu = (Player[]) object;
		}
		if (object instanceof Msg) {
		    msg = (Msg) object;
		}
	    }
	});

	try {
	    client.connect(5000, adr, 4662, 4672);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void sendPlayer(Player player) {
	envoi = new Player[1];
	envoi[0] = player;
	client.sendTCP(envoi);
    }

    public void sendPlayers(Player a, Player b) {
	envoi = new Player[2];
	envoi[0] = a;
	envoi[1] = b;
	client.sendTCP(envoi);
    }

    public void sendMsg(Msg msg) {
	client.sendTCP(msg);
    }

    public Player[] getPlayer() {
	return recu;
    }

    public void setNull() {
	recu = null;
    }

    public void eraseMsg() {
	msg = null;
    }

    public Msg getMsg() {
	return msg;
    }
}
