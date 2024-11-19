package ejerciciosIniciales;

public class Coche {
		//Atributos
		String marca;
		String modelo;
		int velocidad;
		
		//Constructores
		public Coche() {
			marca = "Audi";
			modelo = "A3";
		}
		
		public Coche(String mar, String mod) {
			marca = mar;
			modelo = mod;
		}
		
		
		//Metodos
		public int getVelocidad() {
			return velocidad;
		}
		
		void acelera (int incremento)  {
			velocidad += incremento;
		}
		
		void frena (int decremento) {
			velocidad -= decremento;
		}

}
