package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is2.justtravelit.dtos.AirportDTO;
import is2.justtravelit.entities.Airport;
import is2.justtravelit.mappers.AirportDTOToEntityMapper;
import is2.justtravelit.mappers.AirportEntityToDTOMapper;
import is2.justtravelit.repositories.AirportRepository;

/**
 * Servicio de aeropuertos
 * 
 * @see AirportService
 * @see org.springframework.stereotype.Service
 */
@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    AirportRepository airportRepository;

    /**
     * @return Listado de todos los aeropuertos registrados
     * @see Airport
     * @see AirportDTO
     * @see AirportEntityToDTOMapper
     * @see AirportRepository
     */
    @Override
    public List<AirportDTO> getAirports() {
        List<AirportDTO> response = new ArrayList<AirportDTO>();

        for (Airport f : airportRepository.findAll()) {
            response.add(AirportEntityToDTOMapper.mapAirportToAirportDTO(f));
        }

        return response;
    }

    /**
     * Borra un aeropuerto de la base de datos
     * 
     * @param request Aeropuerto a borrar
     * @return NULL
     * @see AirportDTO
     * @see Airport
     * @see AirportDTOToEntityMapper
     * @see AirportRepository
     * @see javax.transaction.Transactional
     */
    @Override
    @Transactional
    public AirportDTO deleteAirport(AirportDTO request) {
        Airport deletedEntity = AirportDTOToEntityMapper.mapAirportDTOToAirport(request);
        airportRepository.deleteById(deletedEntity.getId());
        return null;
    }

    /**
     * Añade un aeropuerto a la base de datos
     * 
     * @param request Aeropuerto a añadir
     * @return Aeropuerto añadido
     * @see AirportDTO
     * @see Airport
     * @see AirportDTOToEntityMapper
     * @see AirportRepository
     */
    @Override
    public AirportDTO addAirport(AirportDTO request) {
        airportRepository.save(AirportDTOToEntityMapper.mapAirportDTOToAirport(request));
        return request;
    }

    /**
     * Actualiza los datos de un aeropuerto en la base de datos
     * 
     * @param request Aeropuerto a actualziar
     * @return Aeropuerto modificado
     * @see AirportDTO
     * @see Airport
     * @see AirportRepository
     */
    @Override
    public AirportDTO updateAirport(AirportDTO request) {
        Airport airportToUpdate = airportRepository.findByCod(request.getCod());
        airportToUpdate.setCity(request.getCity());
        airportToUpdate.setName(request.getName());
        airportRepository.save(airportToUpdate);
        return request;
    }

    @Override
    public boolean airportValidation(AirportDTO request) {
        
        if (!airportRepository.existsByCod(request.getCod())) {
            return false;
        }
        return true;
    }

}
