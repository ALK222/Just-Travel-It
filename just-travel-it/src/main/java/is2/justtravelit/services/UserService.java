package is2.justtravelit.services;

import java.util.List;

import is2.justtravelit.dtos.UserDTO;

/**
 * Interfaz para el servicio de usuarios
 */
public interface UserService {

    UserDTO userValidation(UserDTO userDTO);

    UserDTO userRegister(UserDTO userDTO);

    List<UserDTO> findAllUsers();

    UserDTO changePassword(UserDTO userDTO);

}
