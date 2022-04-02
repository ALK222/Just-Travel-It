package is2.justtravelit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import is2.justtravelit.entities.Flight;

@Repository
public interface FlightRespository extends CrudRepository<Flight,Integer>{
    List<Flight> findAll();
}
