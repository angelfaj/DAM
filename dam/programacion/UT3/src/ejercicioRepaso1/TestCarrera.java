package ejercicioRepaso1;

public class TestCarrera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Corredor usain = new Corredor("Usain Bolt", 33.5);
		Corredor carl = new Corredor("Carl Lewis");
		Carrera singapur = new Carrera(usain, carl);
		
		System.out.println(carl.getNombre());
		System.out.println(singapur.mostrarDatosCorredores());
		System.out.println(singapur.competir());
		System.out.println(singapur.mostrarDatosCorredores());
		
	}

}
