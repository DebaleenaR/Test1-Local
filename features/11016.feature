@11016
Feature: 11016
 
  
  Scenario: 11016
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "aa_6106@securepass.exostartest.com" bypass login   
   Then Navigatetoorganization1andverify
   Then Navigatetoorganizationcontact
   Then Navigatetobulkuploadcontactandverify
   Then verifyradiobuttoninviteorganizationcontact
   Then verifyendregistrationinvitation
   Then downloadtemplate
   Then verifybuttondisable
   Then choosefileselectfile
   Then clickuploadandaddcontactbutton
   Then clickonokbutton
   #Then Logout
   Then Close the browser
   
  
  

 