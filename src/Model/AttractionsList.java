/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 * This AttractionsList class will act as a database class to store attraction objects or retrieve them from a JSON file.
 * @author aic5588
 */
public class AttractionsList
{
ArrayList<Attraction> allAttractions = new ArrayList<Attraction>();
/**
 * This is the all parameter constructor for AttractionsList. 
 * @param allAttractions accepts a ArrayList input of all attractions.
 */
public AttractionsList(ArrayList<Attraction> allAttractions)
{
 this.allAttractions = allAttractions;
}
/**
 * This is the default constructor for AttractionsList.
 */
public AttractionsList()
{
this.allAttractions = getAllAttractions();
    Attraction attractionTest = new Attraction("TestAttraction","This is a test Attraction", "10-10-2022", 25, 10, 4325345, 10, 2);
   getAllAttractions().add(attractionTest);

}
/**
 * Returns the AllAttractions ArrayList.
 * @return A ArrayList representing all attraction objects stored.
 */

public String loadData(){
Attraction attractionTest = new Attraction("TestAttraction","This is a test Attraction", "10-10-2022", 25, 10, 4325345, 10, 2);

return attractionTest.toString();
}
public ArrayList<Attraction> getAllAttractions()
{
    return (ArrayList<Attraction>) allAttractions;
}

public void addAttraction(Attraction newAttraction){
    getAllAttractions().add(newAttraction);
}
/**
 * Sets the allAttractions for AttractionsList. 
 * @param allAttractions sets allAttractions ArrayList for AttractionsList.
 */
public void setAllAttractions(ArrayList<Attraction> allAttractions)
{
    this.allAttractions = allAttractions;

}

public int getLength(){
    return this.allAttractions.size();
}

public Attraction getAttraction(int i){
    return this.allAttractions.get(i);
}
    
}