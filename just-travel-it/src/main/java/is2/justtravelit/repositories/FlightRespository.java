package is2.justtravelit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import is2.justtravelit.entities.Flight;

public interface FlightRespository extends CrudRepository<Flight,Integer>{
    List<Flight> findAll();
}
