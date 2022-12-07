package Model;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

/**
 * UserAccount inherits Person and creates an instance of a customer's account
 * which contains their personal information, login credentials, and ArrayList
 * representing the customer's schedule and their food orders
 *
 * @author tpn352
 *
 */
public class UserAccount extends Person {

    private int customerID;
    private String username;
    private String password;
    private boolean authentication;
    private ArrayList<Attraction> schedule;
    private ArrayList<Integer> foodOrders;
    private ArrayList<SitDownReservation> reservations;

    private boolean ticketHolder;
    private ArrayList<parkTicket> ticketsPurchased;

    /**
     * This is the all parameter constructor for User Account extending the
     * Person class.
     *
     * @param name
     * @param email
     * @param dateOfBirth
     */
    public UserAccount(String name, String email, String dateOfBirth, int customerID, String username, String password, boolean authentication, ArrayList<Attraction> schedule, ArrayList<Integer> foodOrders, ArrayList<parkTicket> tickets, ArrayList<SitDownReservation> reservations) {
        super(name, email, dateOfBirth);
        this.customerID = customerID;
        this.username = username;
        this.password = password;
        this.authentication = authentication;
        this.schedule = schedule;
        this.foodOrders = foodOrders;
        this.ticketsPurchased = tickets;
        this.ticketHolder = false;
        this.reservations = reservations;
    }

    public boolean addReservation(String name, String time, String date, int partySize) throws IOException{
        try
        {
            SitDownFoodVendorList vendors = new SitDownFoodVendorList();
            for (int i = 0; i < vendors.getSize(); i++){
                if(vendors.getVendor(i).getName().equals(name))
                {
                    vendors.getVendor(i).removeReservationTime(time);
                    vendors.updateList(vendors);
                    SitDownReservation res = new SitDownReservation(time, vendors.getVendor(i), date, partySize);
                    this.reservations.add(res);
                    return true;
                }
            }

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return false;
    }
    
    public int addToSchedule(int partySize, int attractionID) throws IOException {
        // System.out.println("AttractionID String: " + attractionID);
        int attID = attractionID;
        // System.out.println("AttractionID int: " + attID);
        AttractionsList currentAttractions = new AttractionsList();

        Attraction toSchedule = new Attraction();
        currentAttractions.getAttList();
        //changed this to .size
        if (partySize <= this.ticketsPurchased.size() && partySize > 0) {
            for (int i = 0; i < currentAttractions.getAttList().size(); i++) {
                if (attID == currentAttractions.getAtt(i).getAttractionID()) {
                    this.addToScheduleIfFound(partySize, attractionID);
                    return 0;
                    //String confirmation = ("You have added " + toSchedule.getName() + " to your schedule for a party of " + partySize + ".");
                }

            }
            //return this if no attraction found   
            return 1;
        } else {
            //return for party size issue for ticket issue.        
            return 2;
        }
    }

    public void addToScheduleIfFound(int partySize, int attractionID) throws IOException {

        //System.out.println("AttractionID String: " + attractionID);
        int attID = attractionID;
        //System.out.println("AttractionID int: " + attID);
        AttractionsList currentAttractions = new AttractionsList();

        Attraction toSchedule = new Attraction();
        currentAttractions.getAttList();
        //changed this to .size
        for (int i = 0; i < currentAttractions.getAttList().size(); i++) {
            if (attID == currentAttractions.getAtt(i).getAttractionID()) {
                toSchedule = currentAttractions.getAtt(i);
                toSchedule.setPartySize(partySize);
                this.addScheduledAttraction(toSchedule);
                toSchedule.increaseCapacity(partySize);
                System.out.println("This is the test ATT: " + toSchedule.toString());
                System.out.println("Size of Schedule: " + this.schedule.size());
            } else {
                System.out.println("Not Found");
            }

            //this.addScheduledAttraction(toSchedule);
            //toSchedule.increaseCapacity(partySize);
            //String confirmation = ("You have added " + toSchedule.getName() + " to your schedule for a party of " + partySize + ".");
        }

    }

    public boolean isTicketHolder() {
        if (ticketsPurchased.isEmpty()) {
            ticketHolder = false;
        } else {
            ticketHolder = true;
        }
        return ticketHolder;
    }

    public void addPurchasedTickets(ArrayList<parkTicket> tickets) {
        for (int i = 0; i < tickets.size(); ++i) {
            this.ticketsPurchased.add(tickets.get(i));
        }
    }

    public void createTicketOrder(String selectedDate, int quantity) {
        ArrayList<parkTicket> tickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            tickets.add(new parkTicket(selectedDate));
        }
        addPurchasedTickets(tickets);
    }

    public StringBuilder viewTicketsPurchased(ArrayList<parkTicket> tickets, int qty) {
        StringBuilder ticketList = new StringBuilder();
        double total = (qty * 59.99);
        ticketList.append("Purhcase Successful! you have purchased ");
        ticketList.append(qty);
        ticketList.append(" tickets for $");
        ticketList.append(total);
        ticketList.append("\nA receipt for this purchases and copies of the tickets have been sent to: ");
        ticketList.append(this.getEmail());
        for (int i = 0; i < tickets.size(); ++i) {
            ticketList.append("\n");
            ticketList.append(tickets.get(i).toString());
        }
        return ticketList;
    }

    public void addScheduledAttraction(Attraction active) {
        this.schedule.add(active);
    }

    /**
     * Get the customerID for person
     *
     * @return unique customer ID number assigned to account
     */
    public long getCustomerID() {
        return customerID;
    }

    /**
     * Set the customerID of person
     *
     * @param customerID set the unique customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Get the username for person
     *
     * @return String type username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username of person
     *
     * @param username set the username the user chooses
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password for person
     *
     * @return String type password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of person
     *
     * @param password set the password the user chooses
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the user's authentication
     *
     * @param username Provide the username for user
     * @param password Provide the password for the user
     * @return if the account has authentication
     */
    public boolean getAuthentication(String username, String password) {
        return authentication;
    }

    /**
     * Set the user's authentication
     *
     * @param authentication set the authentication for person
     */
    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }

    /**
     * Get the schedule for person
     *
     * @return ArrayList representing schedule
     */
    public ArrayList<Attraction> getSchedule() {
        return schedule;
    }

    /**
     * Set the schedule of person
     *
     * @param schedule set the schedule to be used by person
     */
    public void setSchedule(ArrayList<Attraction> schedule) {
        this.schedule = schedule;
    }

    public ArrayList<SitDownReservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<SitDownReservation> reservations) {
        this.reservations = reservations;
    }
    
    

    /**
     * Get the orders for person
     *
     * @return ArrayList representing orders
     */
    public ArrayList<Integer> getFoodOrders() {
        return foodOrders;
    }

    /**
     * Set the schedule of person
     *
     * @param foodOrders set the orders list to be used by person
     */
    public void setFoodOrders(ArrayList<Integer> foodOrders) {
        this.foodOrders = foodOrders;
    }

    public ArrayList<parkTicket> getTicketsPurchased() {
        return ticketsPurchased;
    }

    public void setTicketsPurchased(ArrayList<parkTicket> ticketsPurchased) {
        this.ticketsPurchased = ticketsPurchased;
    }

    /**
     * View the instance of the user's account
     *
     * @return Represents an UserAccount object as a string
     */
    @Override
    public String toString() {
        return super.toString() + " UserAccount{" + "customerID=" + customerID + ", username=" + username + ", password=" + password + ", authentication=" + authentication + ", schedule=" + schedule + ", foodOrders=" + foodOrders + '}';
    }

}
