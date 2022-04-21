package is2.justtravelit.mappers;

import is2.justtravelit.dtos.HotelDTO;
import is2.justtravelit.entities.Hotel;

public class HotelEntityToDTOMapper {

    public static HotelDTO mapHotelEntityToHotelDTO(Hotel entity) {
        HotelDTO dto = new HotelDTO();
        
        dto.setCity(entity.getCity());
        dto.setStars(entity.getStars());
        dto.setName(entity.getName());

        return dto;
    }
}
