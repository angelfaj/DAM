package servicio;

import dao.ConcesionarioDAO;
import dao.ConcesionarioDAOImpl;
import modelo.Concesionario;
import modelo.Sede;
import modelo.Coche;
import java.util.List;

public class ConcesionarioServiceImpl implements ConcesionarioService {
    
    private final ConcesionarioDAO dao = new ConcesionarioDAOImpl(); 

    @Override
    public void guardarConcesionarioCompleto(Concesionario concesionario, Sede sede, Coche c1, Coche c2) {
        try {
            concesionario.setSede(sede);
            concesionario.addCoche(c1);
            concesionario.addCoche(c2);

            dao.save(concesionario);

            System.out.println("✅ Concesionario, Sede y Coches guardados correctamente.");
        } catch (Exception e) {
            System.err.println("❌ Error al guardar datos: " + e.getMessage());
        }
    }

    @Override
    public void mostrarDatosSedeTodosConcesionarios() {
        List<Object[]> resultados = dao.obtenerDatosSedeTodosConcesionarios();
            
        System.out.println("\n--- 2.2.a: Consulta por Navegación de Propiedades ---");
        if (resultados.isEmpty()) {
            System.out.println("No hay concesionarios registrados.");
            return;
        }
        
        for (Object[] fila : resultados) {
            String nombre = (String) fila[0];
            String calle = (String) fila[1];
            String ciudad = (String) fila[2];
            System.out.printf("Concesionario: %s | Ubicado en: %s, %s%n", nombre, calle, ciudad);
        }
    }

    @Override
    public void mostrarConcesionarioPorNombreYCiudad(String nombreConcesionario, String ciudad) {
        Concesionario c = dao.obtenerConcesionarioPorNombreYCiudad(nombreConcesionario, ciudad);
            
        System.out.println("\n--- 2.2.b: Consulta con parámetros dinámicos ---");
        if (c == null) {
            System.out.printf("❌ No se encontró el concesionario '%s' en la ciudad '%s'.%n", nombreConcesionario, ciudad);
            return;
        }
        
        System.out.println("✅ Concesionario encontrado (ID: " + c.getId() + "): " + c.getNombre());
        System.out.println("   Sede: " + c.getSede().getCalle() + ", " + c.getSede().getCiudad());
        System.out.println("   Coches en Stock (" + c.getCoches().size() + "):");
        
        for (Coche coche : c.getCoches()) {
            System.out.println("     - " + coche.getModelo() 
			+ " (" + coche.getMatricula() + ")");
        }

    }

    @Override
    public void modificarNombre(Long idConcesionario, String nuevoNombre) {
        try {
            Concesionario c = dao.getById(idConcesionario); 
            if (c != null) {
                c.setNombre(nuevoNombre);
                dao.update(c); 
                System.out.printf("✅ Concesionario con ID %d actualizado a nombre: %s%n", idConcesionario, nuevoNombre);
            } else {
                System.out.printf("❌ No se encontró el concesionario con ID %d.%n", idConcesionario);
            }
        } catch (Exception e) {
            System.err.println("❌ Error al actualizar nombre: " + e.getMessage());
        }
    }

    @Override
    public void eliminarConcesionario(Long idConcesionario) {
        try {
            Concesionario c = dao.getById(idConcesionario); // Lectura en DAO
            if (c != null) {
                Long sedeId = c.getSede().getId();
                int numCoches = c.getCoches().size();
                    
                dao.delete(c); 

                System.out.printf("✅ Concesionario con ID %d eliminado correctamente.%n", idConcesionario);
                System.out.printf("   ➡️ Se eliminó automáticamente la Sede (ID %d) y %d coches asociados (Verificar en BBDD).%n", sedeId, numCoches);
            } else {
                System.out.printf("❌ No se encontró el concesionario con ID %d.%n", idConcesionario);
            }
        } catch (Exception e) {
            System.err.println("❌ Error al eliminar concesionario: " + e.getMessage());
        }
    }
}