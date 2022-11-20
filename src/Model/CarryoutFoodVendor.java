package Model;

import java.util.ArrayList;

/**
 * Carryout food vendor object, extends FoodVendor. Allows for menu item quantity and carry out order placement
 * @author ambd1
 */
public class CarryoutFoodVendor extends FoodVendor {
    private ArrayList<CarryoutMenuItem> carryoutMenu; //list to hold carryout menu items

    /**
     * Constructor for carryout food vendors, implements carryout menu item list and sends common attributes to super class
     * @param name name of the food vendor
     * @param description short description of the food vendor
     * @param location address of the food vendor
     * @param hours hours of operation of the food vendor
     */
    public CarryoutFoodVendor (String name, String description, String location, String hours){
        super(name, description, location, hours);
        this.carryoutMenu = new ArrayList<CarryoutMenuItem>();
    }

    /**
     * Add a new item to a quick service vendors menu
     * @param toAdd menu item to be added
     */
    public void addItemToCarryoutMenu(CarryoutMenuItem toAdd) {
        this.carryoutMenu.add(toAdd);
    }

    /**
     * Removes an item from a quick service vendors menu
     * @param toRemove menu item to be removed
     */
    public void removeItemFromCarryoutMenu(CarryoutMenuItem toRemove){
        this.carryoutMenu.remove(toRemove);
    }

    /**
     * Prints the information contained in a carryout food vendor object as a string
     * @return this information contained in a carryout food vendor as readable text
     */
    @Override
    public String toString() {
        return super.toString() + " CarryoutFoodVendor{" +
                "carryoutMenu=" + carryoutMenu.toString() +
                '}';
    }
}
