@22430
Feature: 22430
  
  Scenario: 22430
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Proper_Login_Siteuser 1
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then NavigatetoMyfacility
   Then Verify Facility 1 And Department 1 Is Displayed In Facilities Screen
   Then Click Department 1 Of Facility 1 Is Displayed In Facilities Screen
   Then Switch Frame And Navigate To Department Contacts
   Then Verify Department Contacts Screen Is Displayed
   Then Verify Add Department Contact Button Is Displayed
   Then Click On Add Department Contact Button Is Displayed In Department Contacts
   Then Select Facility 1 In Facility Name In Search For Facility/Department Contact Section
   Then Select Department 1 of Facility 1 In Department Name In Search For Facility/Department Contact Section
	 Then Click On SEARCH button In Search For Facility/Department Contact Section
	 Then Verify Site User 1 Displayed In Site User Search Results Table
	 Then Verify Site User 3 Displayed In Site User Search Results Table
	 Then Verify Site User 4 Displayed In Site User Search Results Table
	 Then Click On Expand Button For Search For Facility/Department Contact Section
	 Then Click On Clear Search Button In Search For Facility/Department Contact Section
	 Then Set Site User 4 In Email Address Text Field
	 Then Click On SEARCH button In Search For Facility/Department Contact Section
	 Then Verify Site User 4 Displayed In Site User Search Results Table
	 Then Logout from SipApplication
   Then Close the browser
	 