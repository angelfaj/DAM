package ejerciciosInicialesv2;

public class Persona {
	//Atributos
	private String nombre, dni;
	private int edad;
	private double peso, altura;
	private char sexo = 'H';
	private final char HOMBRE= 'H', MUJER = 'M';
	
	//Constructores
	Persona() {
	
	}
	Persona(String dn) {
		dni = dn;
	}
	
	Persona(String nom, int ed, char s) {
		nombre = nom;
		edad = ed;
		sexo = comprobarSexo(s);
	}
	
	Persona(String nom, String dn, int ed, char s, double pes, double alt) {
		this(nom, ed, s);
		dni = dn;
		peso = pes;
		altura = alt;
	}
	
	//Metodos
	public void setNombre(String nom) {
		nombre = nom;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setDni(String dn) {
		dni = dn;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setEdad(int ed) {
		edad = ed;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setPeso(double pes) {
		peso = pes;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setAltura(double alt) {
		altura = alt;
	}
	
	public void setSexo(char s) {
		sexo = s;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public int calcularIMC() {
		int valor = 2;
	
		 if ((peso/(altura * altura)) < 20) {
			 valor = -1;
		 } else if (((peso/(altura * altura)) >= 20) && ((peso/(altura * altura)) <= 25)){
			 valor = 0;
		 } else if ((peso/(altura * altura)) > 25) {
			 valor = 1;
		 }
		 
		return valor;
	}
	
	public boolean esMayorDeEdad() {
		boolean esMayor = false;
		if (edad >= 18) {
			esMayor = true;
		}
		return esMayor;
	}
	
	private char comprobarSexo(char sex) {
		if (sexo != sex) {
			sexo = 'H';
		}
		return sexo;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", peso=" + peso + ", altura=" + altura
				+ ", sexo=" + sexo + ", HOMBRE=" + HOMBRE + ", MUJER=" + MUJER + "]";
	}
	
	
	//Reemplazar este equals para que sobeescriba el equals por defecto usando this e instanceof
	public boolean equals(Persona p1, Persona p2) {
		boolean iguales = false;
		if (p1.equals(p2)) {
			iguales = true;
		}
		return iguales;
	}
	
}
