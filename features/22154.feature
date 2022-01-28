@22154
Feature: 22154
 
  
  Scenario: 22154
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   Then Navigatetoorganizationandverify
   
   Then Click On Hyperlink of Organization 1
   Then Click Facility/Department Affiliations Section
   Then Click On Add Affiliated Facilty/Department Button
   Then Select Facility 1 Country From Country Dropdown
   Then Set Facility 1 In Facility Name TextBox
   Then Click On Search button In Search Facility/Department Affiliations Section
   Then Click On ADD Department Icon Against Facility 1 In Search Facility/Department Affiliations Screen
   Then Verify Department Name & Address Screen Is Displayed
   Then Set Department 1 In Department Name Text box
   Then Select Department Type Of Department 1 In Department Name & Address Screen
   Then Click On save Button In Department Name & Address Screen
   Then Verify New Department Created/ Identify Contact PopUp Displayed
   Then Click On Option I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE
   Then Click On GO TO MY USER PROFILE Button
   Then Verify Facility 1 And Department 1 Is Displayed In Facilities Screen
   
   Then Navigatetoorganizationandverify
   
   Then Click On Hyperlink of Organization 1
   Then Click Facility/Department Affiliations Section
   Then Click On Add Affiliated Facilty/Department Button
   Then Select Facility 1 Country From Country Dropdown
   Then Set Facility 1 In Facility Name TextBox
   Then Click On Search button In Search Facility/Department Affiliations Section
   Then Click On ADD Department Icon Against Facility 1 In Search Facility/Department Affiliations Screen
   Then Verify Department Name & Address Screen Is Displayed
   Then Set Department 2 In Department Name Text box
   Then Select Department Type Of Department 2 In Department Name & Address Screen
   Then Click On save Button In Department Name & Address Screen
   Then Verify New Department Created/ Identify Contact PopUp Displayed
   Then Click On Option I_WILL_CREATE_MAINTAIN_THE_DEPARTMENT_PROFILE
   Then Click On GO TO MY USER PROFILE Button
   Then Verify Facility 1 And Department 2 Is Displayed In Facilities Screen
   
   Then Site User Navigate To Notification Screen
   Then Verify Facility Profile Management Notifications For Facility 1 and Department 1 In Notification Screen
   Then Verify Facility Profile Management Notifications For Facility 1 and Department 2 In Notification Screen
   
   Then Logout from SipApplication
   Then Close the browser