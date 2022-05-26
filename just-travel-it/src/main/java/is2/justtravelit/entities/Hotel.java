package is2.justtravelit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity de hoteles
 * 
 * @see javax.persistence.Entity
 */
@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String name;
    private Integer stars;
    private String city;
    
    @Column(unique = true)
    private String cod;


    public Hotel(Long id, String name, Integer stars, String city, String cod) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.city = city;
        this.cod = cod;
    }

    public Hotel() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return ID del hotel en la base de datos
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id Nuevo ID del hotel en la based de datos
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Nombre del hotel
     */
    public String getName() {
        return this.name;
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
     * @param stars Nueva calificación del hotel
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
