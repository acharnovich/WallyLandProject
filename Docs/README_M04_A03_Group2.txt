Group #2

Members: Aurora Blasko Drabik
	 Andrew Charnovich
	 Taazkir Nasir


Disclaimer:

This project was built using NetBeans IDE 15. If prompted for an update, please select the update option to ensure that the project runs.
The project also uses a the LGoodDatePicker-11.2.1.jar library. The jar file is included in the project zip. 

Use Case #2 Description:
Our second use case is letting users schedule attractions. It enables users to view a list of attractions offered at the park from where they can choose to add their desied one to their schedule. In order to access this use case, a ticket must be purchased. Once the Purchasing ticket use case is complete, the Schedule Attraction button will be enabled. Clicking the button instantiate the attraction controller which instantiates the model, which is an Array list of attractions objects. The model is passed to the view where the attractions can be viewed in a table. Not all memebers of a group will take part in the same activities so customers can selects how many people from their group is going to a perticular attraction. When a row is selected in the Attraction table and the number of people are enterd using the spinner, the system checks if the row selection is valid and the number of people is equal or less than the number of tickets the user purchased. When a valid selection is made, the system will confirm the attraction was added along with the name and number of people. 

Use Case #1 Update:
 
Handles empty user inputs.
Checks for valid ticket quantity.
Added Date picker with calender. 
Rejects dates if its before current date.
 
Direction to Use:

1.	Run the Main method in the Main class. The application will start with a Login in window.
2.	Enter the following Username and Password to access the navigation window:

Username: bobtest
Password: 1234

3.	Click on the Purchase Tickets button to access the form. 
4.	Enter the following email address, and choose the number of visitors between 1 to 5 and choose the date of visit using the calender 

Email: bobtest@gmail.com 

5.	Click the submit button to buy the ticket and enable the Schedule Attractions button. 
6. 	Click the Schedule Attractions button to access the list of attractions at the park.
7.	Click anywhere on the row to select the attraction you would like to schedule from the table.
8.	Once selected, choose the amount of people in your group you would like to schedule the attraction for.
9.	Click submit to confirm your Attraction for the amount of people selected.  
  
