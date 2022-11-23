/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.util.ArrayList;
import Model.Attraction;

/**
 * This AttractionsList class will act as a database class to store attraction objects or retrieve them from a JSON file.
 * @author aic5588
 */
public class AttractionsList
{
private ArrayList<Attraction> attList;
/**
 * This is the all parameter constructor for AttractionsList. 
 * @param allAttractions accepts a ArrayList input of all attractions.
 */
public AttractionsList(ArrayList<Attraction> attList)
{
 this.attList = new ArrayList<Attraction>();
}
/**
 * This is the default constructor for AttractionsList.
 */
public AttractionsList()
{   
  Attraction attractionTest = new Attraction("TestAttraction","This is a test Attraction", "10-10-2022", 25, 10, 4325345, 10, 2);
 this.attList = new ArrayList<Attraction>();   
 attList.add(attractionTest);

   
}
/**
 * Returns the AllAttractions ArrayList.
 * @return A ArrayList representing all attraction objects stored.
 */

public String loadData(){
Attraction attractionTest = new Attraction("TestAttraction","This is a test Attraction", "10-10-2022", 25, 10, 4325345, 10, 2);

return attractionTest.toString();
}

public ArrayList<Attraction> getAttList() {
    return attList;
}

public void setAttList(ArrayList<Attraction> attList) {
    this.attList = attList;
}

public int getAttListSize(){
    return attList.size();
}

public Attraction getAtt(int i){
    return attList.get(i);
}



}