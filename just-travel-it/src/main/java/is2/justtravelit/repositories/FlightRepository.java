package is2.justtravelit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import is2.justtravelit.entities.Flight;

/**
 * Repositorio de vuelos para las operaciones en la base de datos
 * 
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.stereotype.Repository
 * @see Flight
 */
@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    /**
     * Devuelve un listado con todos los vuelos
     */
    List<Flight> findAll();

    /**
     * Borra el vuelo dado un código de referencia
     * 
     * @param id ID del vuelo a borrar
     */
    void deleteById(Long id);

    /**
     * Comprueba la existencia de un vuelo dado un código
     * 
     * @param codigo Código del vuelo a comprobar
     * @return Existe o no existe
     */
    boolean existsByCodigo(String codigo);

    void deleteByCodigo(String codigo);
}
