@22354
Feature: 22354
 
  
  Scenario: 22354
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then Navigatetoorganizationandverify
   Then Click On Hyperlink of Organization 1
   Then Click On Organization Contacts Tab
   Then Click On Add Organization Contacts Button In Organization Contacts Screen
   Then Set Site User 3 Email ID In Organization Contact Email Address Section
   Then Select ORGANIZATION CONTACT ROLES As "Organization Profile Management"
   Then Click On Add Button In Add Organization Contact Screen
   Then Verify Site User 3 Is added as "Organization Profile Manager"
   Then Click On Remove icon Against Site User 1 having Role as "Organization Profile Manager"
   Then Click On OK button In Remove Organization Contact PopUp
   Then Verify Site User 1 Is Not Added As "Organization Profile Manager"
   Then Navigatetoorganizationandverify
   Then Click On Hyperlink of Organization 1
   Then Click Facility/Department Affiliations Section
   Then Verify Add Affiliated Facilty/Department Button Not Displayed
   Then Logout from SipApplication
   Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 3
   Then If Urgent Tasks - Action Required! PopUp Displayed Click On Ok
   Then Navigatetoorganizationandverify
   Then Click On Hyperlink of Organization 1
   Then Click On Add Affiliated Facilty/Department Button
   Then Select Facility 1 Country From Country Dropdown
   Then Set Facility 1 In Facility Name TextBox
   Then Click On Search button In Search Facility/Department Affiliations Section
   Then Verify ADD Department Icon Against Facility 1 In Search Facility/Department Affiliations Screen
   
   
   
   
   
   Then Logout from SipApplication
   Then Close the browser