package is2.justtravelit.mappers;

import is2.justtravelit.dtos.UserDTO;
import is2.justtravelit.entities.User;

/**
 * Mapper para usuarios de Entity a DTO
 * 
 * @see User
 * @see UserDTO
 */
public class UserEntityToDTOMapper {

    /**
     * @param entity User Entity a transformar
     * @return UserDTO
     */
    public static UserDTO mapUserEntityToUserDTO(User entity) {
        UserDTO dto = new UserDTO();

        dto.setEmail(entity.getEmail());
        dto.setName(entity.getName());
        dto.setNif(entity.getNif());
        dto.setPassword(entity.getPassword());

        return dto;
    }
}
