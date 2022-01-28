@912
Feature: 912
  
  Scenario: 912
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifypullcvsearchscreen
   Then verifylastgeneratedcvdate
   Then verify10recordsinsearchresult
   Then verify10recordsinmentionedformat
   Then verifywordpdf
   Then verifypullcvsearchscreen
   Then verifylastgeneratedcvdate
   Then verify10recordsinsearchresult
   Then verify10recordsinmentionedformat
   Then downloadzip
   #Then Logout 
   Then Close the browser
   