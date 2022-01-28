@14236
Feature: 14236
 
  
  Scenario: 14236
  
#  Login to sponser User
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "spadmin1@curie-member-id0" bypass login  
   Then  Navigateandverifyfacilitydepartmentaudittrailreport
   Then FillDetailsUnderAudittrail as "Date1" And "Date2"
   Then GenerateReport
   Then ExportPDF 
   Then Exportasxls
#   Then ClickOnprint
#   print cancel manually
   Then Logout from SipApplication
#   logout from sponser

## SuteUser Login 
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "ghosht_8706@securepass.exostartest.com" bypass login
   Then NavigatetoMyfacility
    Then ClickOnHyperlink as "Facility+Department"
    Then NevigateToInvestigationalProduct
    Then RemoveOneIPshippingLocation
    Then SaveAndVerify
    Then Logout from SipApplication
##   Logout From siteUser
#   
#   
#   
##  Login to sponser User
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "spadmin1@curie-member-id0" bypass login  
   Then  Navigateandverifyfacilitydepartmentaudittrailreport
   Then FillDetailsUnderAudittrail as "Date1" And "Date2"
   Then GenerateReport
   Then ExportPDF 
   Then Exportasxls
#   Then ClickOnprint
##   print cancel manually
   Then Logout from SipApplication
##   logout from sponser

   
   
   
   


  
#   
#   Then Close the browser
   
  
  

 