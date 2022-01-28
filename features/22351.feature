@22351
Feature: 22351
  
  Scenario: 22351
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Proper_Login_Siteuser 1
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then Navigatetoorganizationandverify
   Then Click On Hyperlink of Organization 1
   Then Click Facility/Department Affiliations Section
   Then Click On Add Affiliated Facilty/Department Button
   Then Select Facility 1 Country From Country Dropdown
   Then Set Facility 1 In Facility Name TextBox
   Then Click On Search button In Search Facility/Department Affiliations Section
   Then Verify ADD Department Icon Against Facility 1 In Search Facility/Department Affiliations Screen
   
   Then Navigatetoorganizationandverify
   Then Click On Hyperlink of Organization 1
   Then Click Facility/Department Affiliations Section
   Then Click On Add Affiliated Facilty/Department Button
   Then Select Facility 2 Country From Country Dropdown
   Then Set Facility 2 In Facility Name TextBox
   Then Click On Search button In Search Facility/Department Affiliations Section
   Then Verify ADD Department Icon Not Displayed Against Facility 2 In Search Facility/Department Affiliations Screen
   
   Then Navigatetoorganizationandverify
   Then Click On Hyperlink of Organization 1
   Then Click Facility/Department Affiliations Section
   Then Click On Add Affiliated Facilty/Department Button
   Then Select Facility 3 Country From Country Dropdown
   Then Set Facility 3 In Facility Name TextBox
   Then Click On Search button In Search Facility/Department Affiliations Section
   Then Verify ADD Department Icon Not Displayed Against Facility 3 In Search Facility/Department Affiliations Screen
   
   Then Logout from SipApplication
   Then Close the browser