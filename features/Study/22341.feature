@22341
Feature: 22341
  
  Scenario: 22341
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then Navigate To Admin > View and Manage Delegation of Site Users
   Then Verify View and Manage Delegation on behalf of Site Users Screen Displayed
   Then Select 50 From Show Rows Dropdown In View and Manage Delegation Screen
   Then Verify Site User 2 Displayed In View and Manage Delegation of Site Users Screen
   Then Verify Site User 3 Displayed In View and Manage Delegation of Site Users Screen
   Then Verify Site User 4 Displayed In View and Manage Delegation of Site Users Screen
   Then Click On View/Manage Delegation For Site User 2
   Then Verify Manage Delegation on behalf of Site User 2 Screen Displayed
   Then Verify User Profile Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Survey Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Safety Contact & Regulatory Contact (PI Delegate) Section Displayed Under Manage Delegation on behalf of Site User Screen
	 Then Click On Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
	 Then Verify No Delegate Message Is Displayed In STUDY SITE MAINTENANCE DELEGATES Table
	 Then Click On Add Delegate Button Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
	 Then Click On Facility Name Dropdown In Search Study Site Maintenance Delegate Screen
	 Then Verify Facility 1 Is Displayed In Facility Name Dropdown In Search Study Site Maintenance Delegate Screen
	 Then Verify Facility 2 Is Displayed In Facility Name Dropdown In Search Study Site Maintenance Delegate Screen
	 Then Close Facility Dropdown Under Search Study Site Maintenance Delegate Section
	 
	 Then Set Site User 1 First Name In First Name TextBox In By Facility/Department Section
	 Then Set Site User 1 Last Name In Last Name TextBox In By Facility/Department Section
	 Then Click On SEARCH Button In By Facility/Department Section
	 Then Verify Site User 1 Displayed Under Search Study Site Maintenance Delegate Table
	 Then Click On Search Study Site Maintenance Delegate Section Expand Button
	 Then Click On CLEAR SEARCH Button In By Facility/Department Section
	 
	 Then Set Site User 3 First Name In First Name TextBox In By Facility/Department Section
	 Then Set Site User 3 Last Name In Last Name TextBox In By Facility/Department Section
	 Then Click On SEARCH Button In By Facility/Department Section
	 Then Verify Site User 3 Displayed Under Search Study Site Maintenance Delegate Table
	 
	 Then Select Site User 3 Displayed Under Search Study Site Maintenance Delegate Table
	 Then Click On SELECT STUDY DELEGATE Button
	 Then Verify Facility 1 In Add Facilities/Departments for PopUp
	 Then Verify Facility 2 In Add Facilities/Departments for PopUp
	 
	 Then Select Facility 1 In Add Facilities/Departments for PopUp
	 Then Click On SAVE button In Add Facilities/Departments for PopUp
	 Then Verify Site User 3 With Facility 1 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
	 
	 Then Click On Add Delegate Button Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
	 Then Set Site User 1 First Name In First Name TextBox In By Facility/Department Section
	 Then Set Site User 1 Last Name In Last Name TextBox In By Facility/Department Section
	 Then Click On SEARCH Button In By Facility/Department Section
	 Then Verify Site User 1 Displayed Under Search Study Site Maintenance Delegate Table
	 Then Select Site User 1 Displayed Under Search Study Site Maintenance Delegate Table
	 Then Click On SELECT STUDY DELEGATE Button
	 Then Verify Facility 2 In Add Facilities/Departments for PopUp
	 Then Verify Facility 1 In Add Facilities/Departments for PopUp Not Displayed
	 
	 Then Select Facility 2 In Add Facilities/Departments for PopUp
	 Then Click On SAVE button In Add Facilities/Departments for PopUp
	 Then Verify Site User 1 With Facility 2 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
	 
	 Then Logout from SipApplication
   Then Close the browser
	 