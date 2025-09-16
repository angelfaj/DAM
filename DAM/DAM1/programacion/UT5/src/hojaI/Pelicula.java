package hojaI;

public class Pelicula extends Multimedia{
	protected String actorPrincipal;
	protected String actrizPrincipal;
	
	public Pelicula(String titulo, String autor, Formato formato, double duracion, String actorPrincipal, Sexo sexo) {
		super(titulo, autor, formato, duracion);
		if (sexo == Sexo.MASCULINO) {
			this.actorPrincipal = actorPrincipal;			
		} else {
			this.actrizPrincipal = actorPrincipal;						
		}
	}

	public Pelicula(String titulo, String autor, Formato formato, double duracion, String actorPrincipal, String actrizPrincipal) {
		super(titulo, autor, formato, duracion);
		this.actorPrincipal = actorPrincipal;
		this.actrizPrincipal = actrizPrincipal;
	}

	public String getActorPrincipal() {
		return actorPrincipal;
	}

	public void setActorPrincipal(String actorPrincipal) {
		this.actorPrincipal = actorPrincipal;
	}

	public String getActrizPrincipal() {
		return actrizPrincipal;
	}

	public void setActrizPrincipal(String actrizPrincipal) {
		this.actrizPrincipal = actrizPrincipal;
	}

	@Override
	public String toString() {
		return super.toString() + "Pelicula [actorPrincipal=" + actorPrincipal + ", actrizPrincipal=" + actrizPrincipal + "]";
	}
	
	
	
}
