package is2.justtravelit.services;

import java.util.List;

import is2.justtravelit.dtos.FlightDTO;


public interface FlightService {


    List<FlightDTO> getFlights();

    FlightDTO addFlight(FlightDTO request);

    FlightDTO deleteFlight(Integer id);

    FlightDTO getFlightById(Integer id);
    
}
