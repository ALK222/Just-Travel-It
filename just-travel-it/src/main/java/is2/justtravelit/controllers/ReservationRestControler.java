package is2.justtravelit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import is2.justtravelit.dtos.FlightDTO;
import is2.justtravelit.dtos.HotelDTO;
import is2.justtravelit.dtos.ReservationDTO;
import is2.justtravelit.dtos.ReservationModifyDTO;
import is2.justtravelit.services.FlightService;
import is2.justtravelit.services.HotelService;
import is2.justtravelit.services.ReservationService;

@RestController
public class ReservationRestControler {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private HotelService hotelService;

    @GetMapping("/{id}/reservations")
    public ResponseEntity<List<ReservationDTO>> getReservations(@PathVariable String id) {
        List<ReservationDTO> response = new ArrayList<ReservationDTO>();
        response = reservationService.getReservationsByUser(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{id}/reservations/add")
    public ResponseEntity<ReservationDTO> addReservation(@PathVariable ReservationDTO request, String id) {
        ReservationDTO response = new ReservationDTO();
        response = reservationService.addReservation(request, id);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{id}/reservation/cancel")
    public ResponseEntity<ReservationDTO> cancelReservation(@PathVariable String id) {
        ReservationDTO response = new ReservationDTO();
        response = reservationService.getReservationsById(Long.parseLong(id));
        if(response != null)
        {
            try {
                response = reservationService.cancelReservation(response);
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
        }
        else 
        {
            return new return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}/reservations/modify")
    public ResponseEntity<ReservationDTO> modifyReservation(@PathVariable ReservationModifyDTO reservationModifyDTO) {
        ReservationDTO reservationDTO = reservationService.getReservationsById(reservationModifyDTO.getId());
        FlightDTO goFlight = flightService.getFlightById(reservationModifyDTO.getGoFlight());
        FlightDTO returnFlight = flightService.getFlightById(reservationModifyDTO.getModReturnFlight());
        HotelDTO hotel = hotelService.getHotelById(reservationModifyDTO.getHotel());

        if (reservationDTO != null) {
            try {
                if (reservationModifyDTO.isCanceled()) {
                    reservationDTO.setCanceled(true);
                }
                if (reservationModifyDTO.isModGo()) {
                    goFlight = flightService.getFlightById(reservationModifyDTO.getModGoFlight());
                }
                if (reservationModifyDTO.isModReturn()) {
                    returnFlight = flightService.getFlightById(reservationModifyDTO.getModReturnFlight());
                }
                if (reservationModifyDTO.isModH()) {
                    hotel = hotelService.getHotelById(reservationModifyDTO.getModHotel());
                }
                reservationService.modifyReservation(reservationDTO, reservationDTO.getGoFlight(),
                        reservationDTO.getReturnFlight(), reservationDTO.getHotel());
                return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
