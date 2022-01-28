@22161
Feature: 22161
  
  Scenario: 22161
  
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_SponsorUser 1
   #Then Navigate To Admin > Manage News/Links/FAQ
   #Then Verify Admin > Manage News/Links/FAQ Breadcrumb
   #Then Verify Print Icon In Manage News/Links/FAQ Screen
   #Then Verify Export Icon In Manage News/Links/FAQ Screen
   #Then Verify Add News/Links/FAQ Icon In Manage News/Links/FAQ Screen
   #Then Verify Show/Hide Column Dropdown In Manage News/Links/FAQ Screen
   #Then Verify Pagination In Manage News/Links/FAQ Screen
   #Then Click On Add News/Links/FAQ Button In Manage News/Links/FAQ Screen
   #Then Verify Add News/Links/FAQ Screen Is Displayed
   #Then Verify Add News/Links/FAQ Screen Is Displayed
   #Then Verify Admin > Manage News/Links/FAQ > Add News/Links/FAQ Breadcrumb
   #Then Verify OnScreen Text For Add News/Links/FAQ Section
   #Then Verify POSTING DETAILS Header In Add News/Links/FAQ Screen
   #Then Verify POSTING DETAILS Section In Add News/Links/FAQ Screen
   #Then Verify DISPLAY NEWS/LINKS/FAQ TO Header In Add News/Links/FAQ Screen
   #Then Verify DISPLAY NEWS/LINKS/FAQ TO Input Section In Add News/Links/FAQ Screen
   #Then Verify Details Header In Add News/Links/FAQ Screen
   #Then Verify Details Section In Add News/Links/FAQ Screen
   #Then Select Study News From Content Type Dropdown
   #Then Verify Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
   #Then Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
   #Then Verify That All Country Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
   #Then Click On Close Icon In Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
   #Then Select Site and Sponsor User Radio Button Under POSTING DETAILS Section
   #Then Verify Sponsor User Role Dropdown Displayed Under POSTING DETAILS Section
   #Then Click On Clear All Option From Sponsor User Role Dropdown
   #Then Select "Monitor - Country Specific" Role From Sponsor User Role Dropdown
   #Then Select "Study - Edit and View - Country Specific" Role From Sponsor User Role Dropdown
   #Then Click On Clear All Option From Site User Role Dropdown
   #Then Select "Principal Investigator" Role From Site User Role Dropdown
   #Then Verify Compound Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible
   #Then Verify Program Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible
   #Then Verify Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible
   #Then Select Compound 1 For StudyId 1 In Compound Dropdown
   #Then Select Program 1 For StudyId 1 In Program Dropdown
   #Then Select Study ID 1 From Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
   #Then Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
	 #Then Select Country 1 Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
	 #Then Click On Close Icon In Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
	 #Then Enter Text In Subject Textbox Under DETAILS Section For Study News
	 #Then Enter Description In Subject Textbox Under DETAILS Section For Study News
	 #Then Enter URL In Subject Textbox Under DETAILS Section For Study News
	 #Then Select Display Date In Expiration Date Under DETAILS Section
	 #Then Select Current Date In Expiration Date Under DETAILS Section
	 #Then Click On PROCEED Button Under DETAILS Section
	 #Then Verify Country 1 Displayed In Study Link PopUp
	 #Then Click On Publish Button In Study Link PopUp
	 #Then Verify News/Link/FAQ has been successfully published PopUp
	 #Then Click On OK Button In News/Link/FAQ has been successfully published PopUp
	 #Then Select Study News From Content Type Dropdown Under Manage News/Links/FAQ Screen
	 #Then Click On SEARCH Button Under Manage News/Links/FAQ Screen
	 #Then Verify Columns Of Manage News/Links/FAQ Table
	 #Then Select 50 From Show Row Under Manage News/Links/FAQ Screen
	 #Then Verify Newly Created Study News Displayed Under Manage News/Links/FAQ Table
	 #Then Select "Study Country" Option From Show/Hide Columns Dropdown
	 #Then Verify Country 1 Displayed Under Study Country Column For Newly Created Study News
	 #Then Logout from SipApplication
   #Then Close the browser
   
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 1
   #Then clickonbell
   #Then Verify Study New Notification Is Displayed For Study 1
   #Then Site User Navigate To View All Workspaces
   #Then Site User Navigate To Study 1
   #Then Verify Newly Created Study Link Displayed Under Study News
   #Then Click On SIP Logo
   #Then Site User Navigate To View All Workspaces
   #Then Site User Navigate To Study 2
   #Then Verify Newly Created Study Link Not Displayed Under Study News
   #Then Logout from SipApplication
   #Then Close the browser
	 
	 #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_SponsorUser 2
   #Then clickonbell
   #Then Verify Study New Notification Is Displayed For Study 1
   #Then Click On SIP Logo
   #Then Sponsor User Navigate To View All Workspaces
   #Then Sponsor User Navigate To Study 1
   #Then Verify Newly Created Study Link Not Displayed Under Study News
   #Then Sponsor User Navigate To View All Workspaces
   #Then Sponsor User Navigate To Study 2
   #Then Verify Newly Created Study Link Not Displayed Under Study News
   #Then Logout from SipApplication
   #Then Close the browser
   
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_SponsorUser 3
   #Then clickonbell
   #Then Verify Study New Notification Is Not Displayed For Study 1
   #Then Click On SIP Logo
   #Then Sponsor User Navigate To View All Workspaces
   #Then Sponsor User Navigate To Study 2
   #Then Verify Newly Created Study Link Not Displayed Under Study News
   #Then Logout from SipApplication
   #Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_SponsorUser 1
   Then Navigate To Admin > Manage News/Links/FAQ
   #Then Select Study News From Content Type Dropdown Under Manage News/Links/FAQ Screen
   #Then Click Expiration Date Range Manage News/Links/FAQ As Current Date
   #Then Click On SEARCH Button Under Manage News/Links/FAQ Screen
   #Then Select 50 From Show Row Under Manage News/Links/FAQ Screen
	 Then Verify Newly Created Study News Displayed Under Subject/Document Column
	 Then Scroll ManageSponsorStudyNewsLinksTable To View Actions Dropdown
	 Then Click On Edit Button Against Newly Created Study News Displayed Under Actions Column
	 Then Select Study ID 2 From Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
	 Then Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed For Edit
	 Then Click On CLEAR ALL Icon Under Study Country dropdown To Edit
	 Then Select Country 2 Displayed Under The Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
	 Then Click On PROCEED Button Under DETAILS Section
	 Then Verify Country 2 Displayed In Study Link PopUp
	 Then Verify Study 2 Displayed In Study Link PopUp
	 Then Click On Publish Button In Study Link PopUp
	 Then Verify News/Link/FAQ has been successfully Updated PopUp
	 Then Click On OK Button In News/Link/FAQ has been successfully published PopUp
	 Then Verify User Navigated To Manage News/Links/FAQ Screen
	 Then Select Study News From Content Type Dropdown Under Manage News/Links/FAQ Screen
	 Then Click On SEARCH Button Under Manage News/Links/FAQ Screen
	 Then Verify Columns Of Manage News/Links/FAQ Table
	 Then Select 50 From Show Row Under Manage News/Links/FAQ Screen
	 Then Verify Newly Created Study News Displayed Under Manage News/Links/FAQ Table
	 Then Select "Study Country" Option From Show/Hide Columns Dropdown
	 Then Verify Country 2 Displayed Under Study Country Column For Newly Created Study News
	 Then Logout from SipApplication
   Then Close the browser
   
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 1
   #Then clickonbell
   #Then Verify Study New Notification Is Displayed For Study 1
   #Then Site User Navigate To View All Workspaces
   #Then Site User Navigate To Study 1
   #Then Verify Newly Created Study Link Not Displayed Under Study News
   #Then Click On SIP Logo
   #Then Site User Navigate To View All Workspaces
   #Then Site User Navigate To Study 2
   #Then Verify Newly Created Study Link Displayed Under Study News
   #Then Logout from SipApplication
   #Then Close the browser
   
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_SponsorUser 2
   #Then clickonbell
   #Then Verify Study New Notification Is Not Displayed For Study 1
   #Then Click On SIP Logo
   #Then Sponsor User Navigate To View All Workspaces
   #Then Sponsor User Navigate To Study 1
   #Then Verify Newly Created Study Link Not Displayed Under Study News
   #Then Sponsor User Navigate To View All Workspaces
   #Then Sponsor User Navigate To Study 2
   #Then Verify Newly Created Study Link Not Displayed Under Study News
   #Then Logout from SipApplication
   #Then Close the browser
   
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_SponsorUser 3
   #Then clickonbell
   #Then Verify Study New Notification Is Not Displayed For Study 1
   #Then Click On SIP Logo
   #Then Sponsor User Navigate To View All Workspaces
   #Then Sponsor User Navigate To Study 2
   #Then Verify Newly Created Study Link Displayed Under Study News
   #Then Logout from SipApplication
   #Then Close the browser