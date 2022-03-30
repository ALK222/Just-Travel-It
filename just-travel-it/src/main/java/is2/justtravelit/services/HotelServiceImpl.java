package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import is2.justtravelit.dtos.HotelDTO;
import is2.justtravelit.entities.Hotel;
import is2.justtravelit.repositories.HotelRespository;

public class HotelServiceImpl implements HotelService  {
    @Autowired
    HotelRespository hotelRepository;

    @Override
    public List<HotelDTO> getHotels() {
        List<HotelDTO> response = new ArrayList<HotelDTO>();
        
        for(Hotel f : hotelRepository.findAll()){
            response.add(Hotel.toDTO(f));
        }

        return response;
    }

    @Override
    public HotelDTO deleteHotel(Integer id) {
        hotelRepository.deleteById(id);
        return null;
    }

    @Override
    public HotelDTO addHotel(HotelDTO request) {
        hotelRepository.save(HotelDTO.toEntity(request));
        return request;
    }

}
