@4585
Feature: 4585
  
  Scenario: 4585
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   #Then clickok
   Then Navigatandverifyoworkspace
   Then uploaddocumententerfieldsandverify
   Then selectPIandverify
   Then verifysiteuser2
   Then selectsiteuser2upload
   Then verifydocumentsearch
   Then verfiydocument1searchresult
   #Then Logout 
   Then Close the browser
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   #Then again Open browser and launch SIPUrl
   Then enter_to_the_application_with_bypaas_logintwo
   Then Navigatetocommondocument
   Then verfiydocument1searchresult
    #Then Logout 
   Then Close the browser
   