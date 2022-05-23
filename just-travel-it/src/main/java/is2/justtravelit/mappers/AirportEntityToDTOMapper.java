package is2.justtravelit.mappers;

import is2.justtravelit.dtos.AirportDTO;
import is2.justtravelit.entities.Airport;

/**
 * Mapper para aeroupertos de Entity a DTO
 * 
 * @see Airport
 * @see AirportDTO
 */
public class AirportEntityToDTOMapper {

    /**
     * @param entity Ariport Entity a transformar
     * @return AirportDTO
     */
    public static AirportDTO mapAirportToAirportDTO(Airport entity) {
        AirportDTO dto = new AirportDTO();

        dto.setCity(entity.getCity());
        dto.setCod(entity.getCod());
        dto.setName(entity.getName());

        return dto;
    }
}
