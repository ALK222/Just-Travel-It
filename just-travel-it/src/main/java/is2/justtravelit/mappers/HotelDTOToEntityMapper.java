package is2.justtravelit.mappers;

import is2.justtravelit.dtos.HotelDTO;
import is2.justtravelit.entities.Hotel;

public class HotelDTOToEntityMapper {
    public static Hotel mapHotelDTOToHotel(HotelDTO dto) {
        Hotel entity = new Hotel();
        
        entity.setCity(dto.getCity());
        entity.setStars(dto.getStars());
        entity.setName(dto.getName());

        return entity;
    }
}
