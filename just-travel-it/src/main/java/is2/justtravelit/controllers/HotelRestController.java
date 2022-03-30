package is2.justtravelit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import is2.justtravelit.services.HotelService;

@RestController
public class HotelRestController {
    
    @Autowired
    HotelService hotelservice;
}
