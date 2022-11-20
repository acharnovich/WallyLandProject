
package Model;


import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Creates a ticket object and contains the methods to get tickets for one person or a group of people for a selected date. It calculates the price based on the number of people and date.
 * @author tpn352
 */
public class parkTicket {

    private String selectedDate;
    private long ticketCode;
    private double price;
    private long ticketID;



    /**
     *  All parameter constructor for parkTicket
     *
     */
    public parkTicket(String date) {
        this.selectedDate = date;
        this.ticketCode = ThreadLocalRandom.current().nextInt(10000000, 99999999);
        this.price = 59.99;
        this.ticketID = ThreadLocalRandom.current().nextInt(10000000, 99999999);

    }

    /**
     * Get the unique code for the ticket to be issued
     * @return Long type Ticket Code
     */
    public long getTicketCode (){
        return ticketCode;
    }

    /**
     * Set the code for the ticket to be issued
     * @param ticketCode Unique code for the ticket in long
     */

    public void setTicketCode (long ticketCode) {
        this.ticketCode = ticketCode;
    }

    /**
     * Get the date for the ticket to be issued
     * @return The intended date of visit as a string
     */
    public String getSelectedDate(){
        return selectedDate;
    }
    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    /**
     * Get the  price of the ticket
     * @return The calculated price as a double
     */

    public double getPrice (){
        return price;
    }

    /**
     * Set the price of the ticket
     * @param price Ticket price as a double
     */
    public void setPrice ( double price){

        this.price = price;

    }


    /**
     *  Get the unique ticket ID used to identify a customer
     * @return Unique ID as long
     */
    public long getTicketID() {
        return ticketID;
    }
    /**
     *  Set the unique ticket ID used to identify a customer
     * @param ticketID Unique ID as long
     */
    public void setTicketID(long ticketID) {
        this.ticketID = ticketID;
    }

    /**
     * View the instance of the ticket
     *
     * @return Represents an parkTicket object as a string
     */
    @Override
    public String toString() {
        return "Ticket Information: \nTicket ID: " + this.getTicketID() + " \nTicket Access Code: " + this.getTicketCode() + "\nDate of Visit: " + this.getSelectedDate();
    }
}
