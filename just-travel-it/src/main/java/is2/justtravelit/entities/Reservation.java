package is2.justtravelit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Entity de reservas
 * 
 * @see javax.persistence.Entity
 */
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    Flight goFlight;
    @OneToOne
    Flight returnFlight;
    @OneToOne
    Hotel hotel;
    @ManyToOne
    User user;

    boolean candeled;

    /**
     * @return ID de la reserva en la base de datos
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id Nuevo ID de la reserva
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Vuelo de ida
     * @see Flight
     */
    public Flight getGoFlight() {
        return this.goFlight;
    }

    /**
     * @param goFlight Nuevo vuelo de ida
     * @see Flight
     */
    public void setGoFlight(Flight goFlight) {
        this.goFlight = goFlight;
    }

    /**
     * @return Vuelo de vuelta
     * @see Flight
     */
    public Flight getReturnFlight() {
        return this.returnFlight;
    }

    /**
     * @param returnFlight Nuevo vuelo de vuelta
     * @see Flight
     */
    public void setReturnFlight(Flight returnFlight) {
        this.returnFlight = returnFlight;
    }

    /**
     * @return Hotel de la reserva
     * @see Hotel
     */
    public Hotel getHotel() {
        return this.hotel;
    }

    /**
     * @param hotel Nuevo hotel
     * @see Hotel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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
        return candeled;
    }

    /**
     * @param canceled Nuevo estado de cancelación de la reserva
     */
    public void setCanceled(boolean canceled) {
        this.candeled = canceled;
    }

}
