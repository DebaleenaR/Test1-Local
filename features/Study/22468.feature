@22468
Feature: 22468
  
  Scenario: 22468
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then Navigate To Admin > View and Manage Delegation of Site Users
   Then Verify View and Manage Delegation on behalf of Site Users Screen Displayed
   Then Verify Site User 2 Displayed In View and Manage Delegation of Site Users Screen
   Then Verify Site User 3 Displayed In View and Manage Delegation of Site Users Screen
   Then Verify Site User 1 Not Displayed In View and Manage Delegation of Site Users Screen
   Then Click On View/Manage Delegation For Site User 2
   Then Verify Manage Delegation on behalf of Site User 2 Screen Displayed
   Then Verify User Profile Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Survey Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Safety Contact & Regulatory Contact (PI Delegate) Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Click On Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Site User 3 With Facility 1 and Department 1 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   #Then Verify Site User 3 With Facility 1 and Department 3 Not Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   Then Click On Add Delegate Button Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   Then Click On Facility Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen
   Then Verify Facility 1 Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section
   Then Close Facility Dropdown Under Search Study Site Maintenance Delegate Section
   Then Click On Facility Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen
   Then Select Facility 1 Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section
   Then Close Facility Dropdown Under Search Study Site Maintenance Delegate Section
   
   Then Click On Department Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen
   Then Verify Facility 1 Department 3 Not Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section
   Then Close Department Dropdown Under Search Study Site Maintenance Delegate Section
   
   #Step error need to modify TC
   
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 2
   Then Navigate To Admin > Manage Delegate
   Then Click On Study Site Profile Maintenance Section Under Manage Delegation Screen
   Then Verify Site User 3 With Facility 1 and Department 1 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   Then Verify Site User 3 With Facility 1 and Department 3 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 3
   Then Navigate To Admin > Manage Delegate
   Then Click On Study Site Profile Maintenance Section Under Manage Delegation Screen
   #Then Verify Site User 3 With Facility 1 and Department 1 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   #Then Verify Site User 3 With Facility 1 and Department 3 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   Then Logout from SipApplication
   Then Close the browser
   
   
   