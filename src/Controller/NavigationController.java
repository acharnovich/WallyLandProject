/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.UserAccount;
import View.NavigationView;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 * Controls the navigation, initiates controllers based on user actions.
 *
 * @author aic5588
 */
public class NavigationController {

    /**
     * This is the default constructor that initiates other controllers to open
     * user interfaces.
     */
    UserAccount activeUser;
    NavigationView navView;

    public NavigationController() {
        NavigationView navView = new NavigationView();
        navView.setVisible(true);
        addListeners(navView);

    }

    public NavigationController(UserAccount activeUser) {
        NavigationView navView = new NavigationView();
        navView.setVisible(true);

        this.activeUser = activeUser;
        addListeners(navView);

    }

    /**
     * Opens the UI for the user to purchase tickets.
     *
     * @param event will be pass as a parameter to initialize corresponding
     * controllers.
     */
    public void addListeners(NavigationView navView) {
        navView.getPurchaseButton().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                    PurchaseTicketController purch = new PurchaseTicketController(activeUser);
                    JComponent comp = (JComponent) e.getSource();
                   Window win = SwingUtilities.getWindowAncestor(comp);
                   win.dispose();
                

            }
        });
        if (activeUser.isTicketHolder() == true) {
            navView.getSchAttBtn().setEnabled(true);
            navView.getOrderBtn().setEnabled(true);
            navView.getReserveBtn().setEnabled(true);
            //navView.getSchAttBtn().addActionListener(this);
            //navView.getOrderBtn().addActionListener(this);
            // navView.getReserveBtn().addActionListener(this);
        }
    }

    /**
     * Opens the UI for the user to view food vendors.
     *
     * @param event will be pass as a parameter to initialize corresponding
     * controllers.
     */
    public void foodVendorButtonClicked() {
        FoodVendorController food = new FoodVendorController();
    }

    /**
     * Opens the UI for the user to view carry out order items.
     *
     * @param event will be passes as a parameter to initialized corresponding
     * controllers.
     */
    public void carryoutOrderButtonClicked(ActionEvent e) {
        CarryoutOrderController carryoutOrder = new CarryoutOrderController();
    }

    /**
     * Opens the UI for the user to view reservations at sit down restaurants
     *
     * @param event will be passes as a parameter to initialized corresponding
     * controllers.
     */

    public void reservationButtonClicked(ActionEvent e) {
        ReservationController reservation = new ReservationController();
    }

    /**
     * Opens the UI for the user to view their profile.
     *
     * @param event will be passes as a parameter to initialized corresponding
     * controllers.
     */
    public void profileButtonClicked() {
        UserActionController currentUser = new UserActionController();
        currentUser.addToScheduleClicked(4325345, "bobtest");
        currentUser.getScheduleButtonClicked();
    }

    public NavigationView getNavView() {
        return navView;
    }

    public void setNavView(NavigationView navView) {
        this.navView = navView;
    }

}
