package is2.justtravelit.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import is2.justtravelit.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    User findByName(String name);
    List<User> findAll();
       
}
