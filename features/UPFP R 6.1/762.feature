@762
Feature: 762
  
  Scenario: 762
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifybasicdetailssection
   Then verifyuploadform
   Then navigateandverifyeachsection
   Then verifybasicdetailsupdate
   Then verifyoverwritten
   Then verifypublicationpresentationoverwritten
   Then verifysiteuser1delattetosite2
   #Then Logout 
   Then Close the browser
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then clickok
   Then navigatetodelegatedprofiles
   #Then Logout 
   Then Close the browser
  
  