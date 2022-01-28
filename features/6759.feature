@6759
Feature: 6759
 
 
  
  Scenario: 6759
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "smitha_4214@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then Verify All Section Of Facility/Department
   Then OrganizationAffiliations
  Then Verify Affiliation Status
  Then ClickHyperLink as "DS_ORG 1"
  Then SwitchTabandCloseNewtab
  Then Click On Action Under OrganizationAffiliation as "DS_ORG 1" 
  Then Click On Action Under OrganizationAffiliation as "DS_ORG 3" 
  Then Click On Send Msg To OPM Under Action
   Then Logout from SipApplication
 
  
   


#   Then Close the browser
   
  
  

 