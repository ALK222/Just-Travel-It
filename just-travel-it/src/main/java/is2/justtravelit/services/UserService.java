package is2.justtravelit.services;

import java.util.List;

import is2.justtravelit.dtos.UserDTO;

public interface UserService {

    UserDTO userValidation(UserDTO userDTO);

    UserDTO userRegister(UserDTO userDTO);

    List<UserDTO> findAllUsers();

    UserDTO changePassword(UserDTO userDTO);

}
