package Controller;

import Model.FoodVendor;
import Model.SitDownFoodVendor;
import Model.SitDownFoodVendorList;
import Model.UserAccount;
import View.NavigationView;
import View.ReservationView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ReservationController {
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
                for(int i = 0; i < vendorList.getVendors().size(); i++){
                             System.out.println(reserveView.getRestTbl().getModel().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0));
                     System.out.println(vendorList.getVendors().get(i).getName());

                if(reserveView.getRestTbl().getModel().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).equals(vendorList.getVendors().get(i).getName()))
                restNameTemp = vendorList.getVendors().get(i);
              //System.out.println("This is the reserve controler times "+vendorList.getVendors().get(i));
                   }
                 reserveView.populateComboBox(restNameTemp);
            }



        });
    reserveView.getReserveBtn().addActionListener(
    new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    activeUser.addReservation(reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).toString(), reserveView.getTimeBox().getSelectedItem().toString(), reserveView.getReserveDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy")), (int) reserveView.getRestSpinner().getValue());
                    System.out.println(reserveView.getRestTbl().getValueAt(reserveView.getRestTbl().getSelectedRow(), 0).toString());
                    System.out.println(reserveView.getTimeBox().getSelectedItem().toString());
                    System.out.println(reserveView.getReserveDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy")));
                } catch (IOException ex) {
                    Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
              
                
            }
        }
    
    
    );
    
    }
}
