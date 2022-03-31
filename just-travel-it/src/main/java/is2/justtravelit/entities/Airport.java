package is2.justtravelit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import is2.justtravelit.dtos.AirportDTO;

@Entity
public class Airport {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String city;

    @Column(unique=true)
    private String cod;

    private String name;


    public Airport() {
    }

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

    public static AirportDTO toDTO(Airport airport) {
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setName(airport.getName());
        airportDTO.setCod(airport.getCod());
        airportDTO.setCity(airport.getCity());
        return airportDTO;
    }
}
