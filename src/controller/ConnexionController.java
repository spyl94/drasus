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
	private Player player = null;
	private Msg msg = new Msg();
	public ConnexionController(String adr) {

		client = new Client();

		Kryo kryo = client.getKryo();
		kryo.register(Player.class);
		kryo.register(Msg.class);
		kryo.register(model.UnitFactoryPegasus.class);
		kryo.register(java.util.Hashtable.class);
		kryo.register(model.Archer.class);
		kryo.register(model.ArcherMonte.class);
		kryo.register(model.AttackCaC.class);
		kryo.register(model.AttackCaCBerserker.class);
		kryo.register(model.AttackDistance.class);
		kryo.register(model.Berserker.class);
		kryo.register(model.Bretteur.class);
		kryo.register(model.Cavalier.class);
		kryo.register(model.Chevalier.class);
		kryo.register(model.DeadUnitException.class);
		kryo.register(model.Eclaireur.class);
		kryo.register(model.Fantassin.class);
		kryo.register(model.IAttack.class);
		kryo.register(model.Lancier.class);
		kryo.register(model.Rodeur.class);
		kryo.register(model.Tank.class);
		kryo.register(model.Unit.class);
		kryo.register(model.UnitFactory.class);
		kryo.register(model.Weapon.class);
		
		client.start();

		client.addListener(new Listener() {
			public void received(Connection connection, Object object) {
				if (object instanceof Player) {
					player = (Player) object;
				}
				if (object instanceof Msg) {
					msg = (Msg) object;
				}
			}
		});
		
		try {
			client.connect(5000, adr, 54555, 54777);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SendPlayer(Player player) {
		client.sendTCP(player);
		System.out.println("Envoie du player en cours...");
	}

	public void SendMsg(Msg msg) {
		client.sendTCP(msg);
	}

	public Player getPlayer() {
		return player;
	}
	
	public Msg getMsg(){
		return msg;
	}
}
