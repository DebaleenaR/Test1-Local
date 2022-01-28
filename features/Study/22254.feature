@22254
Feature: 22254
  
  Scenario: 22254
  
   #Step 1
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Complete Properlogin For Site User 1
   Then Navigate To Admin > View and Manage Delegation of Site Users
   #Step 2
   
   Then Verify View and Manage Delegation on behalf of Site Users Screen Displayed
   Then Select "50" From Show Dropdown In View and Manage Delegation on behalf of Site Users Screen
	 Then Verify Site User 2 Displayed In View and Manage Delegation of Site Users Screen
   Then Verify Site User 3 Displayed In View and Manage Delegation of Site Users Screen
   Then Verify Site User 4 Displayed In View and Manage Delegation of Site Users Screen
   
   #Step 3
   Then Verify Site User 1 Not Displayed In View and Manage Delegation of Site Users Screen
   
   #Step 4
   Then Click On View/Manage Delegation For Site User 3
   Then Verify Manage Delegation on behalf of Site User 3 Screen Displayed
   
   #Step 5
   Then Verify Study Site Profile Maintenance Tab Not Displayed
   Then Verify Safety Contact & Regulatory Contact (PI Delegate) Not Displayed
   Then Navigate Back To Parent Window And Close child Window
   
   #Step 6
   Then Navigate To Admin > View and Manage Delegation of Site Users
   Then Verify View and Manage Delegation on behalf of Site Users Screen Displayed
   
   #Step 7
   Then Select "50" From Show Dropdown In View and Manage Delegation on behalf of Site Users Screen
   Then Click On View/Manage Delegation For Site User 2
   Then Verify User Profile Section Displayed Under Manage Delegation on behalf of Site User Screen
   
   #Step 8
   Then Verify Survey Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Safety Contact & Regulatory Contact (PI Delegate) Section Displayed Under Manage Delegation on behalf of Site User Screen
   
   #Step 9
   Then Click On Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   
   #Step 10 & 11
   Then Click On Add Delegate Button Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   Then Click On Facility Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen
   Then Select Facility 1 Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section
   Then Close Facility Dropdown Under Search Study Site Maintenance Delegate Section
   Then Click On SEARCH Button Under Search Study Site Maintenance Delegate Section
   Then Select 50 From Show Rows In Search Study Site Maintenance Delegate Table
   
   #Step 12
   Then Verify Site User 1 Is Displayed In Search Study Site Maintenance Delegate Table
   Then Verify Site User 3 Is Displayed In Search Study Site Maintenance Delegate Table
   Then Verify Site User 4 Is Displayed In Search Study Site Maintenance Delegate Table
   Then Verify Site User 2 Is Not Displayed In Search Study Site Maintenance Delegate Table
   Then Select Site User 1 Is Displayed In Search Study Site Maintenance Delegate Table
   Then Click On SELECT STUDY DELEGATE Button In Manage Delegation on behalf of Screen
   Then Select Facility 1 In Add Facilities/Departments for PopUp
	 Then Click On SAVE button In Add Facilities/Departments for PopUp
	 Then Verify Site User 1 With Facility 1 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
	 
	 #Step 13
   Then Logout from SipApplication
   Then Close the browser
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 4
   Then Site User Navigate To View All Workspaces
   Then Site User Navigate To Study 1
   Then Site User Click On Study Site Profile Tab
   Then Site User Click On Site Staff
   
   #Step 14
   Then Verify Site User 1 With Role As "Delegate Manager" Is Not Displayed Under Site Staff Table
   Then Verify Site User 2 Is Displayed As "Budget/Financial Contact" With Current Date
   
   #Step 15
   Then Verify Site User 2 With Role As "Delegate Manager" Is Not Displayed Under Site Staff Table
   
   #Step 16
   Then Logout from SipApplication
   Then Close the browser
   