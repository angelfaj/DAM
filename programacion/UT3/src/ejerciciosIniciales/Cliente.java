package ejerciciosIniciales;

public class Cliente {
	public String nombre, direccion, nif; 	
		//Constructores
		public Cliente(String nom, String dir, String id) {
			nombre = nom;
			direccion = dir;
			nif = id;
		}
		
		//Metodos
		public String getClientNif() {		
			return nif;
		}
}
