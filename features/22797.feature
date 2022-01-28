@22797
Feature: 22797
  
  Scenario: 22797
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then NavigatetoMyfacility
   Then Verify Facility 1 Is Displayed In Facilities Screen
   Then Click On Facility 1 Displayed In Facilities Screen
   Then Switch Frame And Navigate To Facility Contacts
   Then Verify Facility Contacts Screen Is Displayed
   Then Click On Add Facility Contact Button Is Displayed In Facility Contacts
   Then Set Site User 2 In Email Address Text Field
	 Then Click On SEARCH button In Search For Facility/Department Contact Section
	 Then Verify Site User 2 Displayed In Site User Search Results Table
	 Then Select Site User 2 From Site User Search Results Table
	 Then Click On Select Facility Contact Button
	 Then Select Role As "Delegation Manager" From Add Facility Roles PopUp
	 Then Verify Site User 2 Is Added As "Delegation Manager" In Facility Contacts Screen
	 Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 2
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then Site User Navigate To Notification Screen
   Then Verify Facility Profile Management Notifications For Facility 1 In Notification Screen
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then NavigatetoMyfacility
   Then Verify Facility 1 Is Displayed In Facilities Screen
   Then Click On Facility 1 Displayed In Facilities Screen
   Then Switch Frame And Navigate To Facility Contacts
   Then Verify Facility Contacts Screen Is Displayed
   Then Update Role Of Site User 3 From "Budget/Financial Contact" To "Delegation Manager" Keeping Previous Role
   Then Verify Site User 3 Role Has been Updated To "Budget/Financial Contact" And "Delegation Manager"
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 3
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then Site User Navigate To Notification Screen
   Then Verify Facility Profile Management Notifications For Facility 1 In Notification Screen
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then NavigatetoMyfacility
   Then Verify Facility 1 Is Displayed In Facilities Screen
   Then Click On Facility 1 Displayed In Facilities Screen
   Then Switch Frame And Navigate To Facility Contacts
   Then Verify Facility Contacts Screen Is Displayed
   Then Click On Add Facility Contact Button Is Displayed In Facility Contacts
   Then Set Site User 1 In Email Address Text Field
	 Then Click On SEARCH button In Search For Facility/Department Contact Section
	 Then Verify Site User 1 Displayed In Site User Search Results Table
	 Then Select Site User 1 From Site User Search Results Table
	 Then Click On Select Facility Contact Button
	 Then Select Role As "Delegation Manager" From Add Facility Roles PopUp
	 Then Verify Site User 1 Is Added As "Delegation Manager" In Facility Contacts Screen
	 Then Site User Navigate To Notification Screen
   Then Verify Facility Profile Management Notifications Not Displayed For Facility 1 In Notification Screen
   Then Logout from SipApplication
   Then Close the browser