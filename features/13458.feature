@13458
Feature: 13458
  
  Scenario: 13458
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "boothm_4065@securepass.exostartest.com" bypass login
   Then Navigatedtodelegatedprofile
   Then Verifysiteuser1details
   Then Verifybasicdetail
   Then Updateprofessionalexpandsendallchangesforapproval
   #Then Logout 
   Then Close the browser
   #Given Open browser and launch SIPUrl
   #Then Application homepage is open
   Then again Open browser and launch SIPUrl
   Then Enter to the application with "markremh_3189@securepass.exostartest.com" bypass login
   Then Navigatedtoapproverejectupdate
   #Then Logout 
   Then Close the browser