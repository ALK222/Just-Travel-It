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
import is2.justtravelit.repositories.HotelRepository;

/**
 * Servicio de hoteles
 * 
 * @see HotelService
 * @see org.springframework.stereotype.Service
 */
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    /**
     * @return Listado de todos los hoteles registrados
     * @see Hotel
     * @see HotelDTO
     * @see HotelEntityToDTOMapper
     * @see HotelRepository
     */
    @Override
    public List<HotelDTO> getHotels() {
        List<HotelDTO> response = new ArrayList<HotelDTO>();

        for (Hotel f : hotelRepository.findAll()) {
            response.add(HotelEntityToDTOMapper.mapHotelEntityToHotelDTO(f));
        }

        return response;
    }

    /**
     * Borra un hotel de la base de datos
     * 
     * @param request Hotel a borrar
     * @return NULL
     * @see HotelDTO
     * @see Hotel
     * @see HotelDTOToEntityMapper
     * @see HotelRepository
     * @see javax.transaction.Transactional
     */
    @Override
    @Transactional
    public HotelDTO deleteHotel(HotelDTO request) {
        hotelRepository.deleteByCod(request.getCod());
        return null;
    }

    /**
     * Añade un hotel a la base de datos
     * 
     * @param request Hotel a añadir
     * @return Hotel añadido
     * @see HotelDTO
     * @see Hotel
     * @see HotelDTOToEntityMapper
     * @see HotelRepository
     */
    @Override
    public HotelDTO addHotel(HotelDTO request) {
        if (addHotelValidation(request)) {
            hotelRepository.save(HotelDTOToEntityMapper.mapHotelDTOToHotel(request));
            return request;
        } else {
            return null;
        }
    }

    /**
     * Devuelve un hotel dado un ID
     * 
     * @param id ID del hotel
     * @return HotelDTO o NULL si no se encuentra el hotel
     * @see HotelDTO
     * @see Hotel
     * @see HotelDTOToEntityMapper
     * @see HotelRepository
     */
    @Override
    public HotelDTO getHotelById(Long id) {
        Optional<Hotel> response;

        response = hotelRepository.findById(id);

        return response.isPresent() ? null : HotelEntityToDTOMapper.mapHotelEntityToHotelDTO(response.get());
    }

    /**
     * Valida la información de un hotel antes de añadirlo a la base de datos
     * 
     * @param request Hotel a validar
     * @return Si la información es válida o no
     * @see HotelDTO
     * @see HotelRepository
     */
    @Override
    public Boolean addHotelValidation(HotelDTO request) {

        if (hotelRepository.findByCod(request.getCod()) != null) {
            return false;
        }

        if (request.getStars() == 0 || request.getStars() > 5) {
            return false;
        }

        return true;

    }

    /**
     * Valida la información de un hotel en la base de datos
     * 
     * @param request Hotel a validar
     * @return Si la información es válida o no
     * @see HotelDTO
     * @see HotelRepository
     */
    @Override
    public Boolean hotelValidation(HotelDTO request) {
        if (request.getStars() == 0 || request.getStars() > 5) {
            return false;
        }
        if (!hotelRepository.existsByCod(request.getCod())) {
            return false;
        }

        return true;

    }

    /**
     * Actualiza la información de un hotel en la base de datos
     * 
     * @param request Hotel con la infomación actualizada
     * @return Hotel actualizado
     * @see HotelDTO
     * @see Hotel
     * @see HotelRepository
     */
    @Override
    public HotelDTO updateHotel(HotelDTO request) {
        Hotel hotelToUpdate = hotelRepository.findByCod(request.getCod());
        hotelToUpdate.setCity(request.getCity());
        hotelToUpdate.setName(request.getName());
        hotelRepository.save(hotelToUpdate);
        return request;

    }

}
