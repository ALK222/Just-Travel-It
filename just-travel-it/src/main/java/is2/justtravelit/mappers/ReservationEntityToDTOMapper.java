package is2.justtravelit.mappers;

import is2.justtravelit.dtos.ReservationDTO;
import is2.justtravelit.entities.Reservation;

/**
 * Mapper para reservas de Entity a DTO
 * 
 * @see Reservation
 * @see ReservationDTO
 */
public class ReservationEntityToDTOMapper {

    /**
     * @param entity Airport Entity a transformar
     * @return ReservationDTO
     */
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
