@15986
Feature: 15986
  
  Scenario: 15986
# Sponser Login
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "spadmin1@curie-member-id0" bypass login 
   Then NavigatetoSponserSearchfacility
   Then EnterSponserCountryStateFacilityNameAndSIPID
   Then VerifyFacilitySearch
   Then ClickOnViewDepartmentAndVerify
   Then Logout from SipApplication
   
   
   
#   CRO login
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "mercury.cro.admin@mercury-member-id0" bypass login 
   Then NavigatetoSponserSearchfacility
   Then EnterSponserCountryStateFacilityNameAndSIPID
   Then VerifyFacilitySearch
   Then ClickOnViewDepartmentAndVerify
   Then Logout from SipApplication