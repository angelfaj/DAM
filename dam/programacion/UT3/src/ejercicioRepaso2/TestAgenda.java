package ejercicioRepaso2;

public class TestAgenda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacto maria = new Contacto("Maria", "1234");
		Direccion dirLaura = new Direccion("Via", "Laurel", "5", "28045", "Madrid");
		Contacto laura = new Contacto("Laura", "123456789", dirLaura);
		Agenda agenda1 = new Agenda(maria);
		
		if (maria.comprobarTelefono()) {
			System.out.println("El telefono es correcto");
		} else {
			System.out.println("EL telefono es incorrecto");			
		}
		
		System.out.println("Numero de contactos; " + Agenda.numeroContactos);
		
		agenda1.altaContacto(laura, 2);
		System.out.println("Numero de contactos; " + Agenda.numeroContactos);
		Contacto paco = new Contacto("Paco", "6567680796");
		agenda1.altaContacto(paco, 3);
		System.out.println("Numero de contactos; " + Agenda.numeroContactos);
		System.out.println(agenda1);
		Contacto ramon = new Contacto("ramon", "111222222");
		agenda1.altaContacto(ramon, 4);
		
		System.out.println(agenda1);
		
		agenda1.bajaContacto(3);
		System.out.println("Numero de contactos; " + Agenda.numeroContactos);
		
		
		System.out.println(agenda1.modificaContacto(paco, 3));
		System.out.println(agenda1.modificaContacto(paco, 2));
	}

}
