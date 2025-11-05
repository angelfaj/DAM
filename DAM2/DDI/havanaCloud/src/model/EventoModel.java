package model;

import java.util.ArrayList;

public class EventoModel {
	private String nombre, telefono, fecha, tipoEvento, cocina, habitacion;
	private int nPersonas, nDias;
	
	public EventoModel() {}

	public EventoModel(String nombre, String telefono, String fecha, int nPersonas, String tipoEvento, String cocina) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.fecha = fecha;
		this.nPersonas = nPersonas;
		this.tipoEvento = tipoEvento;
		this.cocina = cocina;
	}
	
	public EventoModel(String nombre, String telefono, String fecha, int nPersonas, String tipoEvento, String cocina, int nDias, String habitacion) {
		this(nombre, telefono, fecha, nPersonas, tipoEvento, cocina);
		this.nDias = nDias;
		this.habitacion = habitacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getCocina() {
		return cocina;
	}

	public void setCocina(String cocina) {
		this.cocina = cocina;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}

	public int getnPersonas() {
		return nPersonas;
	}

	public void setnPersonas(int nPersonas) {
		this.nPersonas = nPersonas;
	}

	public int getnDias() {
		return nDias;
	}

	public void setnDias(int nDias) {
		this.nDias = nDias;
	}

	public String[] getEventoArray(int posicion) {	//Metodo auxiliar que devuelve un String[] de un EventoModel contenido en el ArrayList 
		ArrayList<EventoModel> listaEventos = EventoDAO.getEventosGuardadosList(); 
		String[] eventoArreglo = new String[8];
			
		EventoModel evento = listaEventos.get(posicion);
		eventoArreglo[0] = evento.getNombre();
		eventoArreglo[1] = evento.getTelefono();
		eventoArreglo[2] = evento.getFecha();
		eventoArreglo[3] = evento.getnPersonas() + "";
		eventoArreglo[4] = evento.getTipoEvento();
		eventoArreglo[5] = evento.getCocina();
		eventoArreglo[6] = evento.getnDias()+ "";
		eventoArreglo[7] = evento.getHabitacion();
		
		return eventoArreglo;
	}
	
	public String[][] getEventoMatriz() throws ClassNotFoundException{
		ArrayList<EventoModel> listaEventos = EventoDAO.getEventosGuardadosList(); 
		String[][] matriz = new String[listaEventos.size()][8];
		
		for (int i = 0; i < matriz.length; i ++) {
			matriz[i] = getEventoArray(i); 
		}
		
		return matriz;
	}
	
	@Override
	public String toString() {
		return "[" + nombre + ":" + telefono + ":" + fecha + ":"
				+ tipoEvento + ":" + cocina + ":" + habitacion + ":" + nPersonas
				+ ":" + nDias + "]";
	}
	
}
