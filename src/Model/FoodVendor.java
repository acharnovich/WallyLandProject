package Model;

/**
 * Food Vendor super class, sets based attributes shared by all food vendors
 * @author ambd1
 */
public abstract class FoodVendor {
    private String name;
    private String location;
    private String hours;
    private String type;

    /**
     * default constructor for a food vendor object
     * @param name name of the food vendor
     * @param location address of the food vendor
     * @param hours hours of operation of the food vendor
     */
    public FoodVendor (String name, String location, String hours){
        this.name = name;
        this.location = location;
        this.hours = hours;
    }

    public FoodVendor() {
                this.name = name;
        this.location = location;
        this.hours = hours;
    }
    
    

    /**
     * retrieves the name of a Food Vendor
     * @return a String containing the name of the food vendor
     */
    public String getName() {//return name of the vendor
        return name;
    }

    /**
     * Sets the name of a Food Vendor
     * @param name String to be set as a food vendor object's name
     */
    public void setName(String name) {//sets name of the vendor
        this.name = name;
    }

    /**
     * retrieves the description of a Food Vendor
     * @return a String containing the description of a food vendor object
     */

    /**
     * retrieves the location of a Food Vendor
     * @return a String containing the location of a food vendor object
     */
    public String getLocation() {//return the location of a food vendor
        return location;
    }

    /**
     * Sets the hours of operation of a Food Vendor
     * @param location String to be set as a food vendor object's location
     */
    public void setLocation(String location) {//set the location of a food vendor
        this.location = location;
    }

    /**
     * retrieves the hours of operation of a Food Vendor
     * @return a String containing the hours of operation of a food vendor object
     */
    public String getHours() {//return the hours of operation of a food vendor
        return hours;
    }

    /**
     * Sets the hours of operation of a Food Vendor
     * @param hours String to be set as a food vendor object's hours of operation
     */
    public void setHours(String hours) {//set the hours of operation of a food vendor
        this.hours = hours;
    }

    /**
     * Prints the information contained in a food vendor object as a string
     * @return this information contained in a food vendor object as readable text
     */
    @Override
    public String toString() {
        return "FoodVendor{" +
                "name='" + name + '\'' +
                ", description='" +
                ", location='" + location + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }
}
