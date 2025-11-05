package model;

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

	@Override
	public String toString() {
		return "[" + nombre + ":" + telefono + ":" + fecha + ":"
				+ tipoEvento + ":" + cocina + ":" + habitacion + ":" + nPersonas
				+ ":" + nDias + "]";
	}
	
}
