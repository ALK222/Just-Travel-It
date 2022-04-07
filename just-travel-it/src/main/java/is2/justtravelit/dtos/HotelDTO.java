package is2.justtravelit.dtos;

import is2.justtravelit.entities.Hotel;

public class HotelDTO {
    private Long id;
	private String name;
	private Integer stars;
    private String city;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStars() {
        return this.stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static Hotel toEntity(HotelDTO hotelDTO){
        Hotel hotel = new Hotel();
        hotel.setId(hotelDTO.getId());
        hotel.setName(hotelDTO.getName());
        hotel.setStars(hotelDTO.getStars());
        hotel.setCity(hotelDTO.getCity());
        return hotel;
    }
}
