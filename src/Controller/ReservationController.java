package Controller;

import Model.ReservationList;
import View.ReservationView;

public class ReservationController {
    private ReservationList reservationModel;
    private ReservationView reservationView;

    public ReservationController(){
        this.reservationModel = new ReservationList();
        this.reservationView = new ReservationView();
        System.out.println("The Reservation Controller was successfully initiated!");
        reservationView.displayReservationTest(reservationModel.loadData());
    }
}
