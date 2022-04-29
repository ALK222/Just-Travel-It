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

@RestController
public class HotelRestController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDTO>> getHotels() {
        List<HotelDTO> response = hotelService.getHotels();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

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

    @DeleteMapping("/hotels")
    public ResponseEntity<HotelDTO> deleteHotel(@RequestBody HotelDTO request) {
        HotelDTO response = hotelService.deleteHotel(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/hotels/update")
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO request) {
        HotelDTO response = hotelService.addHotel(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
