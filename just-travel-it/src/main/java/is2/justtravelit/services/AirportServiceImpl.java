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

@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    AirportRepository airportRepository;

    @Override
    public List<AirportDTO> getAirports() {
        List<AirportDTO> response = new ArrayList<AirportDTO>();

        for (Airport f : airportRepository.findAll()) {
            response.add(AirportEntityToDTOMapper.mapAirportToAirportDTO(f));
        }

        return response;
    }

    @Override
    @Transactional
    public AirportDTO deleteAirport(AirportDTO request) {
        Airport deletedEntity = AirportDTOToEntityMapper.mapAirportDTOToAirport(request);
        airportRepository.deleteById(deletedEntity.getId());
        return null;
    }

    @Override
    public AirportDTO addAirport(AirportDTO request) {
        airportRepository.save(AirportDTOToEntityMapper.mapAirportDTOToAirport(request));
        return request;
    }

    @Override
    public AirportDTO updateAirport(AirportDTO request) {
        Airport airportToUpdate = airportRepository.findByCod(request.getCod());
        airportToUpdate.setCity(request.getCity());
        airportToUpdate.setName(request.getName());
        airportRepository.save(airportToUpdate);
        return request;
    }

}
