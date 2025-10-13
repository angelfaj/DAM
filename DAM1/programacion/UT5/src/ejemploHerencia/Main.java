package ejemploHerencia;

public class Main {

	public static void main(String[] args) {
		
		Persona p1 = new Persona("Pepe", 21);
		Empleado e1 = new Empleado("Juan", 51, 100);
//		Persona e1 = new Empleado("Juan", 51, 100);  Al declararlo de esta forma solo podremos acceder a los metodos de persona
		Empleado e2 = new Empleado("Maria", 40, 300);
		Empleado d1 = new Directivo("Ana", 21, 300, 1);
		
		
		
		System.out.println("El nombre de la persona 1 es: " + p1.getNombre());
		System.out.println("El nombre de la persona 2 es: " + e1.getNombre());
		System.out.println("El nombre de la persona 3 es: " + e2.getNombre());
		System.out.println("El nombre de la persona 4 es: " + d1.getNombre());
		
		System.out.println("El sueldo del empleado 1 es: " + e1.getSueldo());
		System.out.println("El sueldo del empleado 2 es: " + e2.getSueldo());
		System.out.println("El sueldo del empleado 3 es: " + d1.getSueldo());
		
		Empleado.cantar();
		
		System.out.println("Persona 1: " + p1);
		System.out.println("Persona 2: " + e1);
		System.out.println("Persona 3: " + e2);
		System.out.println("Persona 4: " + d1);
	}

}
