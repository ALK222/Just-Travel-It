package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

    @Autowired 
    AirportService airportService;

    /**
     * @return Listado de todos los vuelos registrados
     * @see Flight
     * @see FlightDTO
     * @see FlightEntityToDTOMapper
     * @see FlightRespository
     */
    @Override
    public List<FlightDTO> getFlights() {
        List<FlightDTO> response = new ArrayList<FlightDTO>();

        List<Flight> query = flightRepository.findAll();
        
        for (Flight f : query) {
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
     * @see FlightRespository
     * @see javax.transaction.Transactional
     */
    @Override
    @Transactional
    public FlightDTO deleteFlight(FlightDTO request) {
        
        flightRepository.deleteByCodigo(request.getCodigo());
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
     * @see FlightRespository
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
     * @see FlightRespository
     */
    @Override
    public FlightDTO getFlightById(Long id) {
        Optional<Flight> response;

        response = flightRepository.findById(id);

        return response.isPresent() ? null : FlightEntityToDTOMapper.mapFlightToFlightDTO(response.get());
    }

    @Override
    public Boolean flightValidation(FlightDTO request) {

        if (!flightRepository.existsByCodigo(request.getCodigo())) {
            return false;
        }

        if(!airportService.airportValidation(request.getAeropuertoSalida()) || !airportService.airportValidation(request.getAeropuertoLlegada())){
            return false;
        }
        
        if(request.getAeropuertoSalida() == request.getAeropuertoLlegada()){
            return false;
        }

        if (request.getFechaSalida().compareTo(new Date()) < 0) {
            return false;
        }

        if (request.getFechaLlegada().compareTo(new Date()) < 0 ||
                request.getFechaLlegada().compareTo(request.getFechaSalida()) < 0) {

            return false;
        }
        
        return true;
    }

}
