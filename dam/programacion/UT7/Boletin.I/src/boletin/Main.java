package boletin;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		/*1. Conéctate a la base de datos y muestra los datos de todos los clientes del taller.
		Estructura el código en métodos que te permitan reutilizarlos posteriormente.*/
		
		
//		try {
//			GestorBbdd.conectar();
//			GestorBbdd.showAllFromTaller();
//			GestorBbdd.cerrar();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		

		/*2. Realiza un método que inserte un cliente en la tabla clientes_taller y muestre de
		nuevo los resultados para comprobar que se ha insertado correctamente. Los datos
		del nuevo cliente serán:
		a. ncliente = 7
		b. nombre = ROBERTO URDIALES
		c. dirección = GRAN VIA, 17
		d. teléfono= 698741256
		e. fecha_alta= 2012/10/10
		NOTA: ojo con las comillas y con el formato de la fecha
		NOTA2: utiliza parámetros de E/S en el método para hacerlo más flexible.
		*/
		
		
//		try {
//			GestorBbdd.conectar();
//			GestorBbdd.insertIntoTaller(12, "ROBERTO URDIALES", "GRAN VIA, 17", "698741256", Date.valueOf("2012-10-10"));
//			GestorBbdd.showAllFromTaller();
//			GestorBbdd.cerrar();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		

		/*3. Haz un método para borrar un cliente de la BD y pruébalo para borrar el cliente
		insertado anteriormente. Utiliza parámetros de E/S en el método para hacerlo más
		flexible.*/
	
//		try {
//			GestorBbdd.conectar();
//			GestorBbdd.deleteFromTaller(8);
//			GestorBbdd.showAllFromTaller();
//			GestorBbdd.cerrar();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	
		/*
		4. Haz un método que actualice la dirección de un cliente. Pruébalo con el cliente
		número 6, de tal forma que la nueva dirección será ESQUINA, 77.
		*/
		
//		try {
//			GestorBbdd.conectar();
//			GestorBbdd.updateDirFormTaller("ESQUINA, 77", 7);
//			GestorBbdd.showAllFromTaller();
//			GestorBbdd.cerrar();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		/*
		5. Vuelve a insertar al cliente del ejercicio 2 llamando al método realizado
		anteriormente. A continuación, modifica el ejercicio 3 para que ahora el valor del
		cliente a borrar se introduzca mediante una consulta preparada en lugar de meter el
		valor manualmente. Comprueba que funciona.
		 */
		
		
		/*
		6. Modifica el ejercicio 4 para que la funcionalidad sea la misma pero utilizando una
		consulta preparada. En este caso, el valor que pondremos en la dirección será
		ESQUINA, 76.*/
		
		
	}
}
