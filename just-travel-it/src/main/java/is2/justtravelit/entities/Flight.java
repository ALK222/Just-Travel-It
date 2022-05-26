package is2.justtravelit.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity de vuelos
 * 
 * @see javax.persistence.Entity
 */
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codigo;

    private java.sql.Date fechaSalida;
    private java.sql.Date fechaLlegada;

    @OneToOne(cascade = {CascadeType.ALL})
    private Airport aeropuertoSalida;

    @OneToOne(cascade = {CascadeType.ALL})
    private Airport aeropuertoLlegada;

    public Flight(){
        
    }

    public Flight(String codigo, Airport aeropuertoSalida, Airport aeropuertoLlegada) {
        this.codigo = codigo;
        this.aeropuertoSalida = aeropuertoSalida;
        this.aeropuertoLlegada = aeropuertoLlegada;
    }

    /**
     * @return ID del vuelo en la base de datos
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id Nuevo ID del vuelo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Código del vuelo
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * @param codigo Nuevo código del vuelo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return Fecha de salida del vuelo
     * @see java.sql.Date
     */
    public java.sql.Date getFechaSalida() {
        return this.fechaSalida;
    }

    /**
     * @param fechaSalida Nueva fecha de salida
     * @see java.sql.Date
     */
    public void setFechaSalida(java.sql.Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * @return Fecha de llegada del vuelo
     * @see java.sql.Date
     */
    public java.sql.Date getFechaLlegada() {
        return this.fechaLlegada;
    }

    /**
     * @param fechaLlegada Nueva fecha de llegada
     * @see java.sql.Date
     */
    public void setFechaLlegada(java.sql.Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * @return Aeropuerto de salida
     * @see Airport
     */
    public Airport getAeropuertoSalida() {
        return this.aeropuertoSalida;
    }

    /**
     * @param aeropouertoSalida Nuevo aeropuerto de salida
     * @see Airport
     */
    public void setAeropuertoSalida(Airport aeropouertoSalida) {
        this.aeropuertoSalida = aeropouertoSalida;
    }

    /**
     * @return Aeropuerto de llegada
     * @see Airport
     */
    public Airport getAeropuertoLlegada() {
        return this.aeropuertoLlegada;
    }

    /**
     * @param aeropuertoLlegada Nuevo aeropuerto de llegada
     * @see Airport
     */
    public void setAeropuertoLlegada(Airport aeropuertoLlegada) {
        this.aeropuertoLlegada = aeropuertoLlegada;
    }

}
