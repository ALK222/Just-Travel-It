package is2.justtravelit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import is2.justtravelit.dtos.FlightDTO;
import is2.justtravelit.services.FlightService;

/**
 * Controlador para todas las operaciones de vuelos
 * 
 * @see RestController
 */
@RestController
public class FlightRestController {

    @Autowired
    private FlightService flightService;

    /**
     * Muestra todos los vuelos disponibles en la base de datos
     * 
     * @return Listado de vuelos y un código HTTP dependiendo del resultado de la
     *         operación
     * @see ResponseEntity
     * @see FlightDTO
     */
    @GetMapping("/flights")
    public ResponseEntity<List<FlightDTO>> getFlights() {
        try {
            List<FlightDTO> response = flightService.getFlights();
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Añade un nuevo vuelo a la base de datos
     * 
     * @param request Vuelo a añadir
     * @return Vuelo creado y un código HTTP código dependiendo del resultado
     *         de la operación
     * @see ResponseEntity
     * @see RequestBody
     * @see FlightDTO
     */
    @PostMapping("/flights")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO request) {
        FlightDTO response = flightService.addFlight(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Borrra un vuelo de la base de datos
     * 
     * @param request Vuelo a borrar
     * @return Vuelo borrado y un código HTTP dependiendo del resultado de la
     *         operación
     * @see ResponseEntity
     * @see RequestBody
     * @see FlightDTO
     */
    @DeleteMapping("/flights")
    public ResponseEntity<FlightDTO> deleteFlight(@RequestBody FlightDTO request) {
        FlightDTO response = flightService.deleteFlight(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Actualiza un vuelo en la base de datos
     * 
     * @param request Vuelo con los datos actualizados
     * @return Vuelo actualizado y un código HTTP dependiendo del resultado de
     *         la operación
     * @see ResponseEntity
     * @see RequestBody
     * @see FlightDTO
     */
    @PutMapping("/flights")
    public ResponseEntity<FlightDTO> updateFlight(@RequestBody FlightDTO request) {
        FlightDTO response = flightService.addFlight(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
