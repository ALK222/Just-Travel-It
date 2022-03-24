package is2.justtravelit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import is2.justtravelit.entities.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    List<Reservation> findAllByUser(String id);
    
}
