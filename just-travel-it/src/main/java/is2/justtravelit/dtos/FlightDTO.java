package is2.justtravelit.dtos;

/**
 * DTO de vuelos
 */
public class FlightDTO {

    private String codigo;

    private java.sql.Date fechaSalida;
    private java.sql.Date fechaLlegada;

    private AirportDTO aeropuertoSalida;
    private AirportDTO aeropuertoLlegada;

    /**
     * @return Código del vuelo en la base de datos
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * @param codigo Nuevo código del vuelo en la base de datos
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
     * @param fechaSalida Nueva fecha de salida del vuelo
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
     * @param fechaLlegada Nueva fecha de llegada del vuelo
     * @see java.sql.Date
     */
    public void setFechaLlegada(java.sql.Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * @return Aeropuerto de salida del vuelo
     * @see AirportDTO
     */
    public AirportDTO getAeropuertoSalida() {
        return this.aeropuertoSalida;
    }

    /**
     * @param aeropuertoSalida Nuevo aeropuerto de salida
     * @see AirportDTO
     */
    public void setAeropuertoSalida(AirportDTO aeropuertoSalida) {
        this.aeropuertoSalida = aeropuertoSalida;
    }

    /**
     * @return Aeropuerto de llegada del vuelo
     * @see AirportDTO
     */
    public AirportDTO getAeropuertoLlegada() {
        return this.aeropuertoLlegada;
    }

    /**
     * @param aeropuertoLlegada Nuevo aeropuerto de llegada
     * @see AirportDTO
     */
    public void setAeropuertoLlegada(AirportDTO aeropuertoLlegada) {
        this.aeropuertoLlegada = aeropuertoLlegada;
    }

}
