@14025
Feature: 14025
 
  
  Scenario: 14025
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOn Action with facilities as "FacilityName"
   Then ClickOn ExportFacilityProfileUnderActionPDFForm
   Then clickonhome  
   
    Then NavigatetoMyfacility
   Then ClickOn Action with facilities as "FacilityName"
   Then ClickOn ExportFacilityProfileUnderActionDocForm
   Then clickonhome 
   Then Logout from SipApplication
   


#   Then Close the browser
   
  
  

 