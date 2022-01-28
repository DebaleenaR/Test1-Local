@22399
Feature: 22399
 
  
  Scenario: 22399
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Proper_Login_Siteuser 1
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
  # Then NavigatetoMyfacility
   #Then Verify Facility 1 Is Displayed In Facilities Screen
  # Then Click On Facility 1 Displayed In Facilities Screen
  # Then Switch Frame And Navigate To Facility Contacts
  # Then Verify Site User Is Not Able to Remove Delegation Manager
   #Then NavigateToParentWindowCloseChildWindow
   Then NavigatetoMyfacility
   Then Verify Facility 1 And Department 1 Is Displayed In Facilities Screen
   Then Click Deparment 1 of Facility 1 In Facilities Screen
   Then Switch Frame And Navigate To Facility Contacts
   Then Verify Site User Is Not Able to Remove Delegation Manager
   Then Logout from SipApplication
   Then Close the browser