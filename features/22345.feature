@22345
Feature: 22345
  
  Scenario: 22345
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then Navigate To Admin > View and Manage Delegation of Site Users
   Then Click On View/Manage Delegation For Site User 2
   Then Verify Manage Delegation on behalf of Site User 3 Screen Displayed
   Then Click On Add Delegate Button In User Profile Section
   Then Enter Email ID In Enter Delegate E-mail Address of Site User 2
   
   Then Logout from SipApplication
   Then Close the browser