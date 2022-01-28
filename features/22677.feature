@22677
Feature: 22677
  
  Scenario: 22677
  
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 3
   #Then Navigate To Admin > View and Manage Delegation of Site Users
   #Then Click On View/Manage Delegation For Site User 1
   #Then Verify Manage Delegation on behalf of Site User 1 Screen Displayed
   #Then Verify Site User 2 Displayed In User Profile Section
   #Then Click On UnDelegate Button In User Profile Section
   #Then Click On Remove Delegate In Remove User Profile Delegate PopUp
   #Then Click On OK Button In User Profile Delegate Removed PopUp
   #Then Verify Add Delegate Button In User Profile Section
   #Then Click On Add Delegate Button In User Profile Section
   #Then Click On Organization Radio Button In Delegate User Profile Screen
   #Then Select Organization 1 From Organization Name In Search Organization Section
   #Then Click On search Button In Search Organization Section
   #Then Click Radio Button Against Organization 1 In Search Organization Section
   #Then Click Delegate Button For Organization In Search Organization Section
   #Then Click On Ok Button For Organization In User Profile Delegation Complete PopUp
   #Then Verify Organization 1 Displayed In Delegate User Profile Screen
   #Then Logout from SipApplication
   #Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 2
   Then Site User Navigate to My Tasks
   Then Select Task Description Option From Show/Hide Dropdown In My Task Screen
   Then Sort Task Received Date In Ascending Order
   Then Verify User Profile Management Tasks For Organization Association Task
   Then Click On User Profile Management Tasks For Organization Association Task
   Then Click On Accept Task Button In User Profile Task PopUp
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then Navigate To Admin > Manage Delegation
   
   
   #### Design Pending For defect
   Then Verify Organization 1 Displayed In Delegate User Profile Screen
   Then Verify Site User 2 Displayed In User Profile Section
   
   