package Controller;

import Model.ProfileList;
import Model.UserAccount;
import Model.parkTicket;
import View.PurchaseTicketView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import Controller.NavigationController;
import View.NavigationView;
import java.awt.Window;
import javax.swing.JComponent;


import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *Controls the purchase of park tickets by user.
 * @author tpn5232
 */
public class PurchaseTicketController implements ActionListener {
    NavigationController navController;
    NavigationView navView = new NavigationView();
    private parkTicket ticketModel;
    PurchaseTicketView purchView = new PurchaseTicketView();
    UserAccount activeUser;
    Date date;
    String validDate;
    String email;
    Boolean emailCheck;
 
    /**
     * This is the default constructor used to instantiate the ticket object and the ticket view
     */
    public PurchaseTicketController(){
       purchView.setVisible(true);
       purchView.getPurchaseTicketBtn().addActionListener(this);
          this.navController = navController;
        this.navView = navView;
        this.ticketModel = ticketModel;
        this.activeUser = activeUser;
        this.validDate = validDate;
  
    }
    
    public PurchaseTicketController(UserAccount activeUser){ 
       this.activeUser = activeUser;
       purchView.setVisible(true);
       purchView.getPurchaseTicketBtn().addActionListener(this);
       this.navView = navView;
    }

    public PurchaseTicketController(NavigationController navController, NavigationView navView, parkTicket ticketModel, UserAccount activeUser, String validDate) {
        this.navController = navController;
        this.navView = navView;
        this.ticketModel = ticketModel;
        this.activeUser = activeUser;
        this.validDate = validDate;
    }
    
    
    public boolean validateDate(String selectedDate){
    DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
           date = null;
           formatter.setLenient(false);
           try{
            date = formatter.parse(selectedDate);
            return true;
        }
        catch(Exception formatDate){
            return false;
       }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if (validateDate(purchView.getDateTxt().getText()) == false){
           JOptionPane.showMessageDialog(purchView,
                       "Invalid Date Format. Please enter date as "
                               + "\n MM / DD / YY","Date Format Mismatch",
                       JOptionPane.ERROR_MESSAGE);
        }else {
       validDate =  purchView.getDateTxt().getText();
       //validDate = date.toString();
      }
      
      if (purchView.getEmailTxt().getText().equals(activeUser.getEmail())){
       email = purchView.getEmailTxt().getText();
       emailCheck = true;
      }else{
          JOptionPane.showMessageDialog(null, "Email does not match active user. Please enter registered email account for verification.");
          emailCheck = false;}
      
        if (emailCheck == true && validateDate(validDate) == true){

            activeUser.createTicketOrder(validDate, Integer.parseInt(purchView.getQtyTxt().getText()));
            JOptionPane.showMessageDialog(null, activeUser.viewTicketsPurchased(activeUser.getTicketsPurchased(), Integer.parseInt(purchView.getQtyTxt().getText())));  
             JComponent comp = (JComponent) e.getSource();
   Window win = SwingUtilities.getWindowAncestor(comp);
   win.dispose();
      NavigationController navController = new NavigationController(activeUser);
      
        }
        /*
        else{
           JOptionPane.showMessageDialog(null, "Email does not match active user. Please enter registered email account for verification.");
        }
       */
    }
    
    
    public void purchaseTicketBtnClicked(String email, String qty, String date){
    
    }

    public NavigationController getNavController() {
        return navController;
    }

    public void setNavController(NavigationController navController) {
        this.navController = navController;
    }

    public NavigationView getNavView() {
        return navView;
    }

    public void setNavView(NavigationView navView) {
        this.navView = navView;
    }

    public parkTicket getTicketModel() {
        return ticketModel;
    }

    public void setTicketModel(parkTicket ticketModel) {
        this.ticketModel = ticketModel;
    }

    public PurchaseTicketView getPurchView() {
        return purchView;
    }

    public void setPurchView(PurchaseTicketView purchView) {
        this.purchView = purchView;
    }

    public UserAccount getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(UserAccount activeUser) {
        this.activeUser = activeUser;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }


}
