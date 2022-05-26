package is2.justtravelit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import is2.justtravelit.entities.Airport;

/**
 * Repositorio de aeropuertos para las operaciones en la base de datos
 * 
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.stereotype.Repository
 * @see Airport
 */
@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

    /**
     * Devuelve un listado con todos los aeropuertos
     */
    List<Airport> findAll();

    /**
     * Borra el aeropuerto dado un código de referencia
     * 
     * @param cod Código del aeropuerto a borrar
     */
    void deleteByCod(String cod);

    /**
     * Busca el aeropuerto dado un código de referencia
     * 
     * @param cod Código del aeropuerto a buscar
     * @return Aeropuerto buscado
     */
    Airport findByCod(String cod);

    /**
     * Comprueba la existencia de un aeropuerto dado un código
     * 
     * @param cod Código del aeropuerto a comprobar
     * @return Existe o no existe
     */
    boolean existsByCod(String cod);

}
