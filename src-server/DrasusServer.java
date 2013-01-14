import java.io.IOException;

import model.*;
import com.esotericsoftware.kryo.*;
import com.esotericsoftware.kryonet.*;

public class DrasusServer {

	private Server server;
	public static int PORT = 4667;
	private boolean temp = false;

	/**
	 * @param args
	 */

	public DrasusServer() {
		server = new Server();

		Kryo kryo = server.getKryo();
		kryo.register(model.Player.class);
		kryo.register(model.Msg.class);
		kryo.register(view.Tile.class);
		kryo.register(model.Player[].class);
		kryo.register(view.Tile.FIELD.class);
		kryo.register(String[].class);
		kryo.register(model.UnitFactory.class);
		kryo.register(model.UnitFactoryDragon.class);
		kryo.register(model.UnitFactoryPegasus.class);
		kryo.register(model.attack.Attack.class);
		kryo.register(model.attack.AttackCaC.class);
		kryo.register(model.attack.AttackCaCBerserker.class);
		kryo.register(model.attack.AttackCaCBerserkerBoosted.class);
		kryo.register(model.attack.AttackCaCBoostedInHill.class);
		kryo.register(model.attack.AttackCaCChevalier.class);
		kryo.register(model.attack.AttackCaCCripple.class);
		kryo.register(model.attack.AttackCaCCrippleLonger.class);
		kryo.register(model.attack.AttackCaCIgnoreArmor.class);
		kryo.register(model.attack.AttackDistance.class);
		kryo.register(model.attack.AttackDistanceArcher.class);
		kryo.register(model.attack.AttackDistanceDoubledAgainstCavalry.class);
		kryo.register(model.attack.AttackDistanceDoubledInForest.class);
		kryo.register(model.attack.AttackDistancePoisoned.class);
		kryo.register(model.attack.AttackDistancePoisonedLonger.class);
		kryo.register(model.exception.DeadBossException.class);
		kryo.register(model.exception.DeadUnitException.class);
		kryo.register(model.exception.VictoryException.class);
		kryo.register(model.units.ArcherDragon.class);
		kryo.register(model.units.ArcherMonteDragon.class);
		kryo.register(model.units.ArcherMontePegasus.class);
		kryo.register(model.units.ArcherPegasus.class);
		kryo.register(model.units.BerserkerDragon.class);
		kryo.register(model.units.BerserkerPegasus.class);
		kryo.register(model.units.BretteurDragon.class);
		kryo.register(model.units.BretteurPegasus.class);
		kryo.register(model.units.CavalierDragon.class);
		kryo.register(model.units.CavalierPegasus.class);
		kryo.register(model.units.ChevalierDragon.class);
		kryo.register(model.units.ChevalierPegasus.class);
		kryo.register(model.units.Dragon.class);
		kryo.register(model.units.EclaireurDragon.class);
		kryo.register(model.units.EclaireurPegasus.class);
		kryo.register(model.units.FantassinDragon.class);
		kryo.register(model.units.FantassinPegasus.class);
		kryo.register(model.units.LancierDragon.class);
		kryo.register(model.units.LancierPegasus.class);
		kryo.register(model.units.Pegasus.class);
		kryo.register(model.units.RodeurDragon.class);
		kryo.register(model.units.RodeurPegasus.class);
		kryo.register(model.units.TankDragon.class);
		kryo.register(model.units.TankPegasus.class);
		kryo.register(model.units.Unit.class);
		kryo.register(java.util.Hashtable.class);
		kryo.register(model.units.Unit.Weapon.class);

		server.addListener(new Listener() {
			public void received(Connection connection, Object object) {
				if (object instanceof Msg) {
					Msg request = (Msg) object;
					if (request.getFirstCo()) {
						if (request.getOkCo() != true) {
							if (connection.getID() % 2 == 0) {
								for (int i = 0; i < server.getConnections().length; i++) {
									if (server.getConnections()[i].getID() == connection
											.getID() - 1) {
										if (server.getConnections()[i]
												.isConnected()) {
											temp = true;
										}
									}
								}
								if (temp == true) {
									Msg msg = new Msg("Roger", true, true);
									java.util.Random rand = new java.util.Random();
									int randomNum = rand.nextInt(1);
									randomNum++;
									server.sendToTCP(connection.getID()
											- randomNum, msg);
									msg.setFirstCo(false);
									if (randomNum == 0) {
										randomNum = 1;
									} else {
										randomNum = 0;
									}
									server.sendToTCP(connection.getID()
											- randomNum, msg);
									temp = false;
								} else {
									connection.close();
								}
							}
						} else {
							if (connection.getID() % 2 == 0) {
								server.sendToTCP(connection.getID() - 1,
										request);
							} else {
								server.sendToTCP(connection.getID() + 1,
										request);
							}
						}
					} else {
						if (request.getOkCo() == true) {
							Msg msg = new Msg(request.getMsg(), false, true);
							if (connection.getID() % 2 == 0) {
								server.sendToTCP(connection.getID() - 1, msg);
							} else {
								server.sendToTCP(connection.getID() + 1, msg);
							}
						}
					}
				}

				if (object instanceof Player[]) {
					Player[] player;
					player = (Player[]) object;
					if (connection.getID() % 2 == 0) {
						server.sendToTCP(connection.getID() - 1, player);
					} else {
						server.sendToTCP(connection.getID() + 1, player);
					}
				}
			}

		});

		try {
			server.bind(DrasusServer.PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		server.start();
	}

	public static void main(String[] args) throws IOException {
		for (String s : args) {
		    System.out.println(s);
		    if (s.contains("-port=")) {
		    	s = s.replace("-port=", "");
		    	DrasusServer.PORT =  Integer.parseInt(s);
		    }
		}
		new DrasusServer();
	}

}
