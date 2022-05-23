package is2.justtravelit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity de aeropuertos
 * 
 * @see javax.persistence.Entity
 */
@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String city;

    @Column(unique = true)
    private String cod;

    private String name;

    public Airport() {
    }

    /**
     * @return ID en la base de datos del aeropuerto
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id Nuevo ID del aeropuerto
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Ciudad del aeropuerto
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @param city Nueva ciudad del aeropuerto
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return Código del aeropuerto
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
