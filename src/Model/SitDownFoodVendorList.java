/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import Model.SitDownFoodVendor;
import java.io.Writer;


public class SitDownFoodVendorList {
 private ArrayList<SitDownFoodVendor> vendors;

    public SitDownFoodVendorList(ArrayList<SitDownFoodVendor> vendors) {
        this.vendors = new ArrayList<SitDownFoodVendor>();
    }
    
    public SitDownFoodVendorList() throws IOException{
    
    
    this.vendors = new ArrayList<SitDownFoodVendor>();
    Gson gson = new Gson();
    try{

        Reader reader = Files.newBufferedReader(Paths.get("sitDownFood.json"));

        ArrayList<SitDownFoodVendor> rList = new Gson().fromJson(reader, new TypeToken<ArrayList<SitDownFoodVendor>>()
        {
        }.getType());
            
        for(int i = 0; i < rList.size(); ++i){
            this.vendors.add(rList.get(i));
        }      
        reader.close();
    } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void updateList()
    {
        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("sitDownFood.json"));
            gson.toJson(this, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }

    public ArrayList<SitDownFoodVendor> getVendors() {
        return vendors;
    }

    public void setVendors(ArrayList<SitDownFoodVendor> vendors) {
        this.vendors = vendors;
    }
    
    public int getSize(){
        return vendors.size();
    }
    
    public SitDownFoodVendor getVendor(int i){
        SitDownFoodVendor active = new SitDownFoodVendor();
        active = vendors.get(i);
        return active;
    }
 
 
}