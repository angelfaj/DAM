package hojaI;

public class Main {

	public static void main(String[] args) {
		/*Ejercicio 1
		Escribe una clase Multimedia para almacenar información de los objetos
		de tipo multimedia (películas, discos, mp3,mp4...). Esta clase contiene
		título, autor, formato, y duración como atributos. El formato puede ser uno
		de los siguientes: wav, mp3, midi, avi, mov, mpg, cdAudio y dvd. El valor de
		todos los atributos se pasa por parámetro en el momento de crear el
		objeto. Esta clase tiene además, un método para devolver cada uno de los
		atributos y un método toString() que devuelve la información del objeto.
		Por último, un método equals() que recibe un objeto de tipo Multimedia y
		devuelve true en caso de que el título y el autor sean iguales y false en
		caso contrario.
		Escribe una clase Película que herede de la clase Multimedia anterior. La
		clase Película tiene, además de los atributos heredados, un actor principal
		y una actriz principal. Se permite que uno de los dos sea nulo, pero no los
		dos. La clase debe tener dos métodos para obtener los nuevos atributos y
		debe sobreescribir el método toString() para reflejar la nueva información.
		
		Pelicula p = new Pelicula ("Alicia en el pais de las maravillas", "Eminem", Formato.MP3, 12.5, "Elton John", "Madonna");
		
		System.out.println(p);
		
		
		
		
		
		Ejercicio 2
		Escribe una clase ListaMultimedia para almacenar objetos de tipo
		multimedia. La clase debe tener un atributo, que sea un array de objetos
		Multimedia y un entero para contar cuantos objetos hay almacenados.
		Además, tiene los siguientes métodos:
		● El constructor recibe un entero por parámetro indicando el número
		máximo de objetos que va a almacenar.
		● int size(): devuelve el número de objetos que hay en la lista.
		● boolean add(Multimedia m): añade el objeto a la lista y
		devuelve true, en caso de que la lista esté llena, devuelve false.
		● Multimedia get(int position): devuelve el objeto situado en la
		posición especificada.
		● String toString(): devuelve la información de los objetos que están
		en la lista.
		Escribe una aplicación dónde:
		● Se cree un objeto de tipo ListaMultimedia de tamaño 10.
		● Se creen tres películas y se añadan a la lista.
		● Se muestre la lista por pantalla. 
		
		ListaMultimedia listaA = new ListaMultimedia(10);
		Pelicula a = new Pelicula ("Alicia en el pais de las maravillas", "Eminem", Formato.MP3, 12.5, "Elton John", "Madonna");
		Pelicula b = new Pelicula ("Terminator", "Juan Carlos I", Formato.MP3, 12.5, "Paquirrin", "Jordi Hurtado");
		Pelicula c = new Pelicula ("Alguien volo sobre el nido del cuco", "Los chunguitos", Formato.MP3, 12.5, "Papa Noel", "Leticia Sabater");
		
		listaA.add(a);
		listaA.add(b);
		listaA.add(c);
		
		System.out.println(listaA);
		
		
		Ejercicio 3
		Escribe una clase Disco, que herede de la clase Multimedia. La clase Disco
		tiene, aparte de los elementos heredados, un atributo para almacenar el
		género al que pertenece. Los géneros posibles son: rock, pop, soul, funky,
		flamenco, clasica, blues, tecno, opera, punk, jazz, hiphop. La clase debe
		tener un método para obtener el nuevo atributo y debe sobreescribir el
		método toString() para que devuelva toda la información.
		Escribe una aplicación donde:
		● Se cree un objeto de tipo ListaMultimedia de tamaño máximo 20.
		● Se creen tres discos y se añadan a la lista.
		● Se muestre la lista por pantalla.● Se cree un objeto de tipo Disco, introduciendo el título y el autor de
		uno de los elementos de la lista. Para el resto de los argumentos se
		utilizan valores no significativos.
		
		ListaMultimedia listaB = new ListaMultimedia(20);
		Disco a = new Disco ("Alicia en el pais de las maravillas", "Eminem", Formato.MP3, 12.5, Genero.FUNKY);
		Disco b = new Disco ("Terminator", "Juan Carlos I", Formato.MP3, 12.5, Genero.TECHNO);
		Disco c = new Disco ("Alguien volo sobre el nido del cuco", "Los chunguitos", Formato.MP3, 12.5, Genero.CLASICA);
		
		listaB.add(a);
		listaB.add(b);
		listaB.add(c);
		
		System.out.println(listaB);
		
		Disco d = new Disco (listaB.get(0).getTitulo(), listaB.get(0).getAutor(), Formato.MP3, 12.5, Genero.CLASICA);
		listaB.add(d);
		
		
		
		Ejercicio 6
		Se pretende realizar una aplicación para esta facultad que gestione la
		información sobre las personas vinculadas con la misma, que se pueden
		clasificar en tres tipos: estudiantes, profesores y personal de servicio. A
		continuación, se detalla qué tipo de información debe gestionar esta
		aplicación:
		● Por cada persona, se debe conocer, al menos, su nombre y apellidos,
		su número de identificación y su estado civil.
		● Con respecto a los empleados, sean del tipo que sean, hay que
		saber su año de incorporación a la facultad y qué número de
		despacho tienen asignado.
		● En cuanto a los estudiantes, se requiere almacenar el curso en el
		que están matriculados.
		● Por lo que se refiere a los profesores, es necesario gestionar a qué
		departamento pertenecen (lenguajes, matemáticas, arquitectura,
		...).
		● Sobre el personal de servicio, hay que conocer a qué sección están
		asignados (biblioteca, decanato, secretaría, ...).
		El ejercicio consiste, en primer lugar, en definir la jerarquía de clases de
		esta aplicación. A continuación, debe programar las clases definidas en las
		que, además de los constructores, hay que desarrollar los métodos
		correspondientes a las siguientes acciones:
		●
		●
		●
		●
		●
		●
		Cambio del estado civil de una persona.
		Reasignación de despacho a un empleado.
		Matriculación de un estudiante en un nuevo curso.
		Cambio de departamento de un profesor.
		Traslado de sección de un empleado del personal de servicio.
		Imprimir toda la información de cada tipo de individuo.
		Incluya un programa de prueba que instancie objetos de los distintos tipos
		y pruebe los métodos desarrollados.
		
		
		Persona persona1 = new Persona("Pepe", "Perez", "Villanueva", "123456789B", Estado.SOLTERO);
		Empleado empleado1= new Empleado("Manolo", "Perez", "Villanueva", "123456789B", Estado.SOLTERO, 1, 1);
		Estudiante estudiante1 = new Estudiante("Lucas", "Perez", "Villanueva", "123456789B", Estado.SOLTERO, "Primero");
		Profesor profesor1 = new Profesor("Laura", "Perez", "Villanueva", "123456789B", Estado.SOLTERO, 1, 1, Departamento.ARQUITECTURA);
		Personal empleado2= new Personal("Marta", "Perez", "Villanueva", "123456789B", Estado.SOLTERO, 1, 1, Seccion.BIBLIOTECA);
		
		persona1.setEstado(Estado.CASADO);
		
		empleado1.setNumeroDespacho(4);
		estudiante1.setCurso("Segundo");
		profesor1.setDepartamento(Departamento.FISICA);
		empleado2.setSeccion(Seccion.AULAS);
		
		System.out.println(persona1);
		System.out.println(empleado1);
		System.out.println(estudiante1);
		System.out.println(profesor1);
		System.out.println(empleado2);

		 
		
		 Amplíe el ejercicio anterior creando una clase Universidad cuyo atributo
		será un array de 8 posiciones donde se almacenarán objetos de tipo
		Persona. Almacena en las posiciones 0, 1 y 6 objetos Profesor, en lasposiciones 2, 3 y 7 objetos Estudiante y en el resto de posiciones objetos
		PersonalServicios.
		A continuación, implementa los siguientes métodos en la clase
		Universidad:
		● cambiarCurso (dni, nuevoCurso): cambiará el curso a un Estudiante.
		Si el dni no existe o no pertenece a un estudiante, se devuelve false
		(true en caso contrario).
		departamento):
		cambiará
		el
		● cambiarDepartamento(dni,
		departamento a un Profesor. Si el dni no existe o no pertenece a un
		profesor, se devuelve false (true en caso contrario).
		● cambiarSeccion(dni, seccion): cambiará la seccion a un Personal de
		Servicios. Si el dni no existe o no pertenece a un personal de
		servicios, se devuelve false (true en caso contrario).
		● listarEmpleados(): mostrará los empleados que trabajan en la
		Universidad.
		mostrará
		los
		● listarProfesoresDepartamento(departamento):
		profesores que pertenezcan al departamento pasado como
		parámetro.
		Implementa una clase de prueba para probar la clase Universidad y sus
		métodos.
		 */
		
		
		Estudiante estudiante1 = new Estudiante("Carla", "Perez", "Villanueva", "123456789B", Estado.SOLTERO, "Primero");
		Estudiante estudiante2 = new Estudiante("Lucas", "Perez", "Villanueva", "456789B", Estado.SOLTERO, "Primero");
		Estudiante estudiante3 = new Estudiante("Paco", "Perez", "Villanueva", "23456789B", Estado.SOLTERO, "Primero");
		Profesor profesor1 = new Profesor("Laura", "Perez", "Villanueva", "1234589B", Estado.SOLTERO, 1, 1, Departamento.ARQUITECTURA);
		Profesor profesor2 = new Profesor("Maria", "Perez", "Villanueva", "1234567B", Estado.SOLTERO, 1, 1, Departamento.ARQUITECTURA);
		Profesor profesor3 = new Profesor("Ramon", "Perez", "Villanueva", "12345679B", Estado.SOLTERO, 1, 1, Departamento.ARQUITECTURA);
		Personal empleado1 = new Personal("Ines", "Perez", "Villanueva", "123489B", Estado.SOLTERO, 1, 1, Seccion.BIBLIOTECA);
		Personal empleado2 = new Personal("Pepe", "Perez", "Villanueva", "12345B", Estado.SOLTERO, 1, 1, Seccion.BIBLIOTECA);
		
		
		Universidad.fillUniversidad(estudiante1);
		Universidad.fillUniversidad(estudiante2);
		Universidad.fillUniversidad(estudiante3);
		Universidad.fillUniversidad(profesor1);
		Universidad.fillUniversidad(profesor2);
		Universidad.fillUniversidad(profesor3);
		Universidad.fillUniversidad(empleado1);
		Universidad.fillUniversidad(empleado2);
		
		Universidad.cambiarCurso("123456789B", "segundo");
		Universidad.cambiarDepartamento("1234567B", Departamento.BIOLOGIA);
		Universidad.cambiarSeccion("12345B", Seccion.JARDIN);
		Universidad.listarEmpleado();
		System.out.println();
		System.out.println("***********************UNI COMPLETA***********************");
		Universidad.showUni();
		System.out.println();
		System.out.println();
		
		Universidad.listarProfesoresDepartamento(Departamento.BIOLOGIA);
 	}

}
