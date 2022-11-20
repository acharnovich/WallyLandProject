/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Attraction;
import View.AttractionView;
import java.util.ArrayList;
import Model.AttractionsList;
import java.util.Scanner;

/**
 ** The AttractionsController will control actions from attraction related views 
 * and pass them to the attraction model. This class will also interact with user profiles
 * to add attractions to their schedule.
 * @author aic5588
 */
public class AttractionsController
{
  private AttractionsList attractionsModel;
  private AttractionView attractionsView;

/**
 * This is the default constructor for AttractionsController.
 */
public AttractionsController()
{
  this.attractionsModel = new AttractionsList();
  this.attractionsView = new AttractionView();
  //attractionsView.displayAttractionTest(attractionsModel.loadData());
     addAttractionScheduleClicked();

/**
 * This is the all parameter constructor for AttractionsController.
 * @param attractionsModel accepts an attractionsList as input.
 * @param attractionsView accepts an AttractionView as input.
 */

  
}

/**
 * Returns an AttractionsList of AttractionsController.
 * @return A AttractionsList representing AttractionsModel.
 */
public AttractionsList getAttractionsModel()
{
  return attractionsModel;
}
/**
 * Sets the AttractionsModel for the AttractionsController.
 * @param attractionsModel sets the AttractionsList for AttractionsController.
 */
public void setAttractionsModel(AttractionsList attractionsModel)
{
  this.attractionsModel = attractionsModel;
}
/**
 * Returns the AttractionView of the AttractionsController.
 * @return A AttractionView representing attractionsView.
 */
public AttractionView getAttractionsView()
{
  return attractionsView;
}
/**
 * Sets the AttractionsView for the AttractionsController.
 * @param attractionsView sets the AttractionsView for AttractionsController.
 */
public void setAttractionsView(AttractionView attractionsView)
{
  this.attractionsView = attractionsView;
}
/**
 * Modifies the capacity of an attraction after user removes or adds attraction to schedule.
 * @param n Decreases or increases the current capacity for attractions. When a action takes place, this will call the attraction class.
 * 
 */
public void setCurrentCapacity(int n){

}
public void addAttractionScheduleClicked(){
    UserActionController addToProfile = new UserActionController();
    addToProfile.addToScheduleClicked(4325345, "bobtest");
   // attractionsView.displayAddedToProfileTest("Test Attraction");



}

}
