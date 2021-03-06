package is2.justtravelit.mappers;

import is2.justtravelit.dtos.FlightDTO;
import is2.justtravelit.entities.Flight;

/**
 * Mapper para vuelos de DTO a Entity
 * 
 * @see Flight
 * @see FlightDTO
 */
public class FlightDTOToEntityMapper {

    /**
     * @param dto Flight DTO a transformar
     * @return Flight Entity
     */
    public static Flight mapFlightDTOToFlight(FlightDTO dto) {
        Flight entity = new Flight();

        entity.setAeropuertoLlegada(AirportDTOToEntityMapper.mapAirportDTOToAirport(dto.getAeropuertoLlegada()));
        entity.setAeropuertoSalida(AirportDTOToEntityMapper.mapAirportDTOToAirport(dto.getAeropuertoSalida()));
        entity.setCodigo(dto.getCodigo());
        entity.setFechaLlegada(dto.getFechaLlegada());
        entity.setFechaSalida(dto.getFechaSalida());

        return entity;
    }

}
