@13671
Feature: 13671
 
 
  
  Scenario: 13671
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "bravor_1962@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "FacilityName"
   Then NevigateToIRBEthics
   Then Logout from SipApplication
   


#   Then Close the browser
   
  
  

 