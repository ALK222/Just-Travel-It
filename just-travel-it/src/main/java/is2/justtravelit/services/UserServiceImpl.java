package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is2.justtravelit.dtos.UserDTO;
import is2.justtravelit.entities.User;
import is2.justtravelit.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

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

    @Override
    public UserDTO userRegister(UserDTO userDTO) {
        if (userRepository.findByName(userDTO.getName()) == null) {
            userRepository.save(UserDTO.toEntity(userDTO));
            return new UserDTO(userDTO.getName());
        }

        return null;

    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserDTO> response = new ArrayList<UserDTO>();
        for (User user : userRepository.findAll()) {
            response.add(User.toDTO(user));
        }

        return response;

    }

    @Override
    public UserDTO changePassword(UserDTO request) {
        User userToUpdate = userRepository.findByName(request.getName());
        userToUpdate.setPassword(request.getPassword());
        userRepository.save(userToUpdate);
        return request;
    }

}
