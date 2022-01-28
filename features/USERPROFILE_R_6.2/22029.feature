@22029
Feature: 22029
  
  Scenario: 22029
  
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 2
   #Then Navigate To User Profile > Delegated Profiles
   #Then Click On SIP User ID Of Site User 1 In Delegated Profiles Screen
   #Then Click On Facilities Section In My Profile Screen
   #Then Verify Facilities Screen Displayed
   #Then Verify On Screen Text In Facilities Screen
   #Then Select "50" From Show Rows Dropdown In Facilities Screen
   #Then Click On Facility 1 And Department 1 In Facilities Screen
   #Then Click On Facility 1 And Department 3 In Facilities Screen
   #Then Click On Facility 1 And Department 5 In Facilities Screen
   #Then Click On Facility 1 And Department 6 In Facilities Screen
   #Then Click On The Facility 2
   #Then Click On The Facility 2 And Department 1 In Facilities Screen
   #Then Click On The Facility 2 And Department 2 In Facilities Screen
   #Then Click On The Facility 2 And Department 3 In Facilities Screen
   #Then Click On The Facility 2 And Department 4 In Facilities Screen
   #Then Click On The Facility 2 And Department 5 In Facilities Screen
   #Then Click On The Facility 3
   #Then Verify Primary Facility Mark Is Disabled For Facility 1 And Department 1 In Facilities Screen
   #Then Click On Primary Facility Mark For Facility 3
   #Then Click On Primary Facility Mark For Facility 1
   #Then Verify Primary Facility Mark Is Checked For Facility 1
   #Then Click On SAVE Button In Facilities Screen
   #Then Click On SAVE Button In Delegator's User Profile PopUp
   #Then Click On Send All Changes For Approval Button
   #Then Click On OK button In Your Changes have been sent for Approval PopUp
   #Then Logout from SipApplication
   #Then Close the browser
   
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 1
   #Then Navigate To User Profile > Approve/Reject Update
	 #Then Click On Facilities Section In My Profile Screen
	 #Then Click On Approve This Change Button In Facilities Screen
	 #Then Click On OK Button In Your changes have been saved PopUp
	 #Then Click On Facilities Section In My Profile Screen
	 #Then Verify Primary Facility Mark Is Checked For Facility 1
	 #Then Logout from SipApplication
   #Then Close the browser
   
   
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 2
   #Then Navigate To User Profile > Delegated Profiles
   #Then Click On SIP User ID Of Site User 1 In Delegated Profiles Screen
   #Then Click On Facilities Section In My Profile Screen
   #Then Verify Facilities Screen Displayed
   #Then Click On Generate SIP Abbreviated CV Button In Facilities Screen
    
   #### Defect In Generate CV for Profile Owner PopUp
   
   #Then Click On PROCEED Button In Generate CV for Profile Owner PopUp
   #Then Click On OK Button In Success PopUp For Generating CV
   #Then Click On PDF Option For ABBREVIATED CV VERSION HISTORY Option
   #Then Verify Facility 1 Department 1 Present In ABBREVIATED CV
   #Then Verify Facility 1 Department 3 Present In ABBREVIATED CV
   #Then Verify Facility 1 Department 5 Present In ABBREVIATED CV
   #Then Verify Facility 1 Department 6 Present In ABBREVIATED CV
   #Then Verify Facility 2 Department 1 Present In ABBREVIATED CV
   #Then Verify Facility 2 Department 2 Present In ABBREVIATED CV
   #Then Verify Facility 2 Department 3 Present In ABBREVIATED CV
   #Then Verify Facility 2 Department 4 Present In ABBREVIATED CV
   #Then Verify Facility 2 Department 5 Present In ABBREVIATED CV
   #Then Verify Facility 3 Present In ABBREVIATED CV
   #Then Navigate To User Profile > Delegated Profiles
   #Then Click On SIP User ID Of Site User 1 In Delegated Profiles Screen
   #Then Click On Facilities Section In My Profile Screen
   
   #Then Click On Primary Facility Mark For Facility 3
   #Then Click On Generate SIP Abbreviated CV Button In Facilities Screen
   #Then Click On PROCEED Button In Generate CV for Profile Owner PopUp
   #Then Click On OK Button In Success PopUp For Generating CV
   #Then Click On PDF Option For ABBREVIATED CV VERSION HISTORY Option
   #Then Verify Facility 1 Is Not Present In ABBREVIATED CV
   #Then Logout from SipApplication
   #Then Close the browser