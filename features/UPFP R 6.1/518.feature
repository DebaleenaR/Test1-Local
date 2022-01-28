@518
Feature: 518
  
  Scenario: 518
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifyplaceholdertext
   Then verifypullcvsearchscreen
   Then verifylastgeneratedcvdate
   Then verify10recordsinsearchresult
   Then verify10recordsinmentionedformat
   Then selectallacheckboxdownloadcvenable
   Then novaluesaredisplayedinlist
   Then searchscreendisplayed
   Then verify10recordsinsearchresult
   Then verify2ndpage
   Then noprevpaginationdisplayed
   Then verify2ndpage
   Then Verifylastpage
   Then verifyprevpage
   Then noprevpaginationdisplayed
   Then verrifyenteredpageno
   #Then Logout 
   Then Close the browser
   