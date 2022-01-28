@22602
Feature: 22602
  
  Scenario: 22602
  
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Complete Properlogin For Site User 3
   #Then Navigate To Admin > Manage Delegate
   #Then Click On DELEGATED TO ME Tab
   #Then Verify Site User 2 For Facility 1 Is Displayed Under DELEGATE FOR CURRENT AND FUTURE STUDIES/ FACILITY Table As Active
   #Then Logout from SipApplication
   #Then Close the browser
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_SponsorUser 1
   #Then Sponsor User Navigate To View All Workspaces
   #Then Sponsor User Navigate To Study 1
   #Then Click On Potential Investigator Tab
   #Then Verify Site User 3 Is Displayed Under Delegate for SIP Study Site Maintenance Column
   #Then Verify Site User 2 Is Displayed Under Potential Investigator Column
   #Then Logout from SipApplication
   #Then Close the browser
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Complete Properlogin For Site User 1
   #Then Navigate To Admin > View and Manage Delegation of Site Users
   #Then Verify View and Manage Delegation on behalf of Site Users Screen Displayed
   #Then Select "50" From Show Dropdown In View and Manage Delegation on behalf of Site Users Screen
	 #Then Verify Site User 2 Displayed In View and Manage Delegation of Site Users Screen
   #Then Verify Site User 3 Displayed In View and Manage Delegation of Site Users Screen
   #Then Click On View/Manage Delegation For Site User 2
   #Then Verify Manage Delegation on behalf of Site User 2 Screen Displayed
   #Then Verify User Profile Section Displayed Under Manage Delegation on behalf of Site User Screen
   #Then Verify Survey Section Displayed Under Manage Delegation on behalf of Site User Screen
   #Then Verify Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   #Then Verify Safety Contact & Regulatory Contact (PI Delegate) Section Displayed Under Manage Delegation on behalf of Site User Screen
   #Then Click On Safety Contact & Regulatory Contact (PI Delegate) Under Manage Delegation on behalf of Site User Screen
   #Then Verify Site User 3 From Facility 1 Associated with Department 1 Displayed as "Regulatory Contact (PI Delegate)"
   #Then Verify Site User 3 From Facility 1 Associated with Department 1 Displayed as "Safety Contact"
   #Then Verify SAFETY CONTACT AND REGULATORY CONTACT (PI DELEGATE) Table Columns
   #Then Click On Remove For Site User 3 From Facility 1 Associated with Department 1 Displayed as "Safety Contact"
   #Then Click On YES Remove Delegate PopUp
   #Then Verify Site User 3 From Facility 1 Associated with Department 1 Not Displayed as "Safety Contact"
   #Then Click On Safety Contact & Regulatory Contact (PI Delegate) Under Manage Delegation on behalf of Site User Screen
   #Then Verify Site User 3 From Facility 1 Associated with Department 1 Displayed as "Regulatory Contact (PI Delegate)"
   #Then Verify Site User 3 From Facility 1 Associated with Department 1 Not Displayed as "Safety Contact"
   #Then Click On Remove For Site User 3 From Facility 1 Associated with Department 1 Displayed as "Regulatory Contact (PI Delegate)"
   #Then Click On YES Remove Delegate PopUp
   #Then Verify Site User 3 From Facility 1 Associated with Department 1 Not Displayed as "Regulatory Contact (PI Delegate)"
   #Then Logout from SipApplication
   #Then Close the browser
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 2
   #Then Site User Navigate To View All Workspaces
   #Then Site User Navigate To Study 1
   #Then Site User Click On Study Site Profile Tab
   #Then Site User Click On Site Staff
   #Then Verify Site User 3 Is Displayed As "Regulatory Contact (PI Delegate)"
   #Then Verify Site User 3 Is Displayed As "Safety Contact"
   #Then Logout from SipApplication
   #Then Close the browser
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Complete Properlogin For Site User 3
   #Then clickonbell
   #Then Verify Site User 3 Site Role Removed From Study 1 By Delegation Manager Notification1
   #Then Verify Site User 3 Site Role Removed From Study 1 By Delegation Manager Notification2
   #Then Logout from SipApplication
   #Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Complete Properlogin For Site User 1
   Then Navigate To Admin > View and Manage Delegation of Site Users
   Then Verify View and Manage Delegation on behalf of Site Users Screen Displayed
   Then Click On View/Manage Delegation For Site User 2
   Then Verify Manage Delegation on behalf of Site User 2 Screen Displayed
   Then Click On Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   Then Click On Add Delegate Button Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   Then Click On Facility Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen
   Then Verify Facility 1 Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section
   Then Close Facility Dropdown Under Search Study Site Maintenance Delegate Section
   Then Click On Facility Dropdown Under Search Study Site Maintenance Delegate Section For Manage Delegation on behalf of Screen
   Then Select Facility 1 Displayed Under Facility Dropdown Under Search Study Site Maintenance Delegate Section
   Then Close Facility Dropdown Under Search Study Site Maintenance Delegate Section
   Then Set Site User 3 First Name In First Name TextBox In By Facility/Department Section
	 Then Set Site User 3 Last Name In Last Name TextBox In By Facility/Department Section
	 Then Click On SEARCH Button In By Facility/Department Section
	 Then Verify Site User 3 Displayed Under Search Study Site Maintenance Delegate Table
	 Then Select Site User 3 Displayed Under Search Study Site Maintenance Delegate Table
	 Then Click On SELECT STUDY DELEGATE Button
	 Then Select Facility 1 In Add Facilities/Departments for PopUp
	 Then Click On SAVE button In Add Facilities/Departments for PopUp
	 Then Verify Site User 3 With Facility 1 Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
	 Then Logout from SipApplication
   Then Close the browser