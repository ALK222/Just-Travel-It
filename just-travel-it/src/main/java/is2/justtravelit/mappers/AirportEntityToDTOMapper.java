package is2.justtravelit.mappers;

import is2.justtravelit.dtos.AirportDTO;
import is2.justtravelit.entities.Airport;

public class AirportEntityToDTOMapper {
    public static AirportDTO mapAirportToAirportDTO(Airport entity) {
        AirportDTO dto = new AirportDTO();
        
        dto.setCity(entity.getCity());
        dto.setCod(entity.getCod());
        dto.setName(entity.getName());

        return dto;
    }
}
