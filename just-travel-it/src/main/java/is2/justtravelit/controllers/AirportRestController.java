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

@RestController
public class AirportRestController {
    @Autowired
    private AirportService airportService;

    @GetMapping("/airports")
    public ResponseEntity<List<AirportDTO>> getAirports() {
        List<AirportDTO> response = airportService.getAirports();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/airports")
    public ResponseEntity<AirportDTO> addAirport(@RequestBody AirportDTO request) {
        AirportDTO response = airportService.addAirport(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/airports")
    public ResponseEntity<AirportDTO> deleteAirport(@RequestBody AirportDTO request) {
        AirportDTO response = airportService.deleteAirport(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/airports")
    public ResponseEntity<AirportDTO> updateAirport(@RequestBody AirportDTO request) {
        AirportDTO response = airportService.updateAirport(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
