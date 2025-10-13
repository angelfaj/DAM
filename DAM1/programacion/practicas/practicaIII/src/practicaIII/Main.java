package practicaIII;

public class Main {

	public static void main(String[] args) {
		

        // Registrar estudiantes
        RegistroCalificaciones.registrarEstudiante(1, "Juan", new double[]{8.5, 7.8, 9.0});
        RegistroCalificaciones.registrarEstudiante(2, "María", new double[]{9.5, 8.2, 9.8});
        RegistroCalificaciones.registrarEstudiante(3, "Pedro", new double[]{6.5, 7.0, 6.8});
        RegistroCalificaciones.registrarEstudiante(4, "Pedro", new double[]{7.2, 6.8, 7.5});
        RegistroCalificaciones.registrarEstudiante(4, "Ana", new double[]{8.0, 8.0, 8.0});
        RegistroCalificaciones.registrarEstudiante(5, "Luis", new double[]{7.2, 6.8, 7.5});
        

        // Calcular promedios
        RegistroCalificaciones.calcularPromedios();
        
        // Mostrar información
        System.out.println("\n=== Mostrar Información antes de ordenar ===");
        RegistroCalificaciones.mostrarInformacion();

        // Ordenar estudiantes con promedio mayor a 8
        RegistroCalificaciones.ordenarEstudiantesConPromedioMayorA8();

        // Buscar un estudiante por ID
        System.out.println("\n=== Buscar Estudiantes ===");
        System.out.println(RegistroCalificaciones.buscarEstudiantePorId(2)); // Ejemplo para ID 2
        System.out.println(RegistroCalificaciones.buscarEstudiantePorId(1)); // Ejemplo para ID 1

        // Mostrar información
        System.out.println("\n=== Mostrar Información después de ordenar===");
        RegistroCalificaciones.mostrarInformacion();
        
    }

}
