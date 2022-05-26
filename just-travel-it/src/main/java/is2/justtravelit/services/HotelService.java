package is2.justtravelit.services;

import java.util.List;

import is2.justtravelit.dtos.HotelDTO;

/**
 * Interfaz para el servicio de hoteles
 */
public interface HotelService {
    public List<HotelDTO> getHotels();

    public HotelDTO deleteHotel(HotelDTO request);

    public HotelDTO addHotel(HotelDTO request);

    HotelDTO getHotelById(Long id);

    public Boolean hotelValidation(HotelDTO request);

    public Boolean addHotelValidation(HotelDTO request);

    public HotelDTO updateHotel(HotelDTO request);
}
