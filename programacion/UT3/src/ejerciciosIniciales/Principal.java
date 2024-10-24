package ejerciciosIniciales;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Coche mycar = new Coche();
		Coche yourcar = new Coche("BMW", "Serie3");
		
		System.out.println("Mi coche es un: " + mycar.marca + mycar.modelo + " el tuyo es un: " + yourcar.marca + yourcar.modelo);
	}

}
