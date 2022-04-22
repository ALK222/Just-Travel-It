package is2.justtravelit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import is2.justtravelit.dtos.FlightDTO;
import is2.justtravelit.services.FlightService;

@RestController
public class FlightRestController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public ResponseEntity<List<FlightDTO>> getFlights() {
        List<FlightDTO> response = flightService.getFlights();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/flights")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO request) {
        FlightDTO response = flightService.addFlight(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/flights")
    public ResponseEntity<FlightDTO> deleteFlight(@PathVariable Long id) {
        FlightDTO response = flightService.deleteFlight(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/flights")
    public ResponseEntity<FlightDTO> updateFlight(@RequestBody FlightDTO request) {
        FlightDTO response = flightService.addFlight(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
