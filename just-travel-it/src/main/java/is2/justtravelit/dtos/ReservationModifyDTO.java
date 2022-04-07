package is2.justtravelit.dtos;

import is2.justtravelit.entities.ReservationModify;

public class ReservationModifyDTO {

    Long id;

    Long goFlight;

    Long modGoFlight; // Posible nuveo vuelo de ida

    Long returnFlight;

    Long modReturnFlight; // Posible nuevo vuelo de vuelta

    Long hotel;

    Long modHotel; // Posible nuevo hotel

    Long user;

    boolean canceled;

    boolean modGo; // COMPROBAR SI SE MODIFICA DESDE EL FRONT

    boolean modReturn;

    boolean modH;

    public ReservationModifyDTO() {
    }

    public ReservationModifyDTO(
            Long goFlight,
            Long modGoFlight,
            Long returnFlight,
            Long modReturnFlight,
            long hotel,
            Long modHotel) {

        this.goFlight = goFlight;
        this.modGoFlight = modGoFlight;
        this.returnFlight = returnFlight;
        this.modReturnFlight = modReturnFlight;
        this.hotel = hotel;
        this.modHotel = modHotel;
    }

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

    public long getHotel() {
        return this.hotel;
    }

    public void setHotel(Long hotel) {
        this.hotel = hotel;
    }

    public Long getModHotel() {
        return this.modHotel;
    }

    public void setModHotel(Long modHotel) {
        this.modHotel = modHotel;
    }

    public ReservationModifyDTO id(Long id) {
        setId(id);
        return this;
    }

    public ReservationModifyDTO goFlight(Long goFlight) {
        setGoFlight(goFlight);
        return this;
    }

    public ReservationModifyDTO modGoFlight(Long modGoFlight) {
        setModGoFlight(modGoFlight);
        return this;
    }

    public ReservationModifyDTO returnFlight(Long returnFlight) {
        setReturnFlight(returnFlight);
        return this;
    }

    public ReservationModifyDTO modReturnFlight(Long modReturnFlight) {
        setModReturnFlight(modReturnFlight);
        return this;
    }

    public ReservationModifyDTO hotel(Long hotel) {
        setHotel(hotel);
        return this;
    }

    public ReservationModifyDTO modHotel(Long modHotel) {
        setModHotel(modHotel);
        return this;
    }

    public Long getUser() {
        return this.user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public boolean isCanceled() {
        return this.canceled;
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

    public static ReservationModify toEntity(ReservationModifyDTO reservationModifyDTO) {
        ReservationModify reservationModify = new ReservationModify();
        reservationModify.setGoFlight(reservationModifyDTO.getGoFlight());
        reservationModify.setModGoFlight(reservationModifyDTO.getModGoFlight());
        reservationModify.setGoFlight(reservationModifyDTO.getReturnFlight());
        reservationModify.setModGoFlight(reservationModifyDTO.getModReturnFlight());
        reservationModify.setHotel(reservationModifyDTO.getHotel());
        reservationModify.setHotel(reservationModifyDTO.getModHotel());
        reservationModify.setCanceled(reservationModify.isCanceled());
        reservationModify.setModH(reservationModifyDTO.isModH());
        reservationModify.setModGo(reservationModifyDTO.isModGo());
        reservationModify.setModReturn(reservationModifyDTO.isModReturn());

        return reservationModify;
    }
}
