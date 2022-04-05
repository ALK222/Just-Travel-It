package is2.justtravelit.services;

import java.util.List;

import is2.justtravelit.dtos.FlightDTO;
import is2.justtravelit.dtos.HotelDTO;
import is2.justtravelit.dtos.ReservationDTO;

public interface ReservationService {

    List<ReservationDTO> getReservationsByUser(String id);

    ReservationDTO addReservation(ReservationDTO request, String id);
    void modifyReservation(ReservationDTO request, FlightDTO newGoFlight, FlightDTO newReturnFlight, HotelDTO newHotel);

    
}
