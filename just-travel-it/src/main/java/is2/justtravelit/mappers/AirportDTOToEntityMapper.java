package is2.justtravelit.mappers;

import is2.justtravelit.dtos.AirportDTO;
import is2.justtravelit.entities.Airport;

/**
 * Mapper para aeropuertos de DTO a Entity
 * 
 * @see Airport
 * @see AirportDTO
 */
public class AirportDTOToEntityMapper {

    /**
     * @param dto Airport DTO a transformar
     * @return Airport Entity
     */
    public static Airport mapAirportDTOToAirport(AirportDTO dto) {
        Airport entity = new Airport();

        entity.setCity(dto.getCity());
        entity.setCod(dto.getCod());
        entity.setName(dto.getName());

        return entity;
    }
}
