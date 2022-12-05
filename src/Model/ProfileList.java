
package Model;

import java.util.ArrayList;

/**
 * The ProfileList class contains a list of user accounts in an ArrayList
 * @author tpn352
 */
public class ProfileList {
    
    private ArrayList<UserAccount>  accountList;

/**
 * Default constructor for ProfileList
 * @param AccountList  List of user accounts 
 */
    public ProfileList(ArrayList<UserAccount> AccountList) {
        this.accountList = new ArrayList<UserAccount>();
        
    }
    public String loadData(){
        UserAccount testProfile = new UserAccount("Bob Test", "bobtest@gmail.com", "02/19/1978", 123456, "bobtest", "1234",true, new ArrayList<>(), new ArrayList<>(), new ArrayList<parkTicket>(), new ArrayList<SitDownReservation>());
      accountList.add(testProfile);
        return testProfile.toString();
    }

    public ProfileList()
    {
        this.accountList = new ArrayList<UserAccount>();
        
        UserAccount testProfile = new UserAccount("Bob Test", "bobtest@gmail.com", "02/19/1978", 123456, "bobtest", "1234",true, new ArrayList<>(), new ArrayList<>(), new ArrayList<parkTicket>(), new ArrayList<SitDownReservation>());
            accountList.add(testProfile);

    }


    /**
 * Gets the list of user accounts  
 * @return ArrayList of user accounts 
 */
    public ArrayList<UserAccount> getAccountList() {
        return accountList;
    }

/**
 * Sets the list of user accounts  
 * @param AccountList ArrayList of user accounts
 */
    public void setAccountList(ArrayList<UserAccount> AccountList) {
        this.accountList = AccountList;
    }

    
}
