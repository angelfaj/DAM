package dao;

import java.util.List;

import modelo.Concesionario;

public interface ConcesionarioDAO {

	List<Object[]> obtenerDatosSedeTodosConcesionarios();

	void save(Concesionario concesionario);

	Concesionario obtenerConcesionarioPorNombreYCiudad(String nombreConcesionario, String ciudad);

	Concesionario getById(Long idConcesionario);

	void update(Concesionario c);

	void delete(Concesionario c);


}
