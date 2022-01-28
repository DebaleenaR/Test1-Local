@8818-B
Feature: 8818-B
 
 
  
  Scenario: 8818-B
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "bravor_1962@securepass.exostartest.com" bypass login 
#   Then NevigateToMyTaskPageAndVerify as "Facility Profile available for download."
#   Then ClickOnTaskTitle as "Facility Profile available for download."
##   Step10 is pending

  Then NavigatetoMyfacility
  Then ClickOn Action with facilities as "FacilityName"
   Then AddDepartmentFromActionOnly
   Then AddExisting Department as "BurnierDep"
   Then HoverOverTheHyperLink as "Facility+Department"
   Then ClickOn Action with facilities as "Facility+Department"
   
   Then ClickOn ExportDepartmentProfileUnderActionPDFForm
   Then Logout from SipApplication
   


#   Then Close the browser
   
  
  

 