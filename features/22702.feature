@22702
Feature: 22702
  
  Scenario: 22702
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then Navigate To Admin > View and Manage Delegation of Site Users
   Then Click On View/Manage Delegation For Site User 3
   Then Verify Manage Delegation on behalf of Site User 3 Screen Displayed
   Then Click On Add Delegate Button In User Profile Section
   Then Enter Email ID In Enter Delegate E-mail Address of Site User 4
   Then Click On Delegate Button In User Profile Section
   Then Click On Ok Button In User Profile Delegation Complete PopUp
   Then Verify Site User 4 Displayed In User Profile Section
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 3
   Then Navigate To Admin > Manage Delegation
   Then Verify Site User 4 Displayed In User Profile Section For Site User
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then Navigate To Admin > View and Manage Delegation of Site Users
   Then Click On View/Manage Delegation For Site User 3
   Then Verify Manage Delegation on behalf of Site User 3 Screen Displayed
   Then Click On UnDelegate Button In User Profile Section
   Then Click On Remove Delegate In Remove User Profile Delegate PopUp
   Then Click On OK Button In User Profile Delegate Removed PopUp
   Then Verify Site User 4 Is Not Displayed In User Profile Section
   Then Logout from SipApplication
   Then Close the browser
   