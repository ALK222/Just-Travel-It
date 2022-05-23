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

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * @param userDTO
     * @return UserDTO
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
     * @param userDTO
     * @return UserDTO
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
     * @return List<UserDTO>
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
     * @param request
     * @return UserDTO
     */
    @Override
    public UserDTO changePassword(UserDTO request) {
        User userToUpdate = userRepository.findByName(request.getName());
        userToUpdate.setPassword(request.getPassword());
        userRepository.save(userToUpdate);
        return request;
    }

}
