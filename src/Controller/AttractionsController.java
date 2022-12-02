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
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 ** The AttractionsController will control actions from attraction related
 * views and pass them to the attraction model. This class will also interact
 * with user profiles to add attractions to their schedule.
 *
 * @author aic5588
 */
public class AttractionsController {

    UserAccount activeUser;

    /**
     * This is the default constructor for AttractionsController.
     */
    public AttractionsController(NavigationView navView, UserAccount activeUser) throws IOException {
        AttractionsList attractionsModel = new AttractionsList();
        AttractionView att = new AttractionView(attractionsModel.getAttList());
        //navView.getContentPane().remove(navView.getMainPanel());
        navView.getMainPanel().removeAll();
        navView.getMainPanel().add(att);
        navView.repaint();
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
                if ((int) att.getPartySpinner().getValue() > 0 && att.getAttractionTable().getSelectedRow() >= 0) {

                    try {
                        if (activeUser.addToSchedule((int) att.getPartySpinner().getValue(), Integer.valueOf(att.getAttractionTable().getModel().getValueAt(att.getAttractionTable().getSelectedRow(), 0).toString())) == 0) {
                            JOptionPane.showMessageDialog(null, "This attraction was added successfully. You have added \n" + att.getAttractionTable().getModel().getValueAt(att.getAttractionTable().getSelectedRow(), 1).toString() + " to your schedule for a party of " + att.getPartySpinner().getValue() + ".", "Attraction Scheduled!", JOptionPane.PLAIN_MESSAGE);
                        } else if (activeUser.addToSchedule((int) att.getPartySpinner().getValue(), Integer.valueOf(att.getAttractionTable().getModel().getValueAt(att.getAttractionTable().getSelectedRow(), 0).toString())) == 1) {
                            JOptionPane.showMessageDialog(null, "Attraction not found or no longer available.", "Attraction Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(AttractionsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else try {
                    if (activeUser.addToSchedule((int) att.getPartySpinner().getValue(), Integer.valueOf(att.getAttractionTable().getModel().getValueAt(att.getAttractionTable().getSelectedRow(), 0).toString())) == 2) {
                        JOptionPane.showMessageDialog(null, "Please make sure party size is greater than 0, not greater than tickets purchased, and an attraction is selected.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AttractionsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public ArrayList<Attraction> getAllAttractions(ArrayList<Attraction> attList) {
        return (ArrayList<Attraction>) attList;
    }

    /**
     * Returns an AttractionsList of AttractionsController.
     *
     * @return A AttractionsList representing AttractionsModel.
     */

    /**
     * Sets the AttractionsModel for the AttractionsController.
     *
     * @param attractionsModel sets the AttractionsList for
     * AttractionsController.
     */
    /**
     * Modifies the capacity of an attraction after user removes or adds
     * attraction to schedule.
     *
     * @param n Decreases or increases the current capacity for attractions.
     * When a action takes place, this will call the attraction class.
     *
     */
    public void setCurrentCapacity(int n) {

    }

}
