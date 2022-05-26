package is2.justtravelit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import is2.justtravelit.entities.Hotel;

/**
 * Repositorio de hotels para las operaciones en la base de datos
 * 
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.stereotype.Repository
 * @see Hotel
 */
@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
    /**
     * Borra un hotel de la base de datos dado un código
     * 
     * @param cod Código del hotel a borrar
     */
    void deleteByCod(String cod);

    /**
     * Busca un hotel dado un código en la base de datos
     * 
     * @param cod Código del hotel a buscar
     * @return Aeropuerto buscado
     */
    Hotel findByCod(String cod);

    /**
     * Comprueba la existencia de un vuelo dado un código
     * 
     * @param cod Código del vuelo a comprobar
     * @return Existe o no existe
     */
    boolean existsByCod(String cod);

}
