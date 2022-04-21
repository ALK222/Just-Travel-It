package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is2.justtravelit.dtos.FlightDTO;
import is2.justtravelit.entities.Flight;
import is2.justtravelit.mappers.FlightDTOToEntityMapper;
import is2.justtravelit.mappers.FlightEntityToDTOMapper;
import is2.justtravelit.repositories.FlightRespository;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRespository flightRepository;

    @Override
    public List<FlightDTO> getFlights() {
        List<FlightDTO> response = new ArrayList<FlightDTO>();

        for (Flight f : flightRepository.findAll()) {
            response.add(FlightEntityToDTOMapper.mapFlightToFlightDTO(f));
        }

        return response;
    }

    @Override
    public FlightDTO deleteFlight(Long id) {
        flightRepository.deleteById(id);
        return null;
    }

    @Override
    public FlightDTO addFlight(FlightDTO request) {
        flightRepository.save(FlightDTOToEntityMapper.mapFlightDTOToFlight(request));
        return request;
    }

    

    @Override
    public FlightDTO getFlightById(Long id) {
         Optional<Flight> response;

         response = flightRepository.findById(id);

         return response.isPresent() ? null :FlightEntityToDTOMapper.mapFlightToFlightDTO(response.get());
    }

}
