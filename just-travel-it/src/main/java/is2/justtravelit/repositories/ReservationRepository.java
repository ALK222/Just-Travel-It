package is2.justtravelit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import is2.justtravelit.entities.Reservation;

/**
 * Repositorio de reservas para las operaciones en la base de datos
 * 
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.stereotype.Repository
 * @see Reservation
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    /**
     * Devuelve un listado de reservas hechas por un usuario
     * 
     * @param id ID del usuario
     * @return Listado de todas las reservas del usuario
     */
    List<Reservation> findAllByUser(String id);

}
