package is2.justtravelit.dtos;

/**
 * DTO de hoteles
 */
public class HotelDTO {
    private String name;
    private Integer stars;
    private String city;
    private String cod;

    

    public HotelDTO() {
    }

    public HotelDTO(String name, Integer stars, String city, String cod) {
        this.name = name;
        this.stars = stars;
        this.city = city;
        this.cod = cod;
    }

    /**
     * @return Nombre del hotel
     */
    public String getName() {
        return this.name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @param name Nuevo nombre del hotel
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Estrellas del hotel
     */
    public Integer getStars() {
        return this.stars;
    }

    /**
     * @param stars Nuevas estrellas del hotel
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    /**
     * @return Ciudad del hotel
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @param city Nueva ciudad del hotel
     */
    public void setCity(String city) {
        this.city = city;
    }

}
