package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is2.justtravelit.dtos.FlightDTO;
import is2.justtravelit.dtos.HotelDTO;
import is2.justtravelit.dtos.ReservationDTO;
import is2.justtravelit.entities.Reservation;
import is2.justtravelit.entities.User;
import is2.justtravelit.repositories.ReservationRepository;
import is2.justtravelit.repositories.UserRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<ReservationDTO> getReservationsByUser(String id) {
        List<Reservation> query = new ArrayList<Reservation>();
        try {
            query = reservationRepository.findAllByUser(id);
        } catch (Exception e) {

        }
        List<ReservationDTO> response = new ArrayList<>();

        for (Reservation r : query) {
            response.add(Reservation.toDTO(r));
        }

        return response;
    }

    @Override
    public ReservationDTO addReservation(ReservationDTO request, String id) {
        Reservation reservationToAdd = ReservationDTO.toEntity(request);
        User user = userRepository.findByName(id);

        reservationToAdd.setUser(user);
        reservationRepository.save(reservationToAdd);

        return Reservation.toDTO(reservationToAdd);
    }

    @Override
    public ReservationDTO modifyReservation(ReservationDTO request) {
        Optional<Reservation> reservationToUpdate = reservationRepository.findById(request.getId());
        if (reservationToUpdate.isPresent()) {
            reservationToUpdate.get().setCanceled(request.isCanceled());
            reservationToUpdate.get().setGoFlight(FlightDTO.toEntity(request.getGoFlight()));
            reservationToUpdate.get().setHotel(HotelDTO.toEntity(request.getHotel()));
            reservationToUpdate.get().setReturnFlight(FlightDTO.toEntity(request.getReturnFlight()));
            reservationToUpdate.get().setUser(request.getUser());
            return request;
        }
        return null;
    }

    @Override
    public ReservationDTO getReservationsById(Integer id) {
        Optional<Reservation> response;

        response = reservationRepository.findById(id);

        return response.isPresent() ? null : Reservation.toDTO(response.get());
    }

    @Override
    public ReservationDTO cancelReservation(ReservationDTO response) {
        response.setCanceled(true);
        return response;
    }

}
