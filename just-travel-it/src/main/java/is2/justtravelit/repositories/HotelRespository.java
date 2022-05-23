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
public interface HotelRespository extends CrudRepository<Hotel, Long> {

    /**
     * Borra el hotel dado un código de referencia
     * 
     * @param id ID del hotel a borrar
     */
    void deleteById(Long id);

}
