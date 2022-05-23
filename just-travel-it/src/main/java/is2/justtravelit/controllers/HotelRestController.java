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

import is2.justtravelit.dtos.HotelDTO;
import is2.justtravelit.services.HotelService;

/**
 * Controlador para todas las operaciones con hoteles
 * 
 * @see RestController
 */
@RestController
public class HotelRestController {

    @Autowired
    private HotelService hotelService;

    /**
     * Muestra todos los hoteles disponibles en la base de datos
     * 
     * @return Listado de hoteles y un código HTTP dependiendo del resultado de
     *         la operación
     * @see ResponseEntity
     * @see HotelDTO
     */
    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDTO>> getHotels() {
        List<HotelDTO> response = hotelService.getHotels();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Añade un nuevo hotel a la base de datos
     * 
     * @param request Hotel a añadir
     * @return Hotel creado y un código HTTP código dependiendo del resultado
     *         de la operación
     * @see ResponseEntity
     * @see RequestBody
     * @see HotelDTO
     */
    @PostMapping("/hotels")
    public ResponseEntity<HotelDTO> addHotel(@RequestBody HotelDTO hotelDTO) {
        HotelDTO response = hotelService.addHotel(hotelDTO);
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
     * Borrra un hotel de la base de datos
     * 
     * @param request Hotel a borrar
     * @return Hotel borrado y un código HTTP dependiendo del resultado de la
     *         operación
     * @see ResponseEntity
     * @see RequestBody
     * @see HotelDTO
     */
    @DeleteMapping("/hotels")
    public ResponseEntity<HotelDTO> deleteHotel(@RequestBody HotelDTO request) {
        HotelDTO response = hotelService.deleteHotel(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Actualiza un hotel en la base de datos
     * 
     * @param request Hotel con los datos actualizados
     * @return Hotel actualizado y un código HTTP dependiendo del resultado de
     *         la operación
     * @see ResponseEntity
     * @see RequestBody
     * @see HotelDTO
     */
    @PutMapping("/hotels/update")
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO request) {
        HotelDTO response = hotelService.addHotel(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
