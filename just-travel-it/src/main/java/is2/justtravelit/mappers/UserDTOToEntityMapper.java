package is2.justtravelit.mappers;

import is2.justtravelit.dtos.UserDTO;
import is2.justtravelit.entities.User;

public class UserDTOToEntityMapper {
    public static User mapUserDTOToUser(UserDTO dto) {
        User entity = new User();
        
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        entity.setNif(dto.getNif());
        entity.setPassword(dto.getPassword());

        return entity;
    }
}
