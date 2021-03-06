package is2.justtravelit.services;

import java.util.List;

import is2.justtravelit.dtos.AirportDTO;

/**
 * Interfaz para el servicio de aeropuertos
 */
public interface AirportService {

    public List<AirportDTO> getAirports();

    public AirportDTO deleteAirport(AirportDTO request);

    public AirportDTO addAirport(AirportDTO request);

    public AirportDTO updateAirport(AirportDTO request);

    public boolean airportValidation(AirportDTO aeropuertoSalida);
}
