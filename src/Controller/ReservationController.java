package Controller;

import Model.FoodVendor;
import Model.SitDownFoodVendor;
import Model.SitDownFoodVendorList;
import Model.UserAccount;
import View.MenuView;
import View.NavigationView;
import View.ReservationView;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ReservationController {

    String tempName;
    UserAccount activeUser;

    public ReservationController(NavigationView navView, UserAccount activeUser) throws IOException {
        SitDownFoodVendorList vendorList = new SitDownFoodVendorList();
        this.activeUser = activeUser;
        ReservationView reserveView = new ReservationView(vendorList.getVendors());
        //navView.getContentPane().remove(navView.getMainPanel());
        //  navView.getContentPane().add(reserveView);
        navView.getMainPanel().removeAll();
        navView.getMainPanel().add(reserveView);
        navView.getMainPanel().repaint();
        navView.getMainPanel().revalidate();
        navView.getMainPanel().setVisible(true);

        addListeners(reserveView, vendorList);
    }

    public boolean validateDate(String selectedDate) {
        //validDate = purchView.getDateTxt().getDate().format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
        Date date;

        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        date = null;
        formatter.setLenient(false);
        try {
            date = formatter.parse(selectedDate);
            return true;
        } catch (Exception formatDate) {
            return false;
        }

    }

    public void addListeners(ReservationView reserveView, SitDownFoodVendorList vendorList) {

        reserveView.getRestTbl().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                SitDownFoodVendor restNameTemp = new SitDownFoodVendor();
                for (int i = 0; i < vendorList.getVendors().size(); i++) {
                    if (reserveView.getRestTbl().getModel().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).equals(vendorList.getVendors().get(i).getName())) {
                        restNameTemp = vendorList.getVendors().get(i);
                    }
                    //System.out.println("This is the reserve controler times "+vendorList.getVendors().get(i));
                }

                reserveView.populateComboBox(restNameTemp);
            }

        }
        );

        reserveView.getMenuBtn().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(reserveView.getRestTbl().getSelectedRow() < 0){
                                         JOptionPane.showMessageDialog(null, "Please make sure an attraction is selected.", "Error", JOptionPane.ERROR_MESSAGE);
                 }
                 else{
                if (reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).equals("Something Special")) {
                    MenuView menu = new MenuView();
                    ImageIcon image = new ImageIcon(getClass().getResource("/View/Images/Beige And Green Simple Restaurant Menu.jpg"));

                    menu.dispose();

                    menu.getMenuPic().setIcon(null);
                    menu.getMenuPic().setIcon(image);
                    menu.revalidate();
                    menu.repaint();

                    menu.setVisible(true);
                }
                if (reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).equals("Bistro du Wally")) {
                    MenuView menu = new MenuView();
                    ImageIcon image = new ImageIcon(getClass().getResource("/View/Images/Black and Orange Restaurant Menu .jpg"));

                    menu.dispose();
                    menu.getMenuPic().setIcon(image);
                    menu.repaint();
                    menu.revalidate();
                    menu.setVisible(true);
                }

                if (reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).equals("Swagalicious Dinning")) {
                    MenuView menu = new MenuView();
                    ImageIcon image = new ImageIcon(getClass().getResource("/View/Images/Beige and Green Floral Wedding Menu.jpg"));

                    menu.dispose();
                    menu.getMenuPic().setIcon(image);
                    menu.repaint();
                    menu.revalidate();
                    menu.setVisible(true);
                }

                if (reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).equals("Wally's Quick Burger")) {
                    MenuView menu = new MenuView();
                    ImageIcon image = new ImageIcon(getClass().getResource("/View/Images/Black & Orange Creative Modern Fast Food Menu.jpg"));

                    menu.dispose();
                    menu.getMenuPic().setIcon(image);
                    menu.repaint();
                    menu.revalidate();
                    menu.setVisible(true);
                }

                if (reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).equals("Head Rush Café")) {
                    MenuView menu = new MenuView();
                    ImageIcon image = new ImageIcon(getClass().getResource("/View/Images/Dark Rustic Chalkboard Texture Cafe Menu.jpg"));

                    menu.dispose();
                    menu.getMenuPic().setIcon(image);
                    menu.repaint();
                    menu.revalidate();
                    menu.setVisible(true);
                }}
            }

        }
        );
        reserveView.getReserveBtn().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reserveView.getRestTbl().getSelectedRow() < 0 || reserveView.getTimeBox().getSelectedItem().equals(null) || reserveView.getReserveDateTxt().getDate()==null) {
                    JOptionPane.showMessageDialog(null, "Please make sure a reservation, time, and date is selected.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String dateFormat = reserveView.getReserveDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy"));

                    if (validateDate(dateFormat) == false) {
                        JOptionPane.showMessageDialog(reserveView,
                                "Invalid Date Format. Please enter date as "
                                + "\n MM / DD / YY", "Date Format Mismatch",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        LocalDate today = LocalDate.now();
                        LocalDate enteredDate = reserveView.getReserveDateTxt().getDate();
                        if (enteredDate.isBefore(today)) {
                            JOptionPane.showMessageDialog(reserveView,
                                    "Please select today's date or a future date",
                                     "Invalid Date",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                        try {
                             if((int) reserveView.getRestSpinner().getValue() <= activeUser.getTicketsPurchased().size()){
                            activeUser.addReservation(reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).toString(), reserveView.getTimeBox().getSelectedItem().toString(), reserveView.getReserveDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy")), (int) reserveView.getRestSpinner().getValue());
                            JOptionPane.showMessageDialog(null, "This reservation was scheduled successfully. You have added \n" + reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).toString() + " to your schedule for a party of " + reserveView.getRestSpinner().getValue() + " at " + reserveView.getTimeBox().getSelectedItem().toString() + " of " + reserveView.getReserveDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy")), "Reservation Scheduled!", JOptionPane.PLAIN_MESSAGE);
                            reserveView.setVisible(false);
                            JComponent comp = (JComponent) e.getSource();
                            Window win = SwingUtilities.getWindowAncestor(comp);
                            win.dispose();
                            NavigationController navController = new NavigationController(activeUser);
                             }else{
                           JOptionPane.showMessageDialog(null, "Make sure the party size is less than tickets purchased for the day.", "Reservation Error" ,JOptionPane.ERROR_MESSAGE);

                             }
                        } catch (IOException ex) {
                            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
                        }}

                    }
                }
            }
        }
        );

    }

}
