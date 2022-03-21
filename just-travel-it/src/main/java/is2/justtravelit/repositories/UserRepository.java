package is2.justtravelit.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;


import is2.justtravelit.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    User findByName(String name);
    List<User> findAll();
}
