package is2.justtravelit.dtos;

import is2.justtravelit.entities.User;

/**
 * DTO de reservas
 */
public class ReservationDTO {

    FlightDTO goFlight;

    FlightDTO returnFlight;

    HotelDTO hotel;

    User user;

    boolean canceled;

    public ReservationDTO() {
    }

    public ReservationDTO(FlightDTO goFlight, FlightDTO returnFlight, HotelDTO hotel) {

        this.goFlight = goFlight;
        this.returnFlight = returnFlight;
        this.hotel = hotel;
    }

    /**
     * @return Vuelo de ida de la reserva
     */
    public FlightDTO getGoFlight() {
        return this.goFlight;
    }

    /**
     * @param goFlight Nuevo vuelo de ida
     * @see FlightDTO
     */
    public void setGoFlight(FlightDTO goFlight) {
        this.goFlight = goFlight;
    }

    /**
     * @return Vuelo de vuelta de la reserva
     * @see FlightDTO
     */
    public FlightDTO getReturnFlight() {
        return this.returnFlight;
    }

    /**
     * @param returnFlight Nuevo vuelo de vuelta
     * @see FlightDTO
     */
    public void setReturnFlight(FlightDTO returnFlight) {
        this.returnFlight = returnFlight;
    }

    /**
     * @return Hotel de la reserva
     * @see HotelDTO
     */
    public HotelDTO getHotel() {
        return this.hotel;
    }

    /**
     * @param hotel Nuevo hotel de la reserva
     * @see HotelDTO
     */
    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    /**
     * @param goFlight Nuevo vuelo de ida
     * @return Reserva modificada
     * @see FlightDTO
     */
    public ReservationDTO goFlight(FlightDTO goFlight) {
        setGoFlight(goFlight);
        return this;
    }

    /**
     * @param returnFlight Nuevo vuelo de vuelta
     * @return Reserva modificada
     * @see FlightDTO
     */
    public ReservationDTO returnFlight(FlightDTO returnFlight) {
        setReturnFlight(returnFlight);
        return this;
    }

    /**
     * @param hotel Nuevo hotel
     * @return Reserva modificada
     * @see FlightDTO
     */
    public ReservationDTO hotel(HotelDTO hotel) {
        setHotel(hotel);
        return this;
    }

    /**
     * @return Usuario que hizo la reserva
     * @see User
     */
    public User getUser() {
        return this.user;
    }

    /**
     * @param user Nuevo usuario de la reserva
     * @see User
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return Estado de cancelación de la reserva
     */
    public boolean isCanceled() {
        return this.canceled;
    }

    /**
     * @param canceled Nuevo estado de cancelación de la reserva
     */
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

}
