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
import java.time.format.DateTimeFormatter;
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

    public void addListeners(ReservationView reserveView, SitDownFoodVendorList vendorList) {
        
        reserveView.getRestTbl().addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                SitDownFoodVendor restNameTemp = new SitDownFoodVendor();
                for (int i = 0; i < vendorList.getVendors().size(); i++) {
                    System.out.println(reserveView.getRestTbl().getModel().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0));
                    System.out.println(vendorList.getVendors().get(i).getName());

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

                if (reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).equals("Something Special")) {
                    MenuView menu = new MenuView();
                    ImageIcon image = new ImageIcon(getClass().getResource("/View/Images/Beige And Green Simple Restaurant Menu.jpg"));

                    menu.dispose();
    
                    menu.getMenuPic().setIcon(null);
                    menu.getMenuPic().setIcon(image);
                    menu.revalidate();
                    menu.repaint();
                   
                    menu.setVisible(true);
                } if (reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).equals("Bistro du Wally")) {
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
                }
        

                //creates jframe f
                //JLabel lbl = new JLabel(image); //puts the image into a jlabel
                // menu.getContentPane().add(lbl); //puts label inside the jframe
                //makes the jframe visible
            }

        }
        );
        reserveView.getReserveBtn().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    activeUser.addReservation(reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).toString(), reserveView.getTimeBox().getSelectedItem().toString(), reserveView.getReserveDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy")), (int) reserveView.getRestSpinner().getValue());

                } catch (IOException ex) {
                    Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

    }

  
}
