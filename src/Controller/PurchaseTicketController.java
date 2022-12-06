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
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Window;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    LocalDate today;
    Date date;
    String dateFormat;
    Boolean dateCheck;
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
       addListeners(purchView, navView);
    }

    public PurchaseTicketController(NavigationController navController, NavigationView navView, parkTicket ticketModel, UserAccount activeUser, String validDate) {
        this.navController = navController;
        this.navView = navView;
        this.ticketModel = ticketModel;
        this.activeUser = activeUser;
        this.validDate = validDate;
    }
    
    public void addListeners(PurchaseTicketView purchView, NavigationView navView){
    purchView.getCancelBtn().addActionListener(       new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             purchView.setVisible(false);
             purchView.dispose();
             NavigationController nav = new NavigationController(activeUser);   

            }
        });
    
    
    }
    public boolean validateDate(String selectedDate){
        //validDate = purchView.getDateTxt().getDate().format(DateTimeFormatter.ofPattern("uuuu-MM-dd"));
        
    
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
        
        //Check if Date field is empty, else get the date entereed and validate format
        
        if (purchView.getDateTxt().getDate() == null){
        JOptionPane.showMessageDialog(purchView,
                       "Please fill out all fields in the form"
                               ,"Missing Date",
                       JOptionPane.ERROR_MESSAGE);
        }else{
            today = LocalDate.now();
            LocalDate enteredDate = purchView.getDateTxt().getDate();
            if (enteredDate.isBefore(today)){
            JOptionPane.showMessageDialog(purchView,
                       "Please select today's date or a future date"
                               ,"Invalid Date",
                       JOptionPane.ERROR_MESSAGE);
            }else{
            dateFormat = purchView.getDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy"));
            if(validateDate(dateFormat) == false){
                JOptionPane.showMessageDialog(purchView,
                           "Invalid Date Format. Please enter date as "
                                   + "\n MM / DD / YY","Date Format Mismatch",
                           JOptionPane.ERROR_MESSAGE);
            }
            }
        }
        
        //Check if Date is fomatted correctly, then check if email field is empty.
        //If date and email are entered, check if email matches user.  
        
        if(validateDate(dateFormat) == true){
            validDate = purchView.getDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy"));
            if (purchView.getEmailTxt().getText().isBlank()){
            JOptionPane.showMessageDialog(purchView,
                       "Please fill out all fields in the form"
                               ,"Missing Information",
                       JOptionPane.ERROR_MESSAGE);
            }else{
                email = purchView.getEmailTxt().getText();
                    if (email.equals(activeUser.getEmail())){

                    emailCheck = true;
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "Email does not match active user. Please enter registered email account for verification.");
                        emailCheck = false;}
                        
                        //If email matches, display ticket.   
                        if (emailCheck == true ){

                            activeUser.createTicketOrder(validDate, Integer.parseInt(purchView.getQtyTxt().getValue().toString()));
                            JOptionPane.showMessageDialog(null, activeUser.viewTicketsPurchased(activeUser.getTicketsPurchased(), Integer.parseInt(purchView.getQtyTxt().getValue().toString())));  
                            JComponent comp = (JComponent) e.getSource();
                            Window win = SwingUtilities.getWindowAncestor(comp);
                            win.dispose();
                            NavigationController navController = new NavigationController(activeUser);

                        }
                }
        }
        
        
        
     /*
        if (purchView.getEmailTxt().getText().isBlank() ||  
              purchView.getDateTxt().getDate().equals("")) 
      {
          JOptionPane.showMessageDialog(purchView,
                       "Please fill out all fields in the form"
                               ,"Missing Information",
                       JOptionPane.ERROR_MESSAGE);
      }
      else{
      //validDate = purchView.getDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy"));
      }
         
      if (validateDate(purchView.getDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy"))) == false){
           JOptionPane.showMessageDialog(purchView,
                       "Invalid Date Format. Please enter date as "
                               + "\n MM / DD / YY","Date Format Mismatch",
                       JOptionPane.ERROR_MESSAGE);
        }else {
       validDate =  purchView.getDateTxt().getDate().format(DateTimeFormatter.ofPattern("MM/dd/yy"));
       //validDate = date.toString();
      }
      
      if (purchView.getEmailTxt().getText().equals(activeUser.getEmail())){
       email = purchView.getEmailTxt().getText();
       emailCheck = true;
      }else{
          JOptionPane.showMessageDialog(null, "Email does not match active user. Please enter registered email account for verification.");
          emailCheck = false;}
      
        if (emailCheck == true ){

            activeUser.createTicketOrder(validDate, Integer.parseInt(purchView.getQtyTxt().getValue().toString()));
            JOptionPane.showMessageDialog(null, activeUser.viewTicketsPurchased(activeUser.getTicketsPurchased(), Integer.parseInt(purchView.getQtyTxt().getValue().toString())));  
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
