package is2.justtravelit.mappers;

import is2.justtravelit.dtos.UserDTO;
import is2.justtravelit.entities.User;

public class UserEntityToDTOMapper {
    public static UserDTO mapUserEntityToUserDTO(User entity) {
        UserDTO dto = new UserDTO();
        
        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setNif(entity.getNif());
        dto.setPassword(entity.getPassword());

        return dto;
    }
}
