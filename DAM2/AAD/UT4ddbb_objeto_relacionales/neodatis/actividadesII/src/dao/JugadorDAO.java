package dao;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.oid.OIDFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import model.Jugador;
import model.Paises;

public class JugadorDAO {
	
	public static void getPlayersAndCountries() {
		ODB odb = ODBFactory.open("equipos.db");
		Objects<Jugador> jugadores = odb.getObjects(Jugador.class);
		
		while (jugadores.hasNext()) {
			System.out.println(jugadores.next());
		}
		odb.close();
	}
	
	public static void getAbove20FootbalPlayers() {
		ODB odb = ODBFactory.open("equipos.db");
		ICriterion above20FooT = new And().add(Where.equal("deporte", "fútbol")).add(Where.gt("edad", 20));
		IQuery above20FooTQuery = new CriteriaQuery(Jugador.class, above20FooT);
		
		Objects<Jugador> jugadores = odb.getObjects(above20FooTQuery);
		while (jugadores.hasNext()) {
			System.out.println(jugadores.next());
		}
		
		odb.close();
	}
	
	public static void getFrenchOrBasketPayers() {
		ODB odb = ODBFactory.open("equipos.db");
		ICriterion crit = new Or().add(Where.equal("pais", "FRANCIA")).add(Where.equal("deporte", "baloncesto"));
		IQuery query = new CriteriaQuery(Jugador.class, crit);
		
		Objects<Jugador> jugadores = odb.getObjects(query);
		while(jugadores.hasNext()) {
			System.out.println(jugadores.next());
		}
		odb.close();
	}
	
	public static void saveNewJugador() {
		ODB odb = ODBFactory.open("equipos.db");
		Jugador j = new Jugador("Donald", "MMA", 34, new Paises(67, "Irlanda"));
		
		odb.store(j);
		odb.commit();
		odb.close();
	}
	
	public static void getJugadorFromOID(int i) {
		ODB odb = ODBFactory.open("equipos.db");
		
		OID oid = OIDFactory.buildObjectOID(i);
		Jugador j = (Jugador) odb.getObjectFromId(oid);
		
		System.out.println("Jugador con oid " + i + ": " + j);
		odb.close();
	}
	
	public static void getTotalPlayersBySport() {
		ODB odb = ODBFactory.open("equipos.db");
		Values values = odb.getValues(new ValuesCriteriaQuery(Jugador.class)
				.field("deporte").count("nombre").groupBy("deporte"));
		
		while (values.hasNext()) {
			ObjectValues ov = values.next();
			System.out.println(ov.getByAlias("deporte") + "->" + ov.getByIndex(1));
		}
		odb.close();
	}
	
	public static void getAvgPlayersAge() {
		ODB odb = ODBFactory.open("equipos.db");
		
		Values vals = odb.getValues(new ValuesCriteriaQuery(Jugador.class).avg("edad"));
		
		System.out.println("Edad media de los jugadores: " + vals.getFirst());
		odb.close();
	}
	
	public static void getMinMaxPlayersAge() {
		ODB odb = ODBFactory.open("equipos.db");
		
		Values v1 = odb.getValues(new ValuesCriteriaQuery(Jugador.class).max("edad"));
		Values v2 = odb.getValues(new ValuesCriteriaQuery(Jugador.class).min("edad"));
		
		System.out.println("Edad maxima " + v1.getFirst() + "\n" + "Edad minima "+ v2.getFirst());
		odb.close();
	}
	
	public static void getFootballBtw18And25() {
		ODB odb = ODBFactory.open("equipos.db");
		ICriterion crit = new And()
				.add(Where.equal("deporte", "fútbol"))
				.add(Where.ge("edad", 18))
				.add(Where.le("edad", 25));
		IQuery query = new CriteriaQuery(Jugador.class, crit);
		Objects<Jugador> jugadores = odb.getObjects(query);
		
		while (jugadores.hasNext()) {
			System.out.println(jugadores.next());
		}
		odb.close();
	}
	
	public static void getFrenchOrIta() {
		ODB odb = ODBFactory.open("equipos.db");
		ICriterion crit = new Or()
				.add(Where.equal("pais.nombrepais", "FRANCIA"))
				.add(Where.equal("pais.nombrepais", "ITALIA"));
		
		Values values = odb.getValues(new ValuesCriteriaQuery(Jugador.class, crit)
				.field("nombre", "jugador").field("pais.nombrepais", "pais"));
		
		while (values.hasNext()) {
			ObjectValues ov = values.next();
			System.out.println(ov.getByAlias("jugador") + ":" + ov.getByAlias("pais"));
		}
		odb.close();
	}
	
	public static void getBasketUnder23() {
		ODB odb = ODBFactory.open("equipos.db");
		
		ICriterion crit = new And()
				.add(Where.equal("deporte", "baloncesto"))
				.add(Where.le("edad", 22));
		
		Values vals = odb.getValues(new ValuesCriteriaQuery(Jugador.class, crit).field("nombre").field("edad"));
		
		while (vals.hasNext()) {
			ObjectValues ov = vals.next();
			System.out.println(ov.getByAlias("nombre") + ":" + ov.getByAlias("edad"));
		}
		odb.close();
	}
	
	public static void getFrenchOrTennisCount() {
		ODB odb = ODBFactory.open("equipos.db");
		ICriterion crit = new Or()
				.add(Where.equal("pais.nombrepais", "FRANCIA"))
				.add(Where.equal("deporte", "fútbol"));
		
		Values vals = odb.getValues(new ValuesCriteriaQuery(Jugador.class, crit)
				.count("nombre"));
		
		while (vals.hasNext()) {
			ObjectValues ov = vals.next();
			System.out.println("Jugadores franceses o que practican tenis: " + ov.getByIndex(0));
		}
		
		odb.close();
	}
	
	public static void getAvgTenisOrAbove22() {
		ODB odb = ODBFactory.open("equipos.db");
		ICriterion crit = new Or()
				.add(Where.equal("deporte", "tenis"))
				.add(Where.gt("edad", 22));
		
		Values vals = odb.getValues(new ValuesCriteriaQuery(Jugador.class, crit).avg("edad"));
		ObjectValues ov = vals.getFirst();
		
		System.out.println("Edad media: " + ov);
		
		odb.close();
	}
	
	//====================================================//
//	
//	public static void getPlayersAndCountries() {
//		ODB odb = ODBFactory.open("equipos.db");
//		Objects<Jugador> jugadores = null;
//		
//		jugadores = odb.getObjects(Jugador.class);
//		while(jugadores.hasNext()) {
//			System.out.println(jugadores.next());
//		}
//		
//		odb.close();
//	}
//	
//	public static void getFootballAbove20() {
//		ODB odb = ODBFactory.open("equipos.db");
//
//		ICriterion crit = new And()
//				.add(Where.gt("edad", 20))
//				.add(Where.equal("deporte", "fútbol"));
//		CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
//		query.orderByAsc("nombre");
//		
//		Objects<Jugador> jugadores = odb.getObjects(query);
//		for (Jugador e: jugadores) {
//			System.out.println(e);
//		}
//		odb.close();
//	}
//	
//	public static void getFrenchOrBasketPlayers() {
//		ODB odb = ODBFactory.open("equipos.db");
//		
//		ICriterion crit = new Or()
//				.add(Where.equal("pais.nombrepais", "FRANCIA"))
//				.add(Where.equal("deporte", "baloncesto"));
//		CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
//		query.orderByAsc("nombre");
//		
//		Objects<Jugador> jugadores = odb.getObjects(query);
//		for (Jugador e: jugadores) {
//			System.out.println(e);
//		}
//		odb.close();
//	}
//	
//	public static void getPlayersBySport() {
//		ODB odb = ODBFactory.open("equipos.db");
//		
//		Values vals = odb.getValues(new ValuesCriteriaQuery(Jugador.class)
//				.field("deporte")
//				.count("nombre")
//				.groupBy("deporte"));
//		
//		while (vals.hasNext()) {
//			ObjectValues ov = (ObjectValues) vals.next();
//			System.out.println("Deporte->" + ov.getByAlias("deporte") + ":" + ov.getByIndex(1));
//		}
//		odb.close();
//	}
//	
//	public static void getAvgAge() {
//		ODB odb = ODBFactory.open("equipos.db");
//		
//		Values vals = odb.getValues(new ValuesCriteriaQuery(Jugador.class)
//				.avg("edad"));
//		
//		while (vals.hasNext()) {
//			ObjectValues ov = (ObjectValues) vals.next();
//			System.out.println("Edad media de los jugadores: " + ov.getByIndex(0));
//		}
//		odb.close();
//	}
//	
//	public static void getFootballBetween18and25() {
//		ODB odb = ODBFactory.open("equipos.db");
//
//		ICriterion crit = new And()
//				.add(Where.equal("deporte", "fútbol"))
//				.add(Where.ge("edad", 18))
//				.add(Where.le("edad", 25));
//		
//		CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
//		query.orderByAsc("nombre");
//		
//		Objects<Jugador> jugadores = odb.getObjects(query);
//		for (Jugador e: jugadores) {
//			System.out.println(e);
//		}
//		odb.close();
//	}
//	
//	public static void getBasketUnder22() {
//		ODB odb = ODBFactory.open("equipos.db");
//		
//		ICriterion crit = new And()
//				.add(Where.equal("deporte", "baloncesto"))
//				.add(Where.not(Where.gt("edad", 22)));
//		
//		CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
//		query.orderByAsc("nombre");
//		
//		Objects<Jugador> jugadores = odb.getObjects(query);
//		for (Jugador e: jugadores) {
//			System.out.println(e);
//		}
//		odb.close();
//	}
//	
//	public static void getFrenchOrTennis() {
//		ODB odb = ODBFactory.open("equipos.db");
//		
//		ICriterion crit = new Or()
//				.add(Where.equal("deporte", "tenis"))
//				.add(Where.equal("pais.nombrepais", "FRANCIA"));
//		
//		CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
//		Values vals = odb.getValues(new ValuesCriteriaQuery(query)
//				.count("nombre"));
//		
//		System.out.println("Total jugadores: " + vals.next().getByIndex(0)); 
//
//		odb.close();
//	}
//	
//	public static void getMinMaxAge() {
//		ODB odb = ODBFactory.open("equipos.db");
//		
//		Values val1 = odb.getValues(new ValuesCriteriaQuery(Jugador.class).max("edad", "edad_max"));
//		ObjectValues eMax = val1.nextValues();
//		Values val2 = odb.getValues(new ValuesCriteriaQuery(Jugador.class).min("edad", "edad_min"));
//		ObjectValues eMin = val2.nextValues();
//		
//		System.out.println("Edad minima: " + eMin.getByAlias("edad_min") + " \nEdad maxima: " + eMax.getByAlias("edad_max")); 
//		
//		odb.close();
//	}
//	
//	public static void getFrenchOrItalian() {
//		ODB odb = ODBFactory.open("equipos.db");
//		
//		ICriterion crit = new Or()
//				.add(Where.equal("pais.nombrepais", "ITALIA"))
//				.add(Where.equal("pais.nombrepais", "FRANCIA"));
//		
//		CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
//		query.orderByAsc("nombre");
//		
//		Objects<Jugador> jugadores = odb.getObjects(query);
//		for (Jugador j:jugadores) {
//			System.out.println(j); 
//		}
//		
//		odb.close();
//	}
//	
//	public static void getAvgTennisOrMoreThan22() {
//		ODB odb = ODBFactory.open("equipos.db");
//		
//		ICriterion crit = new Or()
//				.add(Where.equal("deporte", "tenis"))
//				.add(Where.gt("edad", 22));
//		
//		CriteriaQuery query = new CriteriaQuery(Jugador.class, crit);
//		Values vals = odb.getValues(new ValuesCriteriaQuery(query)
//				.avg("edad"));
//		
//		System.out.println("Edad media de jugadores de tenis o mayores de 22: " + vals.next().getByIndex(0)); 
//		
//		odb.close();
//	}
}
