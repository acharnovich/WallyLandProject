package Model;

/**
 * Creates a reservation at a sit down food vendor option. Removes the selected reservation from the reservation list
 * @author ambd1
 */
public class SitDownReservation {

    private int reservationID;
    private String time;//time of the reservation
    private FoodVendor scheduledVendor;

    /**
     * New reservation for a time at a sit down food vendor
     * @param time time selected for the reservation
     * @param user user who has made the reservation, time should be added to users schedule
     */
    public SitDownReservation(String time, Person user){
        this.time = time;
    }

    /**
     * returns the time of a reservation
     * @return the time of the reservation
     */
    public String getTime() {
        return time;
    }

    /**
     * sets a time of a reservation
     * @param time the time of the reservation
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * prints the information contained in a SitDownReservation object as a text
     * @return the information contained in a SitDownReservation as a String
     */
    @Override
    public String toString() {
        return "SitDownReservation{" +
                "reservationID=" + reservationID +
                ", time='" + time + '\'' +
                ", scheduledVendor=" + scheduledVendor +
                '}';
    }
}
