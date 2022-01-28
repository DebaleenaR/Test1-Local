@uploadcharvalidation
Feature: uploadcharvalidation
  
  Scenario: uploadcharvalidation
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigatetomyprofileandverify
   Then clickonprofileplaceholderverify
   Then selectexceedingimageverify
   Then selectexceedingimageverify255
   Then selectexceedingimageverify256
   Then Navigatetomyprofileandverify
   Then navigatsipuserprofileform
   Then uploaddownloadedcv
   Then uploaddownloadedcv255
   Then uploaddownloadedcv256
   Then Navigatetomyprofileandverify
   Then Addlicenseanduploaddoc
   Then filldetailandupload
   Then filldetailandupload255
   Then filldetailandupload256
   Then Navigatetomyprofileandverify
   Then verifyprofileattchement
   Then uploadprofileattachment
   Then uploadprofileattachment255
   Then uploadprofileattachment256
   #Then Logout 
   Then Close the browser
   