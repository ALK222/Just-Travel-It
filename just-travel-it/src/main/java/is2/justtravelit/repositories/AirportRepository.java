package is2.justtravelit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import is2.justtravelit.entities.Airport;

public interface AirportRepository extends CrudRepository<Airport,Integer>{
    List<Airport> findAll();
}
