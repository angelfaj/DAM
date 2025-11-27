package app.ejercicio1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    	
    	/*1. Gestión de Empleados
		Diseña una aplicación que permita gestionar empleados, incluyendo las
		operaciones CRUD (crear, leer, actualizar y eliminar). Cada empleado debe tener
		un ID único, nombre, departamento y salario. Los datos deben ser persistidos en
		una tabla de Oracle utilizando Hibernate.
		Para probar las operaciones realiza un menú de consola como el siguiente:
		Gestión de Empleados
		1. Crear Empleado
		2. Leer Empleado
		3. Actualizar Empleado
		4. Eliminar Empleado
		0. Salir*/
    	
    	boolean continuar = true;
    	Scanner sc = new Scanner(System.in);
    	Modelo m = new Modelo();
    	String nombre, dept;
    	int id;
    	double salario;
    	
    	do {
    		mostrarMenu();
    		int op = sc.nextInt();
    		sc.nextLine();
    		
    		switch (op) {
			case 1:						//Crear
				System.out.print("Nombre del nuevo empleado: ");
				nombre = sc.nextLine();
				System.out.print("Departamento del nuevo empleado: ");
				dept = sc.nextLine();
				System.out.print("Salario del nuevo empleado: ");
				salario = sc.nextDouble();
				sc.nextLine();
				
				m.inserta(new Empleado(nombre, dept, salario));
				
				break;
			case 2:						//Leer
				System.out.print("Id del empleado a buscar: ");
				id = sc.nextInt();
				sc.nextLine();
				
				System.out.println(m.buscar(id));
				break;
			case 3:						//Actualizar
				System.out.print("Id del empleado a actualizar: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.print("Nuevo departamento del empleado: ");
				dept = sc.nextLine();
				System.out.print("Nuevo salario del empleado: ");
				salario = sc.nextDouble();
				sc.nextLine();
				
				m.actualiza(new Empleado(id, dept, salario));
				
				break;
			case 4:						//Eliminar
				System.out.print("Id del empleado a eliminar: ");
				id = sc.nextInt();
				sc.nextLine();
				
				m.borrar(m.buscar(id));
				
				break;
			case 0:
				System.out.println("Fin del programa. Adiós!");
				continuar = false;
				break;
			}
    	}while (continuar);
    	
    	sc.close();
    	
    	
    }
    
    private static void mostrarMenu() {
    	System.out.print("========MENÚ========\r\n"
    			+ "1. Crear Empleado\r\n"
    			+ "2. Leer Empleado\r\n"
    			+ "3. Actualizar Empleado\r\n"
    			+ "4. Eliminar Empleado\r\n"
    			+ "0. Salir\r\n"
    			+ "Introduce una opción: ");
    }
}
