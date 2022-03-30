package is2.justtravelit.services;

import java.util.List;

import is2.justtravelit.dtos.AirportDTO;

public interface AirportService {
    
    public List<AirportDTO> getAirports();

    public AirportDTO deleteAirport(Integer id);

    public AirportDTO addAirport(AirportDTO request);
}
