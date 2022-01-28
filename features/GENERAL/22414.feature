@22414
Feature: 22414
  
  Scenario: 22414
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_SponsorUser 1
   
   Then Navigate To Admin > Manage News/Links/FAQ
   Then Verify Admin > Manage News/Links/FAQ Breadcrumb
   Then Verify Print Icon In Manage News/Links/FAQ Screen
   Then Verify Export Icon In Manage News/Links/FAQ Screen
   Then Verify Add News/Links/FAQ Icon In Manage News/Links/FAQ Screen
   Then Click On Add News/Links/FAQ Button In Manage News/Links/FAQ Screen
   Then Verify Add News/Links/FAQ Screen Is Displayed
   Then Verify Admin > Manage News/Links/FAQ > Add News/Links/FAQ Breadcrumb
   Then Verify OnScreen Text For Add News/Links/FAQ Section
   Then Verify POSTING DETAILS Header In Add News/Links/FAQ Screen
   Then Verify POSTING DETAILS Section In Add News/Links/FAQ Screen
   Then Verify DISPLAY NEWS/LINKS/FAQ TO Header In Add News/Links/FAQ Screen
   Then Verify DISPLAY NEWS/LINKS/FAQ TO Input Section In Add News/Links/FAQ Screen
   Then Verify Details Header In Add News/Links/FAQ Screen
   Then Verify Details Section In Add News/Links/FAQ Screen
   Then Select Study Links From Content Type Dropdown
   Then Select Sponsor User Radio Button Under POSTING DETAILS Section
   Then Select "Monitor - Country Specific" Role From Sponsor User Role Dropdown
   Then Select Compound 1 For StudyId 1 In Compound Dropdown
   Then Select Program 1 For StudyId 1 In Program Dropdown
	 Then Select Study ID 1 From Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
	 Then Enter Text In Subject Textbox Under DETAILS Section
	 Then Enter URL In URL TextBox Under DETAILS Section
	 Then Select Display Date In Expiration Date Under DETAILS Section
	 Then Select Current Date In Expiration Date Under DETAILS Section
	 Then Click On PROCEED Button Under DETAILS Section
	 Then Verify Study Country is required Error Message
	 
	 Then Click On SIP Logo
	 Then Navigate To Admin > Manage News/Links/FAQ
	 Then Click On Add News/Links/FAQ Button In Manage News/Links/FAQ Screen
	 Then Verify Add News/Links/FAQ Screen Is Displayed
	 Then Select Study FAQs From Content Type Dropdown
	 Then Select Sponsor User Radio Button Under POSTING DETAILS Section
	 Then Select "Monitor - Country Specific" Role From Sponsor User Role Dropdown
	 Then Select Compound 1 For StudyId 1 In Compound Dropdown
   Then Select Program 1 For StudyId 1 In Program Dropdown
	 Then Select Study ID 1 From Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
	 Then Click On Upload New Document Button Under DETAILS OF THE FAQ Section 
   Then Upload New Document From Local Machine
   Then Set Document Description In Upload New Document PopUp
   Then Click On Upload Button In Upload New Document PopUp
   Then Select Display Date In Display Date Under DETAILS OF THE FAQ Section
   Then Select Current Date In Expiration Date Under DETAILS OF THE FAQ Section
   Then Click On PROCEED Button Under DETAILS OF THE FAQ Section
   Then Verify Study Country is required Error Message
   
   Then Click On SIP Logo
	 Then Navigate To Admin > Manage News/Links/FAQ
	 Then Click On Add News/Links/FAQ Button In Manage News/Links/FAQ Screen
	 Then Verify Add News/Links/FAQ Screen Is Displayed
	 Then Select Study News From Content Type Dropdown
	 Then Select Sponsor User Radio Button Under POSTING DETAILS Section
	 Then Select "Monitor - Country Specific" Role From Sponsor User Role Dropdown
	 Then Select Compound 1 For StudyId 1 In Compound Dropdown
   Then Select Program 1 For StudyId 1 In Program Dropdown
	 Then Select Study ID 1 From Study ID Dropdown Under DISPLAY NEWS/LINKS/FAQ TO Section
	 Then Click On PROCEED Button Under DETAILS Section
	 Then Verify Study Country is required Error Message
	 
	 Then Logout from SipApplication
   Then Close the browser