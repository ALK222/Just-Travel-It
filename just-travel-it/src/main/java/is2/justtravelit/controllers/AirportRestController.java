package is2.justtravelit.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import is2.justtravelit.services.AirportService;

public class AirportRestController {
    @Autowired
    AirportService airportService;
}
