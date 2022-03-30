package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import is2.justtravelit.dtos.AirportDTO;
import is2.justtravelit.entities.Airport;
import is2.justtravelit.repositories.AirportRepository;

public class AirportServiceImpl implements AirportService {
    @Autowired
    AirportRepository airportRepository;

    @Override
    public List<AirportDTO> getAirports() {
        List<AirportDTO> response = new ArrayList<AirportDTO>();
        
        for(Airport f : airportRepository.findAll()){
            response.add(Airport.toDTO(f));
        }

        return response;
    }

    @Override
    public AirportDTO deleteAirport(Integer id) {
        airportRepository.deleteById(id);
        return null;
    }

    @Override
    public AirportDTO addAirport(AirportDTO request) {
        airportRepository.save(AirportDTO.toEntity(request));
        return request;
    }
    
}
