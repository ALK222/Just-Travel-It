package is2.justtravelit.mappers;

import is2.justtravelit.dtos.ReservationDTO;
import is2.justtravelit.entities.Reservation;

public class ReservationEntityToDTOMapper
 {
    public static ReservationDTO mapReservationEntityToReservationDTO(Reservation entity) {
        ReservationDTO dto = new ReservationDTO();
        
        dto.setHotel(HotelEntityToDTOMapper.mapHotelEntityToHotelDTO(entity.getHotel()));
        dto.setGoFlight(FlightEntityToDTOMapper.mapFlightToFlightDTO(entity.getGoFlight()));
        dto.setCanceled(entity.isCanceled());
        dto.setReturnFlight(FlightEntityToDTOMapper.mapFlightToFlightDTO(entity.getReturnFlight()));
        dto.setUser(entity.getUser());

        return dto;
    }
}
