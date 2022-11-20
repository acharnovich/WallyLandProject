package Model;

import java.util.ArrayList;

/**
 * creates a new carryout order from a QuickServiceFoodVendor, linked to a user account
 * @author ambd1
 */
public class CarryoutOrder {
    private ArrayList<CarryoutMenuItem> order;
    private Double total;
    private int orderID;
    private CarryoutFoodVendor vendor;

    /**
     * Starts a new carryout order from quick service food vendor
     * @param user the user account who is creating the order
     * @param vendor the vendor that is being ordered from
     */
    public CarryoutOrder (Person user, CarryoutFoodVendor vendor){
        this.order = new ArrayList<CarryoutMenuItem>();
        this.total = 0.00;
    }

    /**
     * Add an item to a carryout order. Save the item as part of the order list and adds item price to total.
     * @param toAdd Menu item to be added to order
     * @return current total of items contained in order
     */
    public Double addItemToOrder(CarryoutMenuItem toAdd){
        Double total =+ toAdd.getPrice();
        return total;
    }

    /**
     * finalize the carryout order and send it to the carryout order list
     */
    public void finalizeOrder(){

    }

}
