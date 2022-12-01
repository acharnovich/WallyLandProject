/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ambd1
 */

public class SitDownFoodVendorList {
 private ArrayList<SitDownFoodVendor> vendors;
    
    public SitDownFoodVendorList() throws IOException{
    this.vendors = new ArrayList<SitDownFoodVendor>();
    SitDownFoodVendor v1 = new SitDownFoodVendor("V1", "Location", "11:00am - 10:00pm", "$$$");
    String[] list = {"10:00am", "10:30am", "11:00am", "11:30am", "12:00pm", "12:30pm", "!:00pm", "1:30pm", "2:00pm", "2:30pm", "3:00pm", "3:30pm", "4:00pm", "4:30pm", "5:00pm", "5:30pm", "6:00pm", "6:30pm", "7:00pm", "7:30pm", "8:00pm", "8:30pm", "9:00pm", "9:30pm"};
    ArrayList<String> times = new ArrayList<>();
    Collections.addAll(times, list);
    
    v1.setReservationTimes(times);
    SitDownFoodVendor v2 = new SitDownFoodVendor("V2", "Location", "11:00am - 9:00pm", "$$$");
    
    times.remove("9:30pm");
    times.remove("9:00pm");
    v2.setReservationTimes(times);
    
    SitDownFoodVendor v3 = new SitDownFoodVendor("V3", "Location", "12:00pm - 10:00pm", "$$$");

    times.add("9:30pm");
    times.add("9:00pm");
    times.remove("11:00am");
    times.remove("11:30am");
    times.remove("5:30pm");
    v3.setReservationTimes(times);
    
    SitDownFoodVendor v4 = new SitDownFoodVendor("V4", "Location", "Hours", "$$$");
    v4.setReservationTimes(times);
    SitDownFoodVendor v5 = new SitDownFoodVendor("V5", "Location", "Hours", "$$$");
    v5.setReservationTimes(times);
    
    this.vendors.add(v1);
    this.vendors.add(v2);
    this.vendors.add(v3);
    this.vendors.add(v4);
    this.vendors.add(v5);
    System.out.println(vendors.toString());
    //Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //gson.toJson(foodVendors, new FileWriter("/Users/ambd1/OneDrive/Documents/GitHub/WallyLandProject412/sitDownFood.json"));
  
    /**
     *   Gson gson = new Gson();
    try{

        Reader reader = Files.newBufferedReader(Paths.get("sitDownFood.json"));

        ArrayList<SitDownFoodVendor> rList = new Gson().fromJson(reader, new TypeToken<ArrayList<SitDownFoodVendor>>()
        {
        }.getType());
            
        for(int i = 0; i < rList.size(); ++i){
            this.foodVendors.add(rList.get(i));
        }      
        reader.close();
    } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

     */
       
    }


    public ArrayList<SitDownFoodVendor> getVendors() {
        return vendors;
    }

    public void setVendors(ArrayList<SitDownFoodVendor> vendors) {
        this.vendors = vendors;
    }
 
 
}
