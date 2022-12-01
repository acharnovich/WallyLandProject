/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ambd1
 */

public class SitDownFoodVendorList {
 private ArrayList<SitDownFoodVendor> vendors;

    public SitDownFoodVendorList(ArrayList<SitDownFoodVendor> vendors) {
        this.vendors = vendors;
    }

    public SitDownFoodVendorList() {
    }

    public ArrayList<SitDownFoodVendor> getVendors() {
        return vendors;
    }

    public void setVendors(ArrayList<SitDownFoodVendor> vendors) {
        this.vendors = vendors;
    }
 
 
}
