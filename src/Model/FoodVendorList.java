package Model;

import java.util.ArrayList;

/**
 * FoodVendorList stores and retrieves all available food vendor items. Also allows for removal of food vendors from the list.
 * @author ambd1
 */
public class FoodVendorList {
    private ArrayList<FoodVendor> FoodVendorList; //List containing all food vendor objects

    /**
     * All parameter constructor for the food vendor list.
     * @param FoodVendors input of food vendor object types
     */
    public void FoodVendorList(ArrayList<FoodVendor> FoodVendors){
        this.FoodVendorList = FoodVendors;
    }
/**
 * This is the default constructor for FoodVendorList.
 */
    public FoodVendorList()
    {
        this.FoodVendorList = FoodVendorList;
    }
    
    

    /**
     * retrieves the array list containing the food vendors available at the park
     * @return an array list containing the food vendor objects that have been added to the park app
     */
    public ArrayList<FoodVendor> getFoodVendorList() {
        return FoodVendorList;
    }

    /**
     * sets the food vendor list
     * @param foodVendorList array list of food vendor objects to be set as the list of food vendors available at the park
     */
    public void setFoodVendorList(ArrayList<FoodVendor> foodVendorList) {
        FoodVendorList = foodVendorList;
    }

    /**
     * removes a food vendor object from the list of food vendors available at the park
     * @param toRemove the food vendor object to be removed
     */
    public void removeFoodVendor(FoodVendor toRemove){
        this.FoodVendorList.remove(toRemove);
    }

    /**
     * adds a food vendor object to the list of food vendors available at the park
     * @param toAdd the food vendor object to be added
     */
    public void addFoodVendor(FoodVendor toAdd){
        this.FoodVendorList.add(toAdd);
    }

    /**
     * Prints the information contained in the food vendor array list
     * @return this information contained in the food vendor array list
     */
    @Override
    public String toString() {
        return "FoodVendorList{" +
                "FoodVendorList=" + FoodVendorList +
                '}';
    }

    /**
     * TestHarness Method for carryout food vendor object
     */

    public String loadCarryoutVendorData() {
        CarryoutFoodVendor testCarryoutVendor = new CarryoutFoodVendor("Timmy's Tacos", "Best taco joint in town!", "9999 Awesome St.", "12pm - 10pm Tuesday-Sunday");
        CarryoutMenuItem foobar = new CarryoutMenuItem("Timmy's Foobar Burger", "I thought this was a taco joint??", 13.49, 99);
        testCarryoutVendor.addItemToCarryoutMenu(foobar);
        return testCarryoutVendor.toString();
    }

    /**
     * TestHarness Method for sit down food vendor object
     */
    public String loadSitDownVendorData() {
        SitDownFoodVendor testSitDownFoodVendor = new SitDownFoodVendor("Super Classy Restaurant", "Our Food is Small and Over Priced!", "100 Swag St.", "12pm - 10pm Friday-Sunday");
        SitDownMenuItem swagMeal = new SitDownMenuItem("Super Swag Dinner", "Not too tasty but covered in Gold!", "2 hours", 49.99);
        testSitDownFoodVendor.addItem(swagMeal);
        return testSitDownFoodVendor.toString();
    }
}

