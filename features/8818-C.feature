@8818-C
Feature: 8818-C
 
 
  
  Scenario: 8818-C
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "bravor_1962@securepass.exostartest.com" bypass login 
   Then NevigateToMyTaskPageAndVerify as "Facility Profile available for download."
   Then ClickOnTaskTitle as "Facility Profile available for download."
#   Step18 is pending

 
   


#   Then Close the browser
   
  
  

 