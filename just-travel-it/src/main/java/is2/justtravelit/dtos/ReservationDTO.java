package is2.justtravelit.dtos;

import is2.justtravelit.entities.Reservation;
import is2.justtravelit.entities.User;

public class ReservationDTO {

    Long id;

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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FlightDTO getGoFlight() {
        return this.goFlight;
    }

    public void setGoFlight(FlightDTO goFlight) {
        this.goFlight = goFlight;
    }

    public FlightDTO getReturnFlight() {
        return this.returnFlight;
    }

    public void setReturnFlight(FlightDTO returnFlight) {
        this.returnFlight = returnFlight;
    }

    public HotelDTO getHotel() {
        return this.hotel;
    }

    public void setHotel(HotelDTO hotel) {
        this.hotel = hotel;
    }

    public ReservationDTO id(Long id) {
        setId(id);
        return this;
    }

    public ReservationDTO goFlight(FlightDTO goFlight) {
        setGoFlight(goFlight);
        return this;
    }

    public ReservationDTO returnFlight(FlightDTO returnFlight) {
        setReturnFlight(returnFlight);
        return this;
    }

    public ReservationDTO hotel(HotelDTO hotel) {
        setHotel(hotel);
        return this;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public static Reservation toEntity(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setGoFlight(FlightDTO.toEntity(reservationDTO.getGoFlight()));
        reservation.setGoFlight(FlightDTO.toEntity(reservationDTO.getReturnFlight()));
        reservation.setHotel(HotelDTO.toEntity(reservationDTO.getHotel()));
        reservation.setCanceled(reservationDTO.isCanceled());

        return reservation;
    }
}
