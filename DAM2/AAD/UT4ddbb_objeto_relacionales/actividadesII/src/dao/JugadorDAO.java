package dao;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import model.Jugador;

public class JugadorDAO {
	
	public static void getPlayersAndCountries() {
		ODB odb = ODBFactory.open("equipos.db");
		Objects<Jugador> jugadores = null;
		
		jugadores = odb.getObjects(Jugador.class);
		while(jugadores.hasNext()) {
			System.out.println(jugadores.next());
		}
		
		odb.close();
	}
	
	public static void getFootballAbove20() {
		ODB odb = ODBFactory.open("equipos.db");

		ICriterion crit = new And()
				.add(Where.ge("edad", 20))
				.add(Where.equal("deporte", "fútbol"));
		CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
		query.orderByAsc("nombre");
		
		Objects<Jugador> jugadores = odb.getObjects(query);
		for (Jugador e: jugadores) {
			System.out.println(e);
		}
		odb.close();
	}
	
	public static void getFrenchOrBasketPlayers() {
		ODB odb = ODBFactory.open("equipos.db");
		
		ICriterion crit = new Or()
				.add(Where.equal("pais.nombrepais", "FRANCIA"))
				.add(Where.equal("deporte", "baloncesto"));
		CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
		query.orderByAsc("nombre");
		
		Objects<Jugador> jugadores = odb.getObjects(query);
		for (Jugador e: jugadores) {
			System.out.println(e);
		}
		odb.close();
	}
	
	public static void getPlayersBySport() {
		ODB odb = ODBFactory.open("equipos.db");
		
		Values vals = odb.getValues(new ValuesCriteriaQuery(Jugador.class)
				.field("deporte")
				.count("nombre")
				.groupBy("deporte"));
		
		while (vals.hasNext()) {
			ObjectValues ov = (ObjectValues) vals.next();
			System.out.println("Deporte->" + ov.getByAlias("deporte") + ":" + ov.getByIndex(1));
		}
		odb.close();
	}
	
	public static void getAvgAge() {
		ODB odb = ODBFactory.open("equipos.db");
		
		Values vals = odb.getValues(new ValuesCriteriaQuery(Jugador.class)
				.avg("edad"));
		
		while (vals.hasNext()) {
			ObjectValues ov = (ObjectValues) vals.next();
			System.out.println("Edad media de los jugadores: " + ov.getByIndex(0));
		}
		odb.close();
	}
	
}
