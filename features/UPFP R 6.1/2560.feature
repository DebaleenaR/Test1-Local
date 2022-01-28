@2560
Feature: 2560
  
  Scenario: 2560
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigatetomyprofileandverifies
   Then verifyliceseddetails
   Then Addlicenseanduploaddoc
   Then verifyprofileattchement
   Then generateCVButton1
   Then verifymentionedtab
   Then verifytablenorecord
   #Then Logout 
   Then Close the browser
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then selectuserfacilitydocumentauditrailreport
   Then generatereport
   Then reportcolumnverification
   Then changedatetimestamp
   Then checkutctime
   Then reportcolumnverification
   Then verifychangeby
   Then verifypagination
   Then verifyexport
   Then clickonprint
   #Then Logout 
   Then Close the browser
 
   
 
 
  
   
   
   
   