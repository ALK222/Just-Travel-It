package is2.justtravelit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import is2.justtravelit.dtos.FlightDTO;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String codigo;

    private java.sql.Date fechaSalida;
    private java.sql.Date fechaLlegada;

    @OneToOne
    private Airport aeropuertoSalida;

    @OneToOne
    private Airport aeropuertoLlegada;
    


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public java.sql.Date getFechaSalida() {
        return this.fechaSalida;
    }

    public void setFechaSalida(java.sql.Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public java.sql.Date getFechaLlegada() {
        return this.fechaLlegada;
    }

    public void setFechaLlegada(java.sql.Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Airport getAeropuertoSalida() {
        return this.aeropuertoSalida;
    }

    public void setAeropuertoSalida(Airport aeropouertoSalida) {
        this.aeropuertoSalida = aeropouertoSalida;
    }

    public Airport getAeropuertoLlegada() {
        return this.aeropuertoLlegada;
    }

    public void setAeropuertoLlegada(Airport aeropuertoLlegada) {
        this.aeropuertoLlegada = aeropuertoLlegada;
    }

    public static FlightDTO toDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setCodigo(flight.getCodigo());
        flightDTO.setFechaSalida(flight.getFechaSalida());
        flightDTO.setFechaLlegada(flight.getFechaLlegada());
        flightDTO.setAeropuertoSalida(Airport.toDTO(flight.getAeropuertoSalida()));
        flightDTO.setAeropuertoLlegada(Airport.toDTO(flight.getAeropuertoLlegada()));
        return flightDTO;
    }

}
