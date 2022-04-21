package is2.justtravelit.mappers;

import is2.justtravelit.dtos.FlightDTO;
import is2.justtravelit.entities.Flight;

public class FlightEntityToDTOMapper {
    
    public static FlightDTO mapFlightToFlightDTO(Flight entity) {
        FlightDTO dto = new FlightDTO();

        dto.setAeropuertoLlegada(AirportEntityToDTOMapper.mapAirportToAirportDTO(entity.getAeropuertoLlegada()));
        dto.setAeropuertoSalida(AirportEntityToDTOMapper.mapAirportToAirportDTO(entity.getAeropuertoSalida()));
        dto.setCodigo(entity.getCodigo());
        dto.setFechaLlegada(entity.getFechaLlegada());
        dto.setFechaSalida(entity.getFechaSalida());        

        return dto;
    }
   

}
