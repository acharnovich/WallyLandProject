/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 * Stores a list of reservations made at sit down food vendors, each reservation is assigned a unique id which will be added to the profile of the user placing the order.
 * @author ambd1
 */
public class ReservationList {
    private ArrayList<Integer> reservationList;

    /**
     * default constructor for the reservation list
     */
    public ReservationList(){
        this.reservationList = reservationList;
    }

    /**
     * Adds a reservation ID to the list of reservations
     * @param reservationID Integer containing the reservation ID
     * @return reservation ID that has been successfully added to the list for confirmation purposes
     */
    public Integer addToReservationList(Integer reservationID){
        this.reservationList.add(reservationID);
        return reservationID;
    }

    /**
     * Removes a reservation ID from the list of reservations
     * @param reservationID Integer containing the reservation ID
     * @return reservation ID that has been successfully removed from the list for confirmation purposes
     */
    public Integer removeFromReservationList(Integer reservationID){
        this.reservationList.remove(reservationID);
        return reservationID;
    }

    @Override
    public String toString() {
        return "ReservationList{" +
                "reservationList=" + reservationList +
                '}';
    }

    public String loadData(){
        reservationList = new ArrayList<>();
        reservationList.add(11111);
        return this.reservationList.toString();
    }
}
