@18761
Feature: 18761
 
  
  Scenario: 18761
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "kasperr_0428@securepass.exostartest.com" bypass login   
   
  Then Navigate To MyProfile
  Then Click On Edit Button To Update Name
  Then Click On Save
  Then VerifyName
  
  
  Then NavigatetoMyfacility
  Then ClickOnHyperlink as "FacilityName"
  Then NevigateToInvestigationalProduct
  Then Click On PlusTcon To Verify Name
  Then Logout from SipApplication
  Then Close the browser
   
   
   
     Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "spadmin1@curie-member-id0" bypass login   
   Then Navigateandverifyfacilitydepartmentaudittrailreport
  Then FillDetailsForFacilityDepartmentAuditTrail With Faciliy as "FacilityName"
  Then GenerateReport
 Then Logout from SipApplication
  Then Close the browser
 