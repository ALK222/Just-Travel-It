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

/**
 * Servicio de vuelos
 * 
 * @see FlightService
 * @see org.springframework.stereotype.Service
 */
@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRespository flightRepository;

    /**
     * @return Listado de todos los vuelos registrados
     * @see Flight
     * @see FlightDTO
     * @see FlightEntityToDTOMapper
     * @see FlightRepository
     */
    @Override
    public List<FlightDTO> getFlights() {
        List<FlightDTO> response = new ArrayList<FlightDTO>();

        for (Flight f : flightRepository.findAll()) {
            response.add(FlightEntityToDTOMapper.mapFlightToFlightDTO(f));
        }

        return response;
    }

    /**
     * Borra un vuelo de la base de datos
     * 
     * @param request Vuelo a borrar
     * @return NULL
     * @see FlightDTO
     * @see Flight
     * @see FlightDTOToEntityMapper
     * @see FlightRepository
     * @see javax.transaction.Transactional
     */
    @Override
    public FlightDTO deleteFlight(FlightDTO request) {
        Flight deletedEntity = FlightDTOToEntityMapper.mapFlightDTOToFlight(request);
        flightRepository.deleteByID(deletedEntity.getId());
        return null;
    }

    /**
     * Añade un vuelo a la base de datos
     * 
     * @param request vuelo a añadir
     * @return Vuelo añadido
     * @see FlightDTO
     * @see Flight
     * @see FlightDTOToEntityMapper
     * @see FlightRepository
     */
    @Override
    public FlightDTO addFlight(FlightDTO request) {
        flightRepository.save(FlightDTOToEntityMapper.mapFlightDTOToFlight(request));
        return request;
    }

    /**
     * Busca un vuelo dado un ID
     * 
     * @param id ID del vuelo
     * @return FlightDTO o NULL si no se encuentra el vuelo
     * @see FlightDTO
     * @see Flight
     * @see FlightRepository
     */
    @Override
    public FlightDTO getFlightById(Long id) {
        Optional<Flight> response;

        response = flightRepository.findById(id);

        return response.isPresent() ? null : FlightEntityToDTOMapper.mapFlightToFlightDTO(response.get());
    }

}
