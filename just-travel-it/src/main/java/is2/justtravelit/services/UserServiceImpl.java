package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is2.justtravelit.dtos.UserDTO;
import is2.justtravelit.entities.User;
import is2.justtravelit.mappers.UserDTOToEntityMapper;
import is2.justtravelit.mappers.UserEntityToDTOMapper;
import is2.justtravelit.repositories.UserRepository;

/**
 * Servicio de usuarios
 * 
 * @see UserService
 * @see org.springframework.stereotype.Service
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Validación de usuarios
     * 
     * @param userDTO usuario a validar
     * @return Usuario con solo su nombre o NULL si no se consigue validar
     * @see UserDTO
     * @see User
     * @see UserRepository
     */
    @Override
    public UserDTO userValidation(UserDTO userDTO) {

        User user = userRepository.findByName(userDTO.getName());
        if (user != null) {
            if (userDTO.getPassword().equals(user.getPassword())) {
                return new UserDTO(user.getName());
            }
        }

        return null;

    }

    /**
     * Registro de un usuario nuevo
     * 
     * @param userDTO Usuario a registrar
     * @return UserDTO con solo el nombre del usuario o NULL si no se consigue
     *         registrar
     * @see UserDTO
     * @see UserDTOToEntityMapper
     * @see UserRepository
     */
    @Override
    public UserDTO userRegister(UserDTO userDTO) {
        if (userRepository.findByName(userDTO.getName()) == null) {
            userRepository.save(UserDTOToEntityMapper.mapUserDTOToUser(userDTO));
            return new UserDTO(userDTO.getName());
        }

        return null;

    }

    /**
     * Devuelve un listado con todos los usuarios de la aplicación
     * 
     * @return Listado con todos los usuarios
     * @see UserDTO
     * @see UserRepository
     * @see UserEntityToDTOMapper
     */
    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> response = new ArrayList<UserDTO>();
        for (User user : userRepository.findAll()) {
            response.add(UserEntityToDTOMapper.mapUserEntityToUserDTO(user));
        }

        return response;

    }

    /**
     * Cambia la contraseña de un usuario
     * 
     * @param request Usuario con la contraseña cambiada
     * @return UserDTO usuario actrualizado
     * @see User
     * @see UserRepository
     * @see UserDTO
     */
    @Override
    public UserDTO changePassword(UserDTO request) {
        User userToUpdate = userRepository.findByName(request.getName());
        userToUpdate.setPassword(request.getPassword());
        userRepository.save(userToUpdate);
        return request;
    }

}
