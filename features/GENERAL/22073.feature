@22073
Feature: 22073
  
  Scenario: 22073
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_SponsorUser 1
   Then Navigate To Admin > Manage News/Links/FAQ
   Then Verify Admin > Manage News/Links/FAQ Breadcrumb
   Then Verify Print Icon In Manage News/Links/FAQ Screen
   Then Verify Export Icon In Manage News/Links/FAQ Screen
   Then Verify Add News/Links/FAQ Icon In Manage News/Links/FAQ Screen
   Then Verify Show/Hide Column Dropdown In Manage News/Links/FAQ Screen
   Then Verify Pagination In Manage News/Links/FAQ Screen
   Then Click On Add News/Links/FAQ Button In Manage News/Links/FAQ Screen
   Then Verify Add News/Links/FAQ Screen Is Displayed
   
   Then Select Study News From Content Type Dropdown
   
   Then Verify Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
   Then Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
   Then Verify That Country 1 Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
   Then Click On CLEAR ALL Icon Under Study Country dropdown
   Then Verify That Country 2 Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
   Then Click On Close Icon In Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
   Then Select Site and Sponsor User Radio Button Under POSTING DETAILS Section
   Then Verify Sponsor User Role Dropdown Displayed Under POSTING DETAILS Section
   Then Verify Site User Role Dropdown Displayed Under POSTING DETAILS Section
   Then Select "Monitor - Country Specific" Role From Sponsor User Role Dropdown
   Then Select "Study - Edit and View - Country Specific" Role From Sponsor User Role Dropdown
   Then Select "Principal Investigator" Role From Site User Role Dropdown
   Then Click On Checkbox against Send Notification Email will be sent as per users email preference
   Then Verify Compound Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible
   Then Verify Program Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible
   Then Verify Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible
   Then Select Compound 1 For StudyId 1 In Compound Dropdown
   Then Select Program 1 For StudyId 1 In Program Dropdown
   Then Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
	 Then Select Country 1 Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
	 Then Click On Close Icon In Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
	 Then Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
	 Then Select Country 2 Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
	 Then Click On Close Icon In Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
	 Then Select Study ID 1 From Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
	 Then Enter Text In Subject Textbox Under DETAILS Section For Study News
	 Then Enter Description In Subject Textbox Under DETAILS Section For Study News
	 Then Enter URL In Subject Textbox Under DETAILS Section For Study News
	 Then Select Display Date In Expiration Date Under DETAILS Section
	 Then Select Current Date In Expiration Date Under DETAILS Section
	 Then Click On PROCEED Button Under DETAILS Section
	 Then Verify Country 1 Displayed In Study Link PopUp
	 Then Verify Country 2 Displayed In Study Link PopUp
	 Then Click On Publish Button In Study Link PopUp
	 Then Verify News/Link/FAQ has been successfully published PopUp
	 Then Click On OK Button In News/Link/FAQ has been successfully published PopUp
	 Then Select Study News From Content Type Dropdown Under Manage News/Links/FAQ Screen
	 Then Click On SEARCH Button Under Manage News/Links/FAQ Screen
	 Then Select 50 From Show Row Under Manage News/Links/FAQ Screen
	 Then Verify Columns Of Manage News/Links/FAQ Table
	 Then Verify Newly Created Study News Displayed Under Manage News/Links/FAQ Table
	 Then Select "Study Country" Option From Show/Hide Columns Dropdown
	 Then Verify Country 1 Displayed Under Study Country Column For Newly Created Study News
	 Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then Site User Navigate To View All Workspaces
   Then Site User Navigate To Study 1
   Then Verify Newly Created Study Link Displayed Under Study News
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_SponsorUser 2
   Then clickonbell
   Then Verify Study New Notification Is Displayed For Study 1
   Then Click On SIP Logo
   Then Sponsor User Navigate To View All Workspaces
   Then Sponsor User Navigate To Study 1
   Then Verify Newly Created Study Link Displayed Under Study News
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_SponsorUser 3
   Then clickonbell
   Then Verify Study New Notification Is Displayed For Study 1
   Then Click On SIP Logo
   Then Sponsor User Navigate To View All Workspaces
   Then Sponsor User Navigate To Study 1
   Then Verify Newly Created Study Link Displayed Under Study News
   Then Logout from SipApplication
   Then Close the browser   