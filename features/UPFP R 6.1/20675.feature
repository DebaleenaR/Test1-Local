@20675
Feature: 20675
  
  Scenario: 20675
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifysponsorladingpage
   Then clcikonviewmoreandverify
   Then Print
   Then exportxls
   Then exportpdf
   Then exportcsv1
   #Then Logout 
   Then Close the browser
  