package is2.justtravelit.dtos;

import is2.justtravelit.entities.ReservationModify;

public class ReservationModifyDTO {

    Integer id;

    String goFlight;

    String modGoFlight;  //Posible nuveo vuelo de ida

    String returnFlight;

    String modReturnFlight;  //Posible nuevo vuelo de vuelta

    String hotel;

    String modHotel; //Posible nuevo hotel

    String user;

    boolean canceled;
    
    boolean modGo;      //COMPROBAR SI SE MODIFICA DESDE EL FRONT
    
    boolean modReturn;
    
    boolean modH;


    public ReservationModifyDTO() {
    }

    public ReservationModifyDTO(String goFlight, String modGoFlight, String returnFlight, String modReturnFlight, String hotel, String modHotel) {

        this.goFlight = goFlight;
        this.modGoFlight = modGoFlight;
        this.returnFlight = returnFlight;
        this.modReturnFlight = modReturnFlight;
        this.hotel = hotel;
        this.modHotel = modHotel;
    }

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

    public ReservationModifyDTO id(Integer id) {
        setId(id);
        return this;
    }

    public ReservationModifyDTO goFlight(String goFlight) {
        setGoFlight(goFlight);
        return this;
    }

    public ReservationModifyDTO modGoFlight(String modGoFlight) {
        setModGoFlight(modGoFlight);
        return this;
    }

    public ReservationModifyDTO returnFlight(String returnFlight) {
        setReturnFlight(returnFlight);
        return this;
    }

    public ReservationModifyDTO modReturnFlight(String modReturnFlight) {
        setModReturnFlight(modReturnFlight);
        return this;
    }

    public ReservationModifyDTO hotel(String hotel) {
        setHotel(hotel);
        return this;
    }

    public ReservationModifyDTO modHotel(String modHotel) {
        setModHotel(modHotel);
        return this;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isCanceled() {
        return this.canceled;
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
