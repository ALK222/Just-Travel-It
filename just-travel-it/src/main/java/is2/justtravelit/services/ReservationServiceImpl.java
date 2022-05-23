package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is2.justtravelit.dtos.ReservationDTO;
import is2.justtravelit.entities.Reservation;
import is2.justtravelit.entities.User;
import is2.justtravelit.mappers.FlightDTOToEntityMapper;
import is2.justtravelit.mappers.HotelDTOToEntityMapper;
import is2.justtravelit.mappers.ReservationDTOToEntityMapper;
import is2.justtravelit.mappers.ReservationEntityToDTOMapper;
import is2.justtravelit.repositories.ReservationRepository;
import is2.justtravelit.repositories.UserRepository;

/**
 * Servicio de reservas
 * 
 * @see ReservationService
 * @see org.springframework.stereotype.Service
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * Busca todas las reservas dado un id de usuario
     * 
     * @param id ID del usuario del que se buscan las reservas
     * @return Listado de reservas
     * @see ReservationDTO
     * @see ReservationRepository
     * @see Reservation
     * @see ReservationEntityToDTOMapper
     */
    @Override
    public List<ReservationDTO> getReservationsByUser(String id) {
        List<Reservation> query = new ArrayList<Reservation>();
        try {
            query = reservationRepository.findAllByUser(id);
        } catch (Exception e) {

        }
        List<ReservationDTO> response = new ArrayList<>();

        for (Reservation r : query) {
            response.add(ReservationEntityToDTOMapper.mapReservationEntityToReservationDTO(r));
        }

        return response;
    }

    /**
     * Añade una reserva a la base de datos
     * 
     * @param request Reserva a añadir
     * @param id      Usuario que hace la reserva
     * @return Reserva hecha
     * @see ReservationDTO
     * @see Reservation
     * @see ReservationRepository
     * @see User
     * @see ReservationDTOToEntityMapper
     * @see ReservationEntityToDTOMapper
     */
    @Override
    public ReservationDTO addReservation(ReservationDTO request, String id) {
        Reservation reservationToAdd = ReservationDTOToEntityMapper.mapReservationDTOToReservation(request);
        User user = userRepository.findByName(id);

        reservationToAdd.setUser(user);
        reservationRepository.save(reservationToAdd);

        return ReservationEntityToDTOMapper.mapReservationEntityToReservationDTO(reservationToAdd);
    }

    /**
     * Modificación de una reserva
     * 
     * @param request Reserva a modificar
     * @return Reserva Modificada
     * @see ReservationDTO
     * @see Reservation
     * @see ReservationRepository
     * @see User
     * @see ReservationDTOToEntityMapper
     * @see FlightDTOToEntityMapper
     * @see HotelDTOToEntityMapper
     */
    @Override
    public ReservationDTO modifyReservation(ReservationDTO request) {
        Reservation modifiedEntity = ReservationDTOToEntityMapper.mapReservationDTOToReservation(request);
        Optional<Reservation> reservationToUpdate = reservationRepository.findById(modifiedEntity.getId());
        if (reservationToUpdate.isPresent()) {
            reservationToUpdate.get().setCanceled(request.isCanceled());
            reservationToUpdate.get().setGoFlight(FlightDTOToEntityMapper.mapFlightDTOToFlight(request.getGoFlight()));
            reservationToUpdate.get().setHotel(HotelDTOToEntityMapper.mapHotelDTOToHotel(request.getHotel()));
            reservationToUpdate.get()
                    .setReturnFlight(FlightDTOToEntityMapper.mapFlightDTOToFlight(request.getReturnFlight()));
            reservationToUpdate.get().setUser(request.getUser());
            reservationRepository.save(reservationToUpdate.get());
            return request;
        }
        return null;
    }

    /**
     * Busca una reserva dado un código
     * 
     * @param id ID de la reserva
     * @return ReservationDTO o NULL si no se encuentra la reserva
     * @see Optional
     * @see Reservation
     * @see ReservationDTO
     * @see ReservationRepository
     * @see ReservationEntityToDTOMapper
     */
    @Override
    public ReservationDTO getReservationsById(Long id) {
        Optional<Reservation> response;

        response = reservationRepository.findById(id);

        return response.isPresent() ? null
                : ReservationEntityToDTOMapper.mapReservationEntityToReservationDTO(response.get());
    }

    /**
     * Cancela una reserva
     * 
     * @param request Reserva a cancelar
     * @return NULL
     * @see Optional
     * @see Reservation
     * @see ReservationDTO
     * @see ReservationRepository
     * @see ReservationDTOToEntityMapper
     * @see ReservationEntityToDTOMapper
     */
    @Override
    public ReservationDTO cancelReservation(ReservationDTO request) {
        Reservation canceledEntity = ReservationDTOToEntityMapper.mapReservationDTOToReservation(request);
        Optional<Reservation> response = reservationRepository.findById(canceledEntity.getId());
        if (response.isPresent()) {
            response.get().setCanceled(true);
            return ReservationEntityToDTOMapper.mapReservationEntityToReservationDTO(response.get());
        }
        return null;
    }

}
