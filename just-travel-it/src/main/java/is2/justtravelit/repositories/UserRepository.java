package is2.justtravelit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import is2.justtravelit.entities.User;

/**
 * Repositorio de usuarios para las operaciones en la base de datos
 * 
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.stereotype.Repository
 * @see User
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * Devuelve un usuario dado un nombre
     * 
     * @param name Nombre del usuario a buscar
     * @return Entity del usuario con todos sus datos
     */
    User findByName(String name);

    /**
     * Devuelve un listado con todos los usuarios de la aplicación
     */
    List<User> findAll();

}
