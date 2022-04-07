package is2.justtravelit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import is2.justtravelit.dtos.ReservationModifyDTO;

@Entity
public class ReservationModify {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne
    Long goFlight;
    @OneToOne
    Long modGoFlight;
    @OneToOne
    Long returnFlight;
    @OneToOne
    Long modReturnFlight;
    @OneToOne
    Long hotel;
    @OneToOne
    Long modHotel;
    @ManyToOne
    Long user;

    boolean canceled;
    boolean modGo; // COMPROBAR SI SE MODIFICA DESDE EL FRONT
    boolean modReturn;
    boolean modH;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoFlight() {
        return this.goFlight;
    }

    public void setGoFlight(Long goFlight) {
        this.goFlight = goFlight;
    }

    public Long getModGoFlight() {
        return this.modGoFlight;
    }

    public void setModGoFlight(Long modGoFlight) {
        this.modGoFlight = modGoFlight;
    }

    public Long getReturnFlight() {
        return this.returnFlight;
    }

    public void setReturnFlight(Long returnFlight) {
        this.returnFlight = returnFlight;
    }

    public Long getModReturnFlight() {
        return this.modReturnFlight;
    }

    public void setModReturnFlight(Long modReturnFlight) {
        this.modReturnFlight = modReturnFlight;
    }

    public Long getHotel() {
        return this.hotel;
    }

    public void setHotel(long hotel) {
        this.hotel = hotel;
    }

    public Long getModHotel() {
        return this.modHotel;
    }

    public void setModHotel(Long modHotel) {
        this.modHotel = modHotel;
    }

    public Long getUser() {
        return this.user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public boolean isModGo() {
        return modGo;
    }

    public void setModGo(boolean modGo) {
        this.modGo = modGo;
    }

    public boolean isModReturn() {
        return modReturn;
    }

    public void setModReturn(boolean modReturn) {
        this.modReturn = modReturn;
    }

    public boolean isModH() {
        return modH;
    }

    public void setModH(boolean modH) {
        this.modH = modH;
    }

    public static ReservationModifyDTO toDTO(ReservationModify reservationModify) {
        ReservationModifyDTO reservationModifyDTO = new ReservationModifyDTO();
        reservationModifyDTO.setGoFlight(reservationModify.getGoFlight());
        reservationModifyDTO.setModGoFlight(reservationModify.getModGoFlight());
        reservationModifyDTO.setGoFlight(reservationModify.getReturnFlight());
        reservationModifyDTO.setModGoFlight(reservationModify.getModReturnFlight());
        reservationModifyDTO.setHotel(reservationModify.getHotel());
        reservationModifyDTO.setModHotel(reservationModify.getModHotel());
        reservationModifyDTO.setCanceled(reservationModify.isCanceled());
        reservationModifyDTO.setModH(reservationModify.isModH());
        reservationModifyDTO.setModGo(reservationModify.isModGo());
        reservationModifyDTO.setModReturn(reservationModify.isModReturn());

        return reservationModifyDTO;
    }

}
