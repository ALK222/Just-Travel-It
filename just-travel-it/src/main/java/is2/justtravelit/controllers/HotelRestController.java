package is2.justtravelit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import is2.justtravelit.dtos.HotelDTO;
import is2.justtravelit.services.HotelService;

@RestController
public class HotelRestController {
    
    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels")
    public ResponseEntity<List<HotelDTO>> getHotels(){
        List<HotelDTO> response = hotelService.getHotels();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/hotels/add")
    public ResponseEntity<HotelDTO> addHotel(@PathVariable HotelDTO request){
        HotelDTO response = hotelService.addHotel(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/hotels/delete/{id}")
    public ResponseEntity<HotelDTO> deleteHotel(@PathVariable Integer id){
        HotelDTO response = hotelService.deleteHotel(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/hotels/update")
    public ResponseEntity<HotelDTO> updateHotel(@PathVariable HotelDTO request){
        HotelDTO response = hotelService.addHotel(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
