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

import is2.justtravelit.dtos.AirportDTO;
import is2.justtravelit.services.AirportService;

/**
 * Controlador para todas las operaciones con aeropuertos
 * 
 * @see RestController
 */
@RestController
public class AirportRestController {
    @Autowired
    private AirportService airportService;

    /**
     * Muestra todos los aeropuertos disponibles en la base de datos
     * 
     * @return listado de aeropuertos y un
     *         código HTTP dependiendo del resultado de la operación
     * @see ResponseEntity
     * @see AirportDTO
     */
    @GetMapping("/airports")
    public ResponseEntity<List<AirportDTO>> getAirports() {
        try {
            List<AirportDTO> response = airportService.getAirports();
            if (response != null) {
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Añade un nuevo aeropuerto a la base de datos
     * 
     * @param request Aeropuerto a añadir
     * @return Aeropuerto creado y un código HTTP
     *         código dependiendo del resultado de la operación
     * @see ResponseEntity
     * @see RequestBody
     * @see AirportDTO
     */
    @PostMapping("/airports")
    public ResponseEntity<AirportDTO> addAirport(@RequestBody AirportDTO request) {
        try {
            AirportDTO response = airportService.addAirport(request);
            if (response != null) {
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Borrra un aeropuerto de la base de datos
     * 
     * @param request Aeropuerto a borrar
     * @return Aeropuerto borrado y un código HTTP
     *         dependiendo del resultado de la operación
     * @see ResponseEntity
     * @see RequestBody
     * @see AirportDTO
     */
    @DeleteMapping("/airports")
    public ResponseEntity<AirportDTO> deleteAirport(@RequestBody AirportDTO request) {
        AirportDTO response = airportService.deleteAirport(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Actualiza un aeropuerto en la base de datos
     * 
     * @param request Aeropuerto con los datos actualizados
     * @return Aeropuerto actualizado y un código HTTP
     *         dependiendo del resultado de la operación
     * @see ResponseEntity
     * @see RequestBody
     * @see AirportDTO
     */
    @PutMapping("/airports")
    public ResponseEntity<AirportDTO> updateAirport(@RequestBody AirportDTO request) {
        AirportDTO response = airportService.updateAirport(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
