package practicaIII;
import java.util.*;

//Ya que solo vamos a hacerlo una vez hemos decidido hacer todo estatico
public class RegistroCalificaciones {
	private static double calificacionesEstudiante[][] = new double [3][5];
	private static Estudiante estudiantes[] = new Estudiante[5];
	private static HashMap<String, Double> mediaEstudiante = new HashMap<String, Double>();
	private static ArrayList<Estudiante> estudiantesNotables = new ArrayList<Estudiante>();
	
    public static void registrarEstudiante(int id, String nombre, double[] calificaciones) {
    	
    	Estudiante e = new Estudiante(id, nombre, calificaciones);
    	int posicion = -1;
    	String nombreAux = nombre;
    	boolean encontrado = false;
    	boolean primeraPos = false;
    	for (int i = 0; i < estudiantes.length; i++) {  		//Guardamos los estudiantes en el vector
    		if (estudiantes[i] == null) {
    			if (!primeraPos) {								//Nos quedamos con la primera posicion libre
    				posicion = i;
    				primeraPos = true;    				
    			}
    		}else if (estudiantes[i].getNombre().equalsIgnoreCase(nombreAux) && !encontrado){
    			encontrado = true;
    			System.out.println("El estudiante con el nombre " + nombre + " ya esta registrado.");
    		}
    	}
    	if (!encontrado) {
    		estudiantes[posicion] = e;
    		System.out.println("Estudiante registrado con éxito");
	    	boolean continuar;
	    	for (double d:calificaciones) {		//Solo si no esta repetido guardamos calificaciones en la matriz, cada fila es un alumno
	    		continuar = true;
	    		for (int i = 0; i < calificacionesEstudiante.length && continuar; i++) {
	    			for (int j = 0; j < calificacionesEstudiante[i].length && continuar; j++) {
	    				if (calificacionesEstudiante[i][j] == 0.0) {
	    					calificacionesEstudiante[i][j] = d;
	    					continuar = false;
	    				}
	    			}
	    		}
	    	}
    	}
    	
    }

    
    public static void calcularPromedios() {
        double promedio;
    	for (Estudiante e:estudiantes) {
        	promedio = 0;
    		double calificaciones[] = e.getCalificaciones();
        	for (double d:calificaciones) {
        		promedio += d;
        	}
        	promedio /= calificaciones.length;
        	mediaEstudiante.put(e.getNombre(), promedio);
        	
        	if (promedio >= 8 && !estudiantesNotables.contains(e)) {		//Comprobamos si existe y si tiene media > 8 lo metemos
        		estudiantesNotables.add(e);        			
        	}
        }
    	
    }

    
    public static void ordenarEstudiantesConPromedioMayorA8() {
       Collections.sort(estudiantesNotables);
    }

    public static String buscarEstudiantePorId(int id) {
    	String posicionNombre = "";
    	boolean encontrado = false;
    	Iterator<Estudiante> it = estudiantesNotables.iterator();
    	int i = -1;
    	while (it.hasNext() && !encontrado) {
    		i++;
    		Estudiante e = it.next();
    		if (e.getId() == id) {
    			posicionNombre += "Posición: " + i + ", Nombre: " + e.getNombre();
    			
    			encontrado = true;
    		}
    	}
    	return posicionNombre;
    }


    public static void mostrarInformacion() {
       System.out.println("=== Información de los estudiantes ===");
       for (int i = 0; i < estudiantes.length; i++) {
    	   System.out.println("ID: " + estudiantes[i].getId() +", Nombre: " + estudiantes[i].getNombre() 
    			   +", Calificaciones:" + getCalificaciones(estudiantes[i]) + 
    			   ", Promedio: " + mediaEstudiante.get(estudiantes[i].getNombre()));
       }
       
       System.out.println("\n" + "=== Estudiantes con promedio mayor o igual a ocho ===");
       for (int i = 0; i < estudiantesNotables.size(); i++) {
    	   System.out.println("ID: " + estudiantesNotables.get(i).getId() +", Nombre: " + estudiantesNotables.get(i).getNombre() 
    			   +", Calificaciones:" + getCalificaciones(estudiantesNotables.get(i)) + 
    			   ", Promedio: " + mediaEstudiante.get(estudiantesNotables.get(i).getNombre()));
       }
    }
    
    public static String getCalificaciones(Estudiante e) {
    	String calificaciones = "";
    	for (double d:e.getCalificaciones()) {
    		calificaciones +=  " " + d;
    	}
    	return calificaciones;
    }

   
}
