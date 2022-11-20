
package Controller;
import Model.*;
import View.AttractionView;
import View.ProfileView;

import java.util.ArrayList;
/**
 * This controller enables the to perform actions such schedule attractions, reservations, and purchase tickets. 
 * This class modifies the user profile that is currently logged in.
 * @author tpn352
 */
public class UserActionController {
/**
 * This is the default constructor that will be used to initiate variables and other controllers to pass user actions.
 */
ProfileList profileList = new ProfileList();
public UserActionController()
    {

    }

    public UserActionController(ProfileList profileList)
    {
        this.profileList = profileList;
    }

    /**
 * This method removes attractions from a user profile schedule.
 * @param attractionID represents the ID of an event to be removed from user profile.
 */
  public void removeFromScheduleButtonClicked(int attractionID)
{
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}

/**
 * Method to initiate adding event to schedule 
 * @param eventID unique ID of the event
 */
public void addToScheduleClicked(int eventID, String userID)
{
    //userID will be in for loop, if userID equals a userID found in profile list, add this eventID to that profile.
    System.out.println("Starting user action view schedule test.");
    //profileList.getAccountList().get(0).getSchedule().add(eventID);


}

    /**
     * Returns an ArrayList of integers that represent the id's of all events scheduled.
     * @return A ArrayList representing the schedule of attractions for a user profile.
     */
    public void getScheduleButtonClicked()
   {
        ProfileView profileView = new ProfileView();
ArrayList<Attraction> profileAttractions = new ArrayList<Attraction>();
AttractionsList attractionsList = new AttractionsList();
       for (int i = 0; i < attractionsList.getAllAttractions().size(); i++){
           for (int x = 0; x < profileList.getAccountList().get(0).getSchedule().size(); x++){
               if(profileList.getAccountList().get(i).getSchedule().get(x).equals(attractionsList.getAllAttractions().get(i).getAttractionID())){
                   profileAttractions.add(attractionsList.getAllAttractions().get(i));
               }
           }

       }
       profileView.displaySchedule(profileAttractions);

   }

/**
 * Method to initiate order 
 * @param orderID unique ID of the order
 */
public void addToOrdersClicked(int orderID)
{
}

}
