@769
Feature: 769
  
  Scenario: 769
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then Verify navigatedtositeuser1
   Then verifyuploadform
   Then navigateandverifyeachsection
   Then verifypublicationpresentationoverwritten
   Then verifybasicdetailsupdate
   Then Licensedetail
   Then clickonokbuttonwithconfirmation
   Then verifyredirecttotodelegatedprofile
   #Then Logout 
   Then Close the browser
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifyapproverejectbuttons
   Then navigateandverifyeachsection
   #Then Logout 
   Then Close the browser
  
  