/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Attraction;
import View.AttractionView;
import java.util.ArrayList;
import Model.AttractionsList;
import Model.UserAccount;
import View.NavigationView;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 ** The AttractionsController will control actions from attraction related views 
 * and pass them to the attraction model. This class will also interact with user profiles
 * to add attractions to their schedule.
 * @author aic5588
 */
public class AttractionsController
{
UserAccount activeUser;

/**
 * This is the default constructor for AttractionsController.
 */
public AttractionsController(NavigationView navView, UserAccount activeUser)
{
   AttractionsList attractionsModel = new AttractionsList();
    AttractionView att = new AttractionView(attractionsModel.getAttList());
                 navView.remove(navView.getMainPanel());
               navView.getContentPane().add(att);
               navView.revalidate();
               navView.setVisible(true);
               this.activeUser = activeUser;


  addListeners(att);
  
}

    public void addListeners(AttractionView att) {
        att.getScheduleBtn().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            att.getAttractionTable().getSelectedRow();
            System.out.print(att.getAttractionTable().getSelectedRow());
            String confirmation = activeUser.addToSchedule((int) att.getPartySpinner().getValue(), att.getAttractionTable().getModel().getValueAt(att.getAttractionTable().getSelectedRow(),0).toString());
               JOptionPane.showMessageDialog(null, confirmation,"Attraction Scheduled!",JOptionPane.PLAIN_MESSAGE);
            }
        });

    }


public ArrayList<Attraction> getAllAttractions(ArrayList<Attraction> attList)
{
    return (ArrayList<Attraction>) attList;
}
/**
 * Returns an AttractionsList of AttractionsController.
 * @return A AttractionsList representing AttractionsModel.
 */

/**
 * Sets the AttractionsModel for the AttractionsController.
 * @param attractionsModel sets the AttractionsList for AttractionsController.
 */

/**
 * Modifies the capacity of an attraction after user removes or adds attraction to schedule.
 * @param n Decreases or increases the current capacity for attractions. When a action takes place, this will call the attraction class.
 * 
 */
public void setCurrentCapacity(int n){

}


}
