@22470
Feature: 22470
  
  Scenario: 22470
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 2
   Then Navigate To Admin > View and Manage Delegation of Site Users
   
   Then Click On Clear All Icon In Facility Dropdown For View and Manage Delegation on behalf of Site Users Screen
   Then Select Facility 1 From Facility Dropdown In View and Manage Delegation on behalf of Site Users Screen
   Then Verify Site User 1 Displayed In View and Manage Delegation of Site Users Screen
   Then Verify Site User 3 Displayed In View and Manage Delegation of Site Users Screen
   Then Verify Site User 4 Displayed In View and Manage Delegation of Site Users Screen
   
   Then Click On View/Manage Delegation For Site User 3
   Then Verify Manage Delegation on behalf of Site User 3 Screen Displayed
   
   Then Verify Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Safety Contact & Regulatory Contact (PI Delegate) Section Displayed Under Manage Delegation on behalf of Site User Screen
   
   Then Click On Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Verify Site User 4 With Facility 1 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   
   Then Click On Remove Button Against Site User 4 With Facility 1 Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   Then Click On Yes Button In Remove Study Delegate PopUp Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   Then Verify Site User 4 With Facility 1 Not Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   
   Then Click On Add Delegate Button Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   Then Set Site User 1 First Name In First Name TextBox In By Facility/Department Section
	 Then Set Site User 1 Last Name In Last Name TextBox In By Facility/Department Section
	 Then Click On SEARCH Button In By Facility/Department Section
	 Then Verify Site User 1 Displayed Under Search Study Site Maintenance Delegate Table
	 Then Click On Search Study Site Maintenance Delegate Section Expand Button
	 Then Click On CLEAR SEARCH Button In By Facility/Department Section
	 Then Set Site User 2 First Name In First Name TextBox In By Facility/Department Section
	 Then Set Site User 2 Last Name In Last Name TextBox In By Facility/Department Section
	 Then Click On SEARCH Button In By Facility/Department Section
	 Then Verify Site User 2 Displayed Under Search Study Site Maintenance Delegate Table
	 Then Click On Search Study Site Maintenance Delegate Section Expand Button
	 Then Click On CLEAR SEARCH Button In By Facility/Department Section
	 Then Set Site User 4 First Name In First Name TextBox In By Facility/Department Section
	 Then Set Site User 4 Last Name In Last Name TextBox In By Facility/Department Section
	 Then Click On SEARCH Button In By Facility/Department Section
	 Then Verify Site User 4 Displayed Under Search Study Site Maintenance Delegate Table
	 
	 Then Click On Search Study Site Maintenance Delegate Section Expand Button
	 Then Click On CLEAR SEARCH Button In By Facility/Department Section
   Then Set Site User 1 First Name In First Name TextBox In By Facility/Department Section
	 Then Set Site User 1 Last Name In Last Name TextBox In By Facility/Department Section
	 Then Click On SEARCH Button In By Facility/Department Section
	 Then Verify Site User 1 Displayed Under Search Study Site Maintenance Delegate Table
	 Then Select Site User 1 Displayed Under Search Study Site Maintenance Delegate Table
	 Then Click On SELECT STUDY DELEGATE Button
	 Then Select Facility 1 In Add Facilities/Departments for PopUp
	 Then Click On SAVE button In Add Facilities/Departments for PopUp
	 Then Verify Site User 1 With Facility 1 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
	 
	 Then Logout from SipApplication
   Then Close the browser