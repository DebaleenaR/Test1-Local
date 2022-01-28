@22116
Feature: 22116
  
  Scenario: 22116
  
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
   #Then Verify Admin > Manage News/Links/FAQ > Add News/Links/FAQ Breadcrumb
   #Then Verify OnScreen Text For Add News/Links/FAQ Section
   #Then Verify POSTING DETAILS Header In Add News/Links/FAQ Screen
   #Then Verify POSTING DETAILS Section In Add News/Links/FAQ Screen
   #Then Verify DISPLAY NEWS/LINKS/FAQ TO Header In Add News/Links/FAQ Screen
   #Then Verify DISPLAY NEWS/LINKS/FAQ TO Input Section In Add News/Links/FAQ Screen
   #Then Verify Details Header In Add News/Links/FAQ Screen
   #Then Verify Details Section In Add News/Links/FAQ Screen
   #Then Select Study FAQs From Content Type Dropdown
   #Then Verify Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
   #Then Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
   #Then Verify Country 1 Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
   #Then Verify Country 2 Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
   #Then Click On Close Icon In Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
   #Then Select Site and Sponsor User Radio Button Under POSTING DETAILS Section
   #Then Verify Sponsor User Role Dropdown Displayed Under POSTING DETAILS Section
   #Then Verify Site User Role Dropdown Displayed Under POSTING DETAILS Section
   #Then Select "Monitor - Country Specific" Role From Sponsor User Role Dropdown
   #Then Select "Principal Investigator" Role From Site User Role Dropdown
   #Then Verify Compound Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible
   #hen Verify Program Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible
   #Then Verify Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Is Visible
   #Then Select Compound 1 For StudyId 1 In Compound Dropdown
   #Then Select Program 1 For StudyId 1 In Program Dropdown
	 #Then Select Study ID 1 From Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
	 
	 #Then Click On Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section Displayed
	 #Then Select Country 1 Displayed Under Study Country dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section For Study FAQs
	 #Then Click On Upload New Document Button Under DETAILS OF THE FAQ Section 
   #Then Upload New Document From Local Machine
   #Then Set Document Description In Upload New Document PopUp
   #Then Click On Upload Button In Upload New Document PopUp
   #Then Select Display Date In Display Date Under DETAILS OF THE FAQ Section
   #Then Select Current Date In Expiration Date Under DETAILS OF THE FAQ Section
   #Then Click On PROCEED Button Under DETAILS OF THE FAQ Section
   #Then Verify Country 1 Displayed Under Study Country In Study FAQs PopUp
   #Then Click On Publish Button In Study Link PopUp
   #Then Click On OK Button In News/Link/FAQ has been successfully published PopUp
   #Then Select Study FAQs From Content Type Dropdown Under Manage News/Links/FAQ Screen
   #Then Click On SEARCH Button Under Manage News/Links/FAQ Screen
	 #Then Select 50 From Show Row Under Manage News/Links/FAQ Screen
	 #Then Verify Newly Created Study FAQs Displayed Under Manage News/Links/FAQ Table For Study 1
	 #Then Verify Columns Of Manage News/Links/FAQ Table
	 #Then Select "Study Country" Option From Show/Hide Columns Dropdown
	 #Then Verify Country 1 Displayed Under Study Country Column For Newly Created Study Link
	 #Then Logout from SipApplication
   #Then Close the browser
   
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 1
   #Then Site User Navigate To View All Workspaces
   #Then Site User Navigate To Study 1
   #Then Verify Newly Created FAQs Displayed Under Study FAQ
   #Then Logout from SipApplication
   #Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_SponsorUser 2
   Then Sponsor User Navigate To View All Workspaces
   Then Sponsor User Navigate To Study 1
   Then Verify Newly Created FAQs Displayed Under Study FAQ
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_SponsorUser 3
   Then Sponsor User Navigate To View All Workspaces
   Then Sponsor User Navigate To Study 1
   Then Verify Newly Created Study Link Not Displayed Under Study Links
   Then Logout from SipApplication
   Then Close the browser