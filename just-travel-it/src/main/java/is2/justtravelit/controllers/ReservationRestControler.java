package is2.justtravelit.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import is2.justtravelit.dtos.ReservationDTO;
import is2.justtravelit.dtos.UserDTO;
import is2.justtravelit.services.ReservationService;

/**
 * Controlador para todas las operaciones con reservas
 * 
 * @see RestController
 */
@RestController
public class ReservationRestControler {

    @Autowired
    private ReservationService reservationService;

    /**
     * Muestra todas los reservas disponibles en la base de datos para un usuario
     * dado
     * 
     * @param request Usuario del que buscar las reservas
     * @return Listado de reservas y un código HTTP dependiendo del resultado de
     *         la operación
     * @see ResponseEntity
     * @see ReservationDTO
     */
    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDTO>> getReservations(@RequestBody UserDTO request) {

        List<ReservationDTO> response = new ArrayList<ReservationDTO>();
        response = reservationService.getReservationsByUser(request.getNif());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

    }

    /**
     * Añade un nuevo reserva a la base de datos
     * 
     * @param request Reserva a añadir
     * @param id      ID del usuario que hace la reserva
     * @return Reserva creada y un código HTTP código dependiendo del resultado
     *         de la operación
     * @see ResponseEntity
     * @see RequestBody
     * @see ReservationDTO
     */
    @PostMapping("/reservations")
    public ResponseEntity<ReservationDTO> addReservation(@PathVariable ReservationDTO request, String id) {

        ReservationDTO response = new ReservationDTO();
        response = reservationService.addReservation(request, id);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Borrra un reserva de la base de datos
     * 
     * @param request Reserva a borrar
     * @return Reserva borrada y un código HTTP dependiendo del resultado de la
     *         operación
     * @see ResponseEntity
     * @see RequestBody
     * @see ReservationDTO
     */
    @PutMapping("/reservation/cancel")
    public ResponseEntity<ReservationDTO> cancelReservation(@RequestBody ReservationDTO request) {
        ReservationDTO response = reservationService.cancelReservation(request);
        if (response != null) {
            try {
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Actualiza un reserva en la base de datos
     * 
     * @param request Reserva con los datos actualizados
     * @return Reserva actualizada y un código HTTP dependiendo del resultado de
     *         la operación
     * @see ResponseEntity
     * @see RequestBody
     * @see ReservationDTO
     */
    @PutMapping("/reservations")
    public ResponseEntity<ReservationDTO> modifyReservation(@RequestBody ReservationDTO request) {
        ReservationDTO response = reservationService.modifyReservation(request);
        if (request != null) {
            try {
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
