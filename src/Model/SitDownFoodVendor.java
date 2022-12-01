package Model;

import java.util.ArrayList;

/**
 * sit down Food Vendor Object, Extends FoodVendor. Stores sit down menu items and available reservation times
 * @author ambd1
 */
public class SitDownFoodVendor extends FoodVendor{

    private ArrayList<String> reservationTimes; //List to hold the available reservation times for a sit down restaurant
    private String price;
    /**
     * default constructor for a food vendor object
     *
     * @param name        name of the food vendor
     * @param location    address of the food vendor
     * @param hours       hours of operation of the food vendor
     * @param price       indication of price of menu items
     */
    public SitDownFoodVendor(String name, String location, String hours, String price) {
        super(name, location, hours);
        this.price = price;
        this.reservationTimes = new ArrayList<String>();
    }

    /**
     * get the available reservation times for a sit down food vendor
     * @return list of available reservation times
     */
    public ArrayList<String> getReservationTimes() {
        return reservationTimes;
    }

    /**
     * Sets let of reservation times available for a day
     * @param reservationTimes
     */
    public void setReservationTimes(ArrayList<String> reservationTimes) {
        this.reservationTimes = reservationTimes;
    }

    /**
     * add a time to the array list containing available reservations
     * @param addTime String containing time to be added
     * @return the updated list of reservation times
     */
    public ArrayList<String> addReservationTime(String addTime){
        this.reservationTimes.add(addTime);
        return reservationTimes;
    }

    /**
     * removes a time from the array list containing available reservations
     * @param removeTime String containing time to be removed
     * @return the updated list of reservation times
     */
    public ArrayList<String> removeReservationTime(String removeTime){
        this.reservationTimes.remove(removeTime);
        return reservationTimes;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    



    /**
     * adds a SitDownMenuItem object to the menu list of items available from a sit down restaurant
     * @param toAdd the SitDownMenuItem object to be added
     * @return the updated list of menu items
     */

    /**
     * displays the information contained in a SitDownFoodVendor object as plain text
     * @return the information contained in a SitDownFoodVendor object as a string
     */
    @Override
    public String toString() {
        return super.toString() + "SitDownFoodVendor{" +
                "reservationTimes=" + reservationTimes +
                               '}';
    }
}
