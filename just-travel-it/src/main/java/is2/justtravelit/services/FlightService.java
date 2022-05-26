package is2.justtravelit.services;

import java.util.List;

import is2.justtravelit.dtos.FlightDTO;

/**
 * Interfaz para el servicio de vuelos
 */
public interface FlightService {

    List<FlightDTO> getFlights();

    FlightDTO addFlight(FlightDTO request);

    FlightDTO deleteFlight(FlightDTO request);

    FlightDTO getFlightById(Long id);

    Boolean flightValidation(FlightDTO request);

}
