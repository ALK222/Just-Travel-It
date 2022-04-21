package is2.justtravelit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import is2.justtravelit.dtos.HotelDTO;
import is2.justtravelit.entities.Hotel;
import is2.justtravelit.mappers.HotelDTOToEntityMapper;
import is2.justtravelit.mappers.HotelEntityToDTOMapper;
import is2.justtravelit.repositories.HotelRespository;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRespository hotelRepository;

    @Override
    public List<HotelDTO> getHotels() {
        List<HotelDTO> response = new ArrayList<HotelDTO>();

        for (Hotel f : hotelRepository.findAll()) {
            response.add(HotelEntityToDTOMapper.mapHotelEntityToHotelDTO(f));
        }

        return response;
    }

    @Override
    @Transactional
    public HotelDTO deleteHotel(Long id) {
        hotelRepository.deleteById(id);
        return null;
    }

    @Override
    public HotelDTO addHotel(HotelDTO request) {
        hotelRepository.save(HotelDTOToEntityMapper.mapHotelDTOToHotel(request));
        return request;
    }

    @Override
    public HotelDTO getHotelById(Long id) {
        Optional<Hotel> response;

        response = hotelRepository.findById(id);

        return response.isPresent() ? null : HotelEntityToDTOMapper.mapHotelEntityToHotelDTO(response.get());
    }

}
