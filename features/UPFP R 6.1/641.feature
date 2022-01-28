@641
Feature: 641
  
  Scenario: 641
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then clickonmytaskandverify
  Then userprofilemyprofile
    Then Navigatetoeducation
   Then NavigatetoProfessionalexp
   Then Navigatetoreseachexp
   Then Navigatetolicensedetail
   Then Navigatetoprofileattachment
   Then Navigattopublicationpresentation
  Then verifysipuserprofile
  Then downloadprofiletemplate
  Then verifyuploadform
  Then navigateandverifyeachsection 
Then Updateprofessionalexpandsendallchangesforapproval
   #Then Logout 
   Then Close the browser
   Then Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then clickonmytaskandverify
   Then verifyapproverejectbuttons
   Then navigateandverifyeachsection
   Then approveall
   #Then Logout 
   Then Close the browser
   
  