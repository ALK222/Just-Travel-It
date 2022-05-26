package is2.justtravelit.mappers;

import is2.justtravelit.dtos.HotelDTO;
import is2.justtravelit.entities.Hotel;

/**
 * Mapper para hoteles de Entity a DTO
 * 
 * @see Hotel
 * @see HotelDTO
 */
public class HotelEntityToDTOMapper {

    /**
     * @param entity Hotel Entity a transformar
     * @return HotelDTO
     */
    public static HotelDTO mapHotelEntityToHotelDTO(Hotel entity) {
        HotelDTO dto = new HotelDTO();

        dto.setCity(entity.getCity());
        dto.setStars(entity.getStars());
        dto.setName(entity.getName());
        dto.setCod(entity.getCod());

        return dto;
    }
}
