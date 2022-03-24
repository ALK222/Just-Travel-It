package is2.justtravelit.services;

import java.util.List;

import is2.justtravelit.dtos.ReservationDTO;

public interface ReservationService {

    List<ReservationDTO> getReservationsByUser(String id);
    
}
