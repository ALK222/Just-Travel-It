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
    long id;

    @OneToOne
    long goFlight;
    @OneToOne
    long modGoFlight;
    @OneToOne
    long returnFlight;
    @OneToOne
    long modReturnFlight;
    @OneToOne
    long hotel;
    @OneToOne
    long modHotel;
    @ManyToOne
    long user;

    boolean canceled;
    boolean modGo; // COMPROBAR SI SE MODIFICA DESDE EL FRONT
    boolean modReturn;
    boolean modH;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGoFlight() {
        return this.goFlight;
    }

    public void setGoFlight(long goFlight) {
        this.goFlight = goFlight;
    }

    public long getModGoFlight() {
        return this.modGoFlight;
    }

    public void setModGoFlight(long modGoFlight) {
        this.modGoFlight = modGoFlight;
    }

    public long getReturnFlight() {
        return this.returnFlight;
    }

    public void setReturnFlight(long returnFlight) {
        this.returnFlight = returnFlight;
    }

    public long getModReturnFlight() {
        return this.modReturnFlight;
    }

    public void setModReturnFlight(long modReturnFlight) {
        this.modReturnFlight = modReturnFlight;
    }

    public long getHotel() {
        return this.hotel;
    }

    public void setHotel(long hotel) {
        this.hotel = hotel;
    }

    public long getModHotel() {
        return this.modHotel;
    }

    public void setModHotel(long modHotel) {
        this.modHotel = modHotel;
    }

    public long getUser() {
        return this.user;
    }

    public void setUser(long user) {
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
