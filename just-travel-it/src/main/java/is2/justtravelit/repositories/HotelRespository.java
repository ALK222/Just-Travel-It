package is2.justtravelit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import is2.justtravelit.entities.Hotel;

@Repository
public interface HotelRespository extends CrudRepository<Hotel, Long> {

    void deleteById(Long id);

}
