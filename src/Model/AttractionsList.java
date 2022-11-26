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
  Attraction att0 = new Attraction("Wally's Wacky Shack","A silly fun house for all ages!", "10-10-2022", 4, 0, 43253545, 8, 2);
  Attraction att1 = new Attraction("Generic Roller Coaster","It's a roller coaster....", "10-10-2022", 25, 10, 56835292, 10, 1);
  Attraction att2 = new Attraction("Log Ride","A classic log ride, big splashes and bigger smiles", "10-10-2022", 4, 0, 65845251, 6, 1); 
  this.attList = new ArrayList<Attraction>();
  attList.add(att0);
  attList.add(att1);
  attList.add(att2);

   
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