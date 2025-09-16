package ejercicioRepaso2;

public class Direccion {
	//Atributos
	private String tipoCalle, nombre, numero, portal, piso, puerta, cp, provincia;
	
	//Constructores
	public Direccion(String tipoCalle, String nombre, String numero, String cp, String provincia) {
		this.tipoCalle = tipoCalle;
		this.nombre = nombre;
		this.numero = numero;
		this.cp = cp;
		this.provincia = provincia;
	}
	
	public Direccion(String tipoCalle, String nombre, String numero, String cp, String provincia, String portal, String piso, String puerta) {
		this(tipoCalle, nombre, numero, cp, provincia);
		this.portal = portal;
		this.piso = piso;
		this.puerta = puerta;
	}

	//Metodos
	public String getTipoCalle() {
		return tipoCalle;
	}

	public void setTipoCalle(String tipoCalle) {
		this.tipoCalle = tipoCalle;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPortal() {
		return portal;
	}

	public void setPortal(String portal) {
		this.portal = portal;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Direccion [tipoCalle=" + tipoCalle + ", nombre=" + nombre + ", numero=" + numero + ", portal=" + portal
				+ ", piso=" + piso + ", puerta=" + puerta + ", cp=" + cp + ", provincia=" + provincia + "]";
	}
	
	
	
}
