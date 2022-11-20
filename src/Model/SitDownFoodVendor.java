package Model;

import java.util.ArrayList;

/**
 * sit down Food Vendor Object, Extends FoodVendor. Stores sit down menu items and available reservation times
 * @author ambd1
 */
public class SitDownFoodVendor extends FoodVendor{

    private ArrayList<String> reservationTimes; //List to hold the available reservation times for a sit down restaurant
    private ArrayList<SitDownMenuItem> menuItems;
    /**
     * default constructor for a food vendor object
     *
     * @param name        name of the food vendor
     * @param description short description of the food vendor
     * @param location    address of the food vendor
     * @param hours       hours of operation of the food vendor
     */
    public SitDownFoodVendor(String name, String description, String location, String hours) {
        super(name, description, location, hours);
        this.reservationTimes = new ArrayList<String>();
        this.menuItems = new ArrayList<SitDownMenuItem>();
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

    /**
     * get the available menu items for a sit down restaurant
     *
     * @return list of available menu items
     */
    public ArrayList<SitDownMenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * Sets list of menu items available from a sit down restaurant
     * @param menuItems menu items to be set as menu list
     */
    public void setMenuItems(ArrayList<SitDownMenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    /**
     * adds a SitDownMenuItem object to the menu list of items available from a sit down restaurant
     * @param toAdd the SitDownMenuItem object to be added
     * @return the updated list of menu items
     */
    public ArrayList<SitDownMenuItem> addItem(SitDownMenuItem toAdd){
        this.menuItems.add(toAdd);
        return menuItems;
    }

    /**
     * removes a SitDownMenuItem object from the menu list of items available from a sit down restaurant
     * @param toRemove the SitDownMenuItem object to be removed
     * @return the updated list of menu items
     */
    public ArrayList<SitDownMenuItem> removeItem(SitDownMenuItem toRemove){
        this.menuItems.remove(toRemove);
        return menuItems;
    }

    /**
     * displays the information contained in a SitDownFoodVendor object as plain text
     * @return the information contained in a SitDownFoodVendor object as a string
     */
    @Override
    public String toString() {
        return super.toString() + "SitDownFoodVendor{" +
                "reservationTimes=" + reservationTimes +
                ", menuItems=" + menuItems.toString() +
                '}';
    }
}
