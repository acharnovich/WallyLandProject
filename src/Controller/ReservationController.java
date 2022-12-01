package Controller;


import Model.SitDownFoodVendorList;
import View.ReservationView;

public class ReservationController {
    private SitDownFoodVendorList vendors;
    private ReservationView reservationView;

    public ReservationController(){

        this.reservationView = new ReservationView();
        System.out.println("The Reservation Controller was successfully initiated!");
    }
}
