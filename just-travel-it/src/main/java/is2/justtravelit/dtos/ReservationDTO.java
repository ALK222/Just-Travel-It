package is2.justtravelit.dtos;

import is2.justtravelit.entities.User;

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

    
}
