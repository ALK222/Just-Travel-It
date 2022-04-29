package is2.justtravelit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String codigo;

    private java.sql.Date fechaSalida;
    private java.sql.Date fechaLlegada;

    @OneToOne
    private Airport aeropuertoSalida;

    @OneToOne
    private Airport aeropuertoLlegada;
    


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    

}
