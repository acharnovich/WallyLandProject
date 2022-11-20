package Model;

public class FoodVendorFactory {

    public static FoodVendor getFoodVendor(String type, String name, String description, String location, String hours){
        if("Carryout".equalsIgnoreCase(type)) return new CarryoutFoodVendor(name, description, location, hours);
        else if ("SitDown".equalsIgnoreCase(type)) return new SitDownFoodVendor(name, description, location, hours);
        else return null;
    }
}
