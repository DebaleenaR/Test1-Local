@8818-A
Feature: 8818-A
 
 
  
  Scenario: 8818-A
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "bravor_1962@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "FacilityName"
  
  Then Edit Building Address By Special Character
  Then NavigatetoMyfacility
  Then ClickOn Action with facilities as "FacilityName"
  Then ClickOn ExportFacilityProfileUnderActionDocForm
   Then Logout from SipApplication
   


#   Then Close the browser
   
  
  

 