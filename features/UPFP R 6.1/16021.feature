@16021
Feature: 16021
  
  Scenario: 16021
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigatetopublicationpresentation
   Then verifyaddrecordpublication
   Then clickpublicationsave
   Then Navigatetopublicationpresentation
   Then verifyaddrecordpublication
   Then clickpublicationsave
   #Then Logout 
   Then Close the browser
  