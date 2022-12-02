package Controller;

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

public class ReservationController {
    UserAccount activeUser;

    public ReservationController(NavigationView navView, UserAccount activeUser) throws IOException {
         SitDownFoodVendorList vendorList = new SitDownFoodVendorList();
        this.activeUser = activeUser;
        ReservationView reserveView = new ReservationView(vendorList.getVendors());
        navView.remove(navView.getMainPanel());
        navView.getContentPane().add(reserveView);
        navView.revalidate();
        navView.setVisible(true);
    

        addListeners(reserveView, vendorList);
    }

    public void addListeners(ReservationView reserveView, SitDownFoodVendorList vendorList) {
        reserveView.getRestTbl().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
     
                for(int i = 0; i < vendorList.getVendors().size(); i++){
                if(reserveView.getRestTbl().getSelectedRow() == vendorList.getVendors().indexOf(i))
             
                System.out.println("This is the reserve controler times "+vendorList.getVendors().get(i));
                    reserveView.populateComboBox(vendorList.getVendors().get(i));
                }
            }



        });
    }
}
