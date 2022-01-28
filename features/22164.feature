@22164
Feature: 22164
 
  
  Scenario: 22164
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigatetoorganizationandverify
   Then Click On Hyperlink of Organization 1
   Then Click Facility/Department Affiliations Section
   Then Verify That Facility 1 Is Displayed In Facility/Department Affiliations Screen
   Then Click On Remove Icon Against Facility 1 Is Displayed In Facility/Department Affiliations Screen
   Then Click On Confirm Button In Remove Facility/Department Affiliation PopUp
   Then Verify Facility 1 Is Not Displayed In Facility/Department Affiliations Screen
   Then NavigatetoMyfacility
   Then Verify Facility 1 Is Displayed In Facilities Screen
   Then Click On Add Department Option From Action icon For Facility 1
   Then Verify CREATE NEW DEPARTMENT Button Is Disabled
   Then Logout from SipApplication
   Then Close the browser