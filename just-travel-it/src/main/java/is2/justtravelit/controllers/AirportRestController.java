package is2.justtravelit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import is2.justtravelit.dtos.AirportDTO;
import is2.justtravelit.services.AirportService;

public class AirportRestController {
    @Autowired
    private AirportService airportService;

    @GetMapping("/Airports")
    public ResponseEntity<List<AirportDTO>> getAirports(){
        List<AirportDTO> response = airportService.getAirports();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/Airports/add")
    public ResponseEntity<AirportDTO> addAirport(@RequestBody AirportDTO request){
        AirportDTO response = airportService.addAirport(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/Airports/delete/{id}")
    public ResponseEntity<AirportDTO> deleteAirport(@PathVariable Integer id){
        AirportDTO response = airportService.deleteAirport(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/Airports/update")
    public ResponseEntity<AirportDTO> updateAirport(@RequestBody AirportDTO request){
        AirportDTO response = airportService.addAirport(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
