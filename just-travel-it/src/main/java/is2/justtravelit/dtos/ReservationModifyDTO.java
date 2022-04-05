package is2.justtravelit.dtos;

import is2.justtravelit.entities.ReservationModify;

public class ReservationModifyDTO {

    long id;

    long goFlight;

    long modGoFlight; // Posible nuveo vuelo de ida

    long returnFlight;

    long modReturnFlight; // Posible nuevo vuelo de vuelta

    long hotel;

    long modHotel; // Posible nuevo hotel

    long user;

    boolean canceled;

    boolean modGo; // COMPROBAR SI SE MODIFICA DESDE EL FRONT

    boolean modReturn;

    boolean modH;

    public ReservationModifyDTO() {
    }

    public ReservationModifyDTO(
            long goFlight,
            long modGoFlight,
            long returnFlight,
            long modReturnFlight,
            long hotel, long modHotel) {

        this.goFlight = goFlight;
        this.modGoFlight = modGoFlight;
        this.returnFlight = returnFlight;
        this.modReturnFlight = modReturnFlight;
        this.hotel = hotel;
        this.modHotel = modHotel;
    }

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

    public ReservationModifyDTO id(Integer id) {
        setId(id);
        return this;
    }

    public ReservationModifyDTO goFlight(long goFlight) {
        setGoFlight(goFlight);
        return this;
    }

    public ReservationModifyDTO modGoFlight(long modGoFlight) {
        setModGoFlight(modGoFlight);
        return this;
    }

    public ReservationModifyDTO returnFlight(long returnFlight) {
        setReturnFlight(returnFlight);
        return this;
    }

    public ReservationModifyDTO modReturnFlight(long modReturnFlight) {
        setModReturnFlight(modReturnFlight);
        return this;
    }

    public ReservationModifyDTO hotel(long hotel) {
        setHotel(hotel);
        return this;
    }

    public ReservationModifyDTO modHotel(long modHotel) {
        setModHotel(modHotel);
        return this;
    }

    public long getUser() {
        return this.user;
    }

    public void setUser(long user) {
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
