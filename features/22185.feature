@22185
Feature: 22185
 
  
  Scenario: 22185
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Proper_Login_Siteuser 1
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then Navigatetoorganizationandverify
   Then Click On Hyperlink of Organization 1
   Then Click Facility/Department Affiliations Section
   Then Verify Facility 1 with Department 1 is Displayed In Facility/Department Affiliations Screen
   Then Click On Add Affiliated Facilty/Department Button
   Then Select Facility 1 Country From Country Dropdown
   Then Set Facility 1 In Facility Name TextBox
   Then Click On Search button In Search Facility/Department Affiliations Section
   Then Verify ADD Department Icon Against Facility 1 And Department 1 In Search Facility/Department Affiliations Screen Is Not Displayed
   Then Logout from SipApplication
   Then Close the browser