package estructurasDinamicas;

public class Coche implements Comparable<Object>{
	//Atributos
	private String propietario;
	private String matricula;
	private String marca;
	private boolean reparado;
	
	//Constructores 
	public Coche(String prop, String mat, String marc) {
		propietario = prop;
		matricula = mat;
		marca = marc;
		reparado = false;
	}
	
	//Metodos
	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isReparado() {
		return reparado;
	}

	public void setReparado(boolean reparado) {
		this.reparado = reparado;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass().equals(this.getClass())) {
			Coche c = (Coche) o;
			if (this.getMatricula().equals(c.getMatricula())) {
				return true;				
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Object o) {
		Coche c = (Coche) o;
		if (this.getMarca().equals(c.getMarca())) {
			return this.getMatricula().compareTo(c.getMatricula());
		} else {
			return this.getMarca().compareTo(c.getMarca());
		}
	}
	
	
}
