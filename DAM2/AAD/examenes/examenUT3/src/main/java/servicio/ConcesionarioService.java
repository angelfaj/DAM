package servicio;

import modelo.Concesionario;
import modelo.Sede;
import modelo.Coche;

public interface ConcesionarioService {
    
    // 2.1 Insertar
    void guardarConcesionarioCompleto(Concesionario concesionario, Sede sede, Coche c1, Coche c2);

    // 2.2 Consultar
    void mostrarDatosSedeTodosConcesionarios();
    void mostrarConcesionarioPorNombreYCiudad(String nombreConcesionario, String ciudad);
    
    // 2.3 Actualizar
    void modificarNombre(Long idConcesionario, String nuevoNombre);
    
    // 2.4 Eliminar
    void eliminarConcesionario(Long idConcesionario);
}