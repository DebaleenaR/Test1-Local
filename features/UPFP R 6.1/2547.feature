@2547
Feature: 2547
  
  Scenario: 2547
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifypullcvsearchscreen
   Then verifylastgeneratedcvdate
   Then clickonlastnameandverify
   Then abbrivatedcvhistory
   Then verifyeachsection
   Then verifylicense
   Then profileatachment
   #Then Logout 
   Then Close the browser
   