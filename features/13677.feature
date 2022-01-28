@13677
Feature: 13677
 
 
  
  Scenario: 13677
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "bravor_1962@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then NevigateToIRBEthics
   Then Logout from SipApplication
   


#   Then Close the browser
   
  
  

 