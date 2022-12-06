
package Controller;

import Model.ProfileList;
import Model.UserAccount;
import View.LoginView;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * The LoginController uses the list of user account to call the login method
 * @author tpn352
 */
public class LoginController implements ActionListener {
LoginView loginView = new LoginView();
UserAccount activeUser;

/**
 * Default constructor for LoginController 
 * @param userList Instance of list of user accounts 
 */

    public LoginController() 
    {


loginView.setVisible(true);
loginView.getLoginButton().addActionListener(this);


    }

    public LoginController(ProfileList userList) {
        userList = userList;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
       ProfileList users = new ProfileList();
        
       for(int i = 0; i < users.getAccountList().size(); ++i){
           if(users.getAccountList().get(i).getUsername().equals(loginView.getUserText().getText()) && users.getAccountList().get(i).getPassword().equals(loginView.getjPasswordField1().getText())){
              // System.out.print(users.getAccountList().get(i));//printout to disply user info for testing purposes
               this.activeUser =  users.getAccountList().get(i);
               NavigationController nav = new NavigationController(activeUser);
               JComponent comp = (JComponent) e.getSource();
               Window win = SwingUtilities.getWindowAncestor(comp);
               win.dispose();
           }else {
               JOptionPane.showMessageDialog(loginView,
                       "Invalid Username or Password","Error",
                       JOptionPane.ERROR_MESSAGE);
       
           }
           
        }
    }
/**
 * Get the list of user accounts 
 * @return Instance of list of user accounts  
 */

/**
 * Set the list of user accounts 
 * @param userList Instance of list of user accounts 
 */

    
 /**
 * Method to pass username and password when user initiates the login process
 * @param  username Pass the username for a particular user from the list of user account 
 * @param  password Pass the password for a particular user from the list of user account 
 */    
    public void loginButtonClicked(String username, String password){
    
    }


    


}
   
