package is2.justtravelit.mappers;

import is2.justtravelit.dtos.ReservationDTO;
import is2.justtravelit.entities.Reservation;

public class ReservationDTOToEntityMapper {
    public static Reservation mapReservationDTOToReservation(ReservationDTO dto) {
        Reservation entity = new Reservation();
        
        entity.setHotel(HotelDTOToEntityMapper.mapHotelDTOToHotel(dto.getHotel()));
        entity.setGoFlight(FlightDTOToEntityMapper.mapFlightDTOToFlight(dto.getGoFlight()));
        entity.setCanceled(dto.isCanceled());
        entity.setReturnFlight(FlightDTOToEntityMapper.mapFlightDTOToFlight(dto.getReturnFlight()));
        entity.setUser(dto.getUser());

        return entity;
    }
}
