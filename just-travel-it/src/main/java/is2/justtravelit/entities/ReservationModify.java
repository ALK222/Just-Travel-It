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
    Integer id;

    @OneToOne
    String goFlight;
    @OneToOne
    String modGoFlight;
    @OneToOne
    String returnFlight;
    @OneToOne
    String modReturnFlight;
    @OneToOne
    String hotel;
    @OneToOne
    String modHotel;
    @ManyToOne
    String user;

    boolean canceled;
    boolean modGo;      //COMPROBAR SI SE MODIFICA DESDE EL FRONT
    boolean modReturn;
    boolean modH;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoFlight() {
        return this.goFlight;
    }

    public void setGoFlight(String goFlight) {
        this.goFlight = goFlight;
    }

    public String getModGoFlight() {
        return this.modGoFlight;
    }

    public void setModGoFlight(String modGoFlight) {
        this.modGoFlight = modGoFlight;
    }

    public String getReturnFlight() {
        return this.returnFlight;
    }

    public void setReturnFlight(String returnFlight) {
        this.returnFlight = returnFlight;
    }

    public String getModReturnFlight() {
        return this.modReturnFlight;
    }

    public void setModReturnFlight(String modReturnFlight) {
        this.modReturnFlight = modReturnFlight;
    }

    public String getHotel() {
        return this.hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getModHotel() {
        return this.modHotel;
    }

    public void setModHotel(String modHotel) {
        this.modHotel = modHotel;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public boolean isModGo(){
        return modGo;
    }

    public void setModGo(boolean modGo){
        this.modGo = modGo;
    }

    public boolean isModReturn(){
        return modReturn;
    }

    public void setModReturn(boolean modReturn){
        this.modReturn = modReturn;
    }

    public boolean isModH(){
        return modH;
    }

    public void setModH(boolean modH){
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
