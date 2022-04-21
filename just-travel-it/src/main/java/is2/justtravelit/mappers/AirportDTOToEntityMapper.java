package is2.justtravelit.mappers;

import is2.justtravelit.dtos.AirportDTO;
import is2.justtravelit.entities.Airport;

public class AirportDTOToEntityMapper {
    public static Airport mapAirportDTOToAirport(AirportDTO dto) {
        Airport entity = new Airport();
        
        entity.setCity(dto.getCity());
        entity.setCod(dto.getCod());
        entity.setName(dto.getName());

        return entity;
    }
}
