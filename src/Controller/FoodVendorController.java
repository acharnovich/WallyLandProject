package Controller;

import Model.FoodVendorList;
import View.FoodVendorView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 ** The FoodVendorController will control actions from food vendor related views
 * and pass them to the food vendor model. This class will also interact with user profiles
 * to add reservations to their schedule and add carry out orders to their profiles.
 * @author ambd1
 */
public class FoodVendorController {

    FoodVendorList foodVendorModel;
    private FoodVendorView foodVendorView;

    /**
     * This is the all parameter constructor for FoodVendorController.
     * @param foodVendorModel accepts a foodVendorList as input.
     * @param foodVendorView accepts a foodVendorView as input.
     */
    public FoodVendorController(FoodVendorList foodVendorModel, FoodVendorView foodVendorView) {
        this.foodVendorModel = foodVendorModel;
        this.foodVendorView = foodVendorView;
    }

    public FoodVendorController()
    {
        this.foodVendorModel = new FoodVendorList();
        this.foodVendorView = new FoodVendorView();
        System.out.println("Starting Food Vendor System test:");
        System.out.println("The Food Vendor Controller was successfully initiated!");
        foodVendorView.displayCarryoutFoodVendorTest(foodVendorModel.loadCarryoutVendorData());
        foodVendorView.displaySitDownFoodVendorTest(foodVendorModel.loadSitDownVendorData());
    }

    /**
     * Returns a FoodVendorList of FoodVendorController.
     *
     * @return A FoodVendorList representing FoodVendorModel.
     */
    public FoodVendorList getFoodVendorModel()
    {
        return foodVendorModel;
    }
    /**
     * Sets the FoodVendorModel for the FoodVendorController.
     * @param foodVendorModel sets the FoodVendorList for FoodVendorController.
     */
    public void setFoodVendorModel(FoodVendorList foodVendorModel)
    {
        this.foodVendorModel = foodVendorModel;
    }
    /**
     * Returns the FoodVendorView of the FoodVendorController.
     * @return A FoodVendorView representing foodVendorView.
     */
    public FoodVendorView getFoodVendorView()
    {
        return foodVendorView;
    }
  

}
