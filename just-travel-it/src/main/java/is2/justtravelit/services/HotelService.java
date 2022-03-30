package is2.justtravelit.services;

import java.util.List;

import is2.justtravelit.dtos.HotelDTO;

public interface HotelService {
    public List<HotelDTO> getHotels();

    public HotelDTO deleteHotel(Integer id);

    public HotelDTO addHotel(HotelDTO request);
}
