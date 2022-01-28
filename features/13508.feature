@13508
Feature: 13508
 
  
  Scenario: 13508
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "bryantn_8460@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then NavigatetoIRBERB
   Then NavigatetoLocalIRBCommitte
   Then EnterLocalIRBCommitteWithoutName
   Then EnterLocalIRBCommitteDetails
   Then Logout from SipApplication
   


#   Then Close the browser
   
  
  

 