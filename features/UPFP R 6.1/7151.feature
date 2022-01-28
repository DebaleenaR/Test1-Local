@7151
Feature: 7151
  
  Scenario: 7151
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigateandverifypullcv
   Then verifypullhistory
   Then verify10recordsinmentionedformat
   Then verifywordpdf
   Then downloadzip
   Then Navigateandverifypullcv
   Then clickonpullcvyes
   Then verifysearchscreenresult
   Then Navigateandverifypullcv
   Then verifywordpdf
   Then clickonlastnameandverify
   #Then Logout 
   Then Close the browser
   #Given Open browser and launch SIPUrl
   #Then Application homepage is open
   Then again Open browser and launch SIPUrl
   Then enter_to_the_application_with_bypaas_logintwo
   Then clickokandverifysubrole
   Then Verifynonotification
   Then abbrivatedcvhistory
   #Then Logout 
   Then Close the browser
   
  