@1495
Feature: 1495
  
  Scenario: 1495
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginthree
   Then Navigatetomyprofileandverifies
   Then verifysections
   Then verifyeducationyearcompletedcolumn
   Then verifyaddcompleted
   Then deleted1recordeducation
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then Navigatedtodelegatedprofile
   Then Navigatetomyprofileandverifies
   Then verifysections
   Then verifyeducationyearcompletedcolumn
   Then verifyaddcompleted
   Then deleted1recordeducation
   Then Updateprofessionalexpandsendallchangesforapproval
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Verifynonotification
   Then selectuserprofileauditrailreport
   Then generatereport
   Then reportcolumnverification
   Then verifyexport
   Then clickonprint
   Then clearsearchreport
   Then selectuserprofileauditrailreport
   Then generatereport
   Then reportcolumnverification
   Then verifyexport
   Then clickonprint
   #Then Logout 
   Then Close the browser
 
  
   
   
   
  