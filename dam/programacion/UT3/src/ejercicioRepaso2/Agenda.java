package ejercicioRepaso2;

public class Agenda {
	//Atributos
	public static int numeroContactos;
	private Contacto c1, c2, c3;
	
	//Constructores
	public Agenda(Contacto contacto1) {
		this.c1 = contacto1;
		numeroContactos++;
	}
	
	public Agenda(Contacto contacto1, Contacto contacto2) {
		this(contacto1);
		this.c2 = contacto2;
		numeroContactos++;
	}
	
	public Agenda(Contacto contacto1, Contacto contacto2, Contacto contacto3) {
		this(contacto1, contacto2);
		this.c3 = contacto3;
		numeroContactos++;
	}
	
	//Metodos
	public void altaContacto(Contacto c, int i) {
		if (numeroContactos < 3) {
			switch(i) {
			case 1:
				this.c1 = c;
				break;
			case 2:
				this.c2 = c;
				break;
			case 3:
				this.c3 = c;
				break;
			}
			numeroContactos++;		
		} else {
			System.out.println("La agenda está completa, no se añadira este contacto");
		}
		
	}
	
	public void bajaContacto(int i) {
		switch(i) {
			case 1:
				this.c1 = null;
				break;
			case 2:
				this.c2 = null;
				break;
			case 3:
				this.c3 = null;
				break;
		}
		numeroContactos--;
	}
	
	public String modificaContacto(Contacto c, int i) {
		String operacion = "";
		
		switch(i) {
		case 1:
			if (c1 == null) {
				operacion = "NO se ha realizado la operación";
				return operacion;
			} else {
				this.c1 = c;				
			}
			break;
		case 2:
			if (c2 == null) {
				operacion = "NO se ha realizado la operación";
				return operacion;
			} else {
				this.c2 = c;				
			}
			break;
		case 3:
			if (c3 == null) {
				operacion = "NO se ha realizado la operación";
				return operacion;
			} else {
				this.c3 = c;				
			}
			break;
		}
		operacion = "SI se ha realizado la operacion";
		return operacion;
	}

	@Override
	public String toString() {
		return "Agenda [c1=" + c1 + ", c2=" + c2 + ", c3=" + c3 + "]";
	}
	
	
}
