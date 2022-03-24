package is2.justtravelit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import is2.justtravelit.dtos.ReservationDTO;

@Entity
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @OneToOne
    Flight goFlight;
    @OneToOne
    Flight returnFlight;
    @OneToOne
    Hotel hotel;

    


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Flight getGoFlight() {
        return this.goFlight;
    }

    public void setGoFlight(Flight goFlight) {
        this.goFlight = goFlight;
    }

    public Flight getReturnFlight() {
        return this.returnFlight;
    }

    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }

    public Hotel getHotel() {
        return this.hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public static ReservationDTO toDTO(Reservation reservation){
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setGoFlight(Flight.toDTO(reservation.getGoFlight()));
        reservationDTO.setGoFlight(Flight.toDTO(reservation.getReturnFlight()));
        reservationDTO.setHotel(Hotel.toDTO(reservation.getHotel()));

        return reservationDTO;
    }
        

}
