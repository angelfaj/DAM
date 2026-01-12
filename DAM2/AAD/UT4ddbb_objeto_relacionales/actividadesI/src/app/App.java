package app;


import dao.AutorDAO;
import dao.DepartamentoDAO;
import dao.EmpleadoDAO;
import dao.LibroDAO;
import model.Autor;
import model.Departamento;
import model.Empleado;
import model.Libro;

public class App {

	public static void main(String[] args) {
		/*EJECRCICIO 1
		Realiza un programa Java que utilice NeoDatis para ejecutar las siguientes operaciones de
		gestión de objetos de la base de datos personal:
		A) Insertar un departamento.
		B) Insertar un empleado.
		C) Visualizar todos los departamentos.
		D) Visualizar todos los empleados, indicando para cada empleado su jefe y su
		departamento. */
		
//		Empleado e = new Empleado(10, "Perez");
//		Departamento d = new Departamento(10, "Ventas", "Madrid");
//		
//		DepartamentoDAO.addDepartamento(d);
//		EmpleadoDAO.addEmpleado(e);
//		
//		DepartamentoDAO.getAllDepartamentos();
//		EmpleadoDAO.getAllEmpleados();
		
		/*EJERCICIO 2
		Realiza un programa Java que utilice NeoDatis para ejecutar las siguientes operaciones de
		gestión de objetos de la base de datos biblioteca:
		A) Insertar un libro, sin especificar ningún autor.
		B) Insertar un autor, sin especificar ningún libro.
		C) Modificar un libro para añadirle un autor existente de la base de datos.
		D) Modificar un autor para añadirle un libro existente de la base de datos.
		E) Visualizar todos los libros.
		F) Visualizar todos los autores. */
//
//		Libro l = new Libro("Mil maneras de morir", 2010, "MTV", 1000);
//		LibroDAO.addLibro(l);
//		LibroDAO.getAllLibros();

//		Autor a = new Autor("Manolo", "Dovstoieski", "Finlandes", 14);
//		AutorDAO.addAutor(a);
//		AutorDAO.getAllAutores();
		
		/*EJERCICIO 3
		Realiza un programa Java que utilice NeoDatis para ejecutar las siguientes consultas sobre la
		base de datos personal:
		A) Obtener los empleados que tienen un salario superior a 1000.
		B) Obtener los empleados nuevos del año 2015. (OPCIONAL)
		C) Obtener los nombres de los empleados del departamento 10.
		D) Obtener los nombres de los empleados cuyo jefe es “Pedro López“.
		E) Obtener el número de empleados del departamento “Ventas”.
		F) Obtener el número de empleados de cada departamento. (OPCIONAL)*/
		
//		EmpleadoDAO.mostrarEmplSalarioMasDeMil();
//		EmpleadoDAO.getEmpleadosFrom2015();
//		EmpleadoDAO.getEmpleadosFromDep10();
//		EmpleadoDAO.getEmpleadosOfPedroLopez();
//		EmpleadoDAO.getNumEmpleadosVentas();
		EmpleadoDAO.getNumEmpleadosPorDep();
		
		/*EJERCICIO 4
		Realiza un programa Java que utilice NeoDatis para ejecutar las siguientes consultas sobre la
		base de datos biblioteca:
		A) Obtener los libros que cuyo número de páginas es mayor que 30.
		B) Obtener los autores de nacionalidad española.
		C) Obtener los títulos y los años de los libros escritos por aquellos autores cuyo apellido
		empieza con la letra S. (OPCIONAL)*/
		
		//BOLETIN 2 0-4
	}

}
