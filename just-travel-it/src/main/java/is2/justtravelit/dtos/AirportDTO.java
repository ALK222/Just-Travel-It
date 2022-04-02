package is2.justtravelit.dtos;

import is2.justtravelit.entities.Airport;

public class AirportDTO {

    private long id;
    private String city;
    private String cod;
    private String name;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Airport toEntity(AirportDTO airportDTO) {
        Airport airport = new Airport();
        airport.setName(airportDTO.getName());
        airport.setCod(airportDTO.getCod());
        airport.setCity(airportDTO.getCity());
        return airport;
    }
}
