package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        try{
            query = reservationRepository.findAllByUser(id);
        }catch(Exception e){

        }
        List<ReservationDTO> response = new ArrayList<>();
        

        for(Reservation r : query){
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
    
}
