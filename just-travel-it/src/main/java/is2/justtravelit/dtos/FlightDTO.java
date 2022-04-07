package is2.justtravelit.dtos;

import is2.justtravelit.entities.Flight;

public class FlightDTO {

    private Long id;
    
    private String codigo;

    private java.sql.Date fechaSalida;
    private java.sql.Date fechaLlegada;

    private AirportDTO aeropuertoSalida;    
    private AirportDTO aeropuertoLlegada;



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



    public AirportDTO getAeropuertoSalida() {
        return this.aeropuertoSalida;
    }

    public void setAeropuertoSalida(AirportDTO aeropuertoSalia) {
        this.aeropuertoSalida = aeropuertoSalia;
    }
   

    public AirportDTO getAeropuertoLlegada() {
        return this.aeropuertoLlegada;
    }

    

    public void setAeropuertoLlegada(AirportDTO aeropuertoLlegada) {
        this.aeropuertoLlegada = aeropuertoLlegada;
    }

    public static Flight toEntity(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setCodigo(flightDTO.getCodigo());
        flight.setFechaSalida(flightDTO.getFechaSalida());
        flight.setFechaLlegada(flightDTO.getFechaLlegada());
        flight.setAeropuertoSalida(AirportDTO.toEntity(flightDTO.getAeropuertoSalida()));
        flight.setAeropuertoLlegada(AirportDTO.toEntity(flightDTO.getAeropuertoLlegada()));
        return flight;
    }

}
