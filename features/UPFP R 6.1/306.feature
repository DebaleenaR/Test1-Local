@306
Feature: 306
  
  Scenario: 306
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then clickok
   Then verifyuserprofilemenu
   Then verifyprofilesummary
   Then verifymentionedtab
   Then verifyfollowingattribute
   Then verifyprofilephoto
   Then verifyuserprofilesummarysection
   Then verifyerrormsg12
   Then uploadimage
   #Then Logout 
   Then Close the browser
  
  