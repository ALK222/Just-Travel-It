package is2.justtravelit.dtos;

/**
 * DTO de aeropuertos
 */
public class AirportDTO {

    private String city;
    private String cod;
    private String name;

    /**
     * @return Ciudad en la que se encuentra el aeropuerto
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @param city Nueva ciudad en la que se encuentra el aeropuerto
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return Código del aeropuerto en la base de datos
     */
    public String getCod() {
        return this.cod;
    }

    /**
     * @param cod Nuevo código del aeropuerto
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return Nombre del aeropuerto
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name Nuevo nombre del aeropuerto
     */
    public void setName(String name) {
        this.name = name;
    }

}
