package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventoDAO {
	
	public int addEventoGeneral(EventoModel evento) {
		int filasModificadas = 0;
		String sql = "INSERT INTO reserva(nombre, telefono, fecha, numero_personas, tipo_evento, cocina) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = Database.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, evento.getNombre());
	            ps.setString(2, evento.getTelefono());
	            ps.setString(3, evento.getFecha());
	            ps.setInt(4, evento.getnPersonas());
	            ps.setString(5, evento.getTipoEvento());
	            ps.setString(6, evento.getCocina());
	            
	            filasModificadas = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return filasModificadas;
	}
	
	public int addEventoCongreso(EventoModel evento) {
		int filasModificadas = 0;
		String sql = "INSERT INTO reserva(nombre, telefono, fecha, numero_personas, tipo_evento, cocina, dias, habitacion) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = Database.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, evento.getNombre());
			ps.setString(2, evento.getTelefono());
			ps.setString(3, evento.getFecha());
			ps.setInt(4, evento.getnPersonas());
			ps.setString(5, evento.getTipoEvento());
			ps.setString(6, evento.getCocina());
			ps.setInt(7, evento.getnDias());
			ps.setString(8, evento.getHabitacion());
			
			filasModificadas = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return filasModificadas;
	}
	
	public ArrayList<EventoModel> getEventosGuardados() {
		ArrayList<EventoModel> eventosList = new ArrayList<EventoModel>();
		String sql = "SELECT nombre, telefono, fecha, numero_personas, tipo_evento, cocina, dias, habitacion FROM reserva";
		
		try (Connection conn = Database.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EventoModel e = new EventoModel();
				e.setNombre(rs.getString(1));
				e.setTelefono(rs.getString(2));
				e.setFecha(rs.getString(3));
				e.setnPersonas(rs.getInt(4));
				e.setTipoEvento(rs.getString(5));
				e.setCocina(rs.getString(6));
				e.setnDias(rs.getInt(7));
				e.setHabitacion(rs.getString(8));
				eventosList.add(e);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return eventosList;
	}
	
	public int deleteAllEventos() {
		int filasModificadas = 0;
		String sql = "TRUNCATE TABLE reserva";
		
		try (Connection conn = Database.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			filasModificadas = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return filasModificadas;
	}
}
