package ejerciciosIniciales;



/*Crea la clase Coche con dos constructores. Uno no toma parámetros y el otro sí. Los
dos constructores inicializarán los atributos marca y modelo de la clase. Crea dos
objetos (cada objeto llama a un constructor distinto) y verifica que todo funciona
correctamente. */


public class Coche {
		//Atributos
		String marca;
		String modelo;
		
		//Constructores
		public Coche() {
			marca = "Audi";
			modelo = "A3";
		}
		
		public Coche(String mar, String mod) {
			marca = mar;
			modelo = mod;
		}

}
