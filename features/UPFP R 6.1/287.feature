@287
Feature: 287
  
  Scenario: 287
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then clickok
   Then Navigatetopublicationpresentation
   Then verifyaddrecordpublication
   Then verifyerrormsg1
   Then verifypublicationpopup
   Then presentationsubsection
   Then verifyerrormsg2
   Then verifypresentationpopup
   #Then Logout 
   Then Close the browser
   