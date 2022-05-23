package is2.justtravelit.mappers;

import is2.justtravelit.dtos.FlightDTO;
import is2.justtravelit.entities.Flight;

/**
 * Mapper para vuelos de Entity a DTO
 * 
 * @see Flight
 * @see FlightDTO
 */
public class FlightEntityToDTOMapper {

    /**
     * @param entity Flight Entity a transformar
     * @return FlightDTO
     */
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
