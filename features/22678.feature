@22678
Feature: 22678
  
  Scenario: 22678
  
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 1
   #Then NavigatetoMyfacility
   #Then Verify Facility 1 Is Displayed In Facilities Screen
   #Then Click On Facility 1 Displayed In Facilities Screen
   #Then Click On Facility Contact Tab
   #Then Verify Add Facility Contact Button Is Displayed In Facility Contacts
   #Then Click On Add Facility Contact Button Is Displayed In Facility Contacts
   #Then Set Site User 2 In Email Address Text Field
   #Then Click On SEARCH button In Search For Facility/Department Contact Section
   #Then Verify Site User 2 Displayed In Site User Search Results Table
   #Then Select Site User 2 From Site User Search Results Table
   #Then Click On Select Facility Contact Button
   #Then Click On "Delegation Manager" Role In Add Facility Roles For PopUp
   #Then Click On Save Button In Add Facility Roles For PopUp
   #Then Click_Site_Administrator_Popup_action_confirm_Button
   #Then Verify Site User 2 Is Added In Facility Contacts Table
   #Then Site User Navigate To Notification Screen
   #Then Verify Facility Contacts Role Added Notification For Site User For Facility 1 Not Displayed
   #Then Logout from SipApplication
   #Then Close the browser
   
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 2
   #Then Site User Navigate To Notification Screen
   #Then Verify Facility Contacts Role Added Notification For Site User For Facility 1
   #Then Logout from SipApplication
   #Then Close the browser
   
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then NavigatetoMyfacility
   Then Verify Facility 1 And Department 1 Is Displayed In Facilities Screen
   Then Click Deparment 1 of Facility 1 In Facilities Screen
   Then Click On Department Contact Tab
   Then Verify Department Contacts Screen Is Displayed
   Then Verify Add Department Contact Button Is Displayed
   Then Click On Add Department Contact Button Is Displayed In Department Contacts
   Then Set Site User 2 In Email Address Text Field
   Then Click On SEARCH button In Search For Facility/Department Contact Section
   Then Verify Site User 2 Displayed In Site User Search Results Table
   Then Select Site User 2 From Site User Search Results Table
   Then Click On Select Department Contact Button
   Then Click On "Delegation Manager" Role In Add Department Roles For PopUp
   Then Click On Save Button In Add Facility Roles For PopUp
   Then Click_Site_Administrator_Popup_action_confirm_Button
   Then Verify Site User 2 Is Added In Department Contacts Table
   Then Site User Navigate To Notification Screen
   Then Verify Facility Contacts Role Added Notification For Site User For Facility 1 Not Displayed
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 2
   Then Site User Navigate To Notification Screen
   Then Verify Facility Contacts Role Added Notification For Site User For Facility 1 and Department 1
   Then Logout from SipApplication
   Then Close the browser