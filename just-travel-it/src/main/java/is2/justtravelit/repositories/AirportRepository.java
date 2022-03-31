package is2.justtravelit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import is2.justtravelit.entities.Airport;

@Repository
public interface AirportRepository extends CrudRepository<Airport,Integer>{
    List<Airport> findAll();

    void deleteByCod(String cod);

    Airport findByCod(String cod);
    
}
