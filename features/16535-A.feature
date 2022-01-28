@16535-A
Feature: 16535-A
 
  
  Scenario: 16535-A
# SuteUser Login 
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "bravor_1962@securepass.exostartest.com" bypass login
#   Then Navigatetosearchfacilityandverify
#   Then EnterSiteUserCountryStateCity
#   
#   Then Select Facility as "FacilityName" and ClickAddFacilityToYourUser
#   Then Click IWillMaintainTheFacilityProfile And VerifyPage


#TesttingPerpose

   Then NavigatetoMyfacility
   
   Then ClickOnHyperlink as "FacilityName"
   Then ClickOnSIPFacilityProfileButton
   Then BrowseFile and VerifyUploadButton as "DocPath1"
   Then ClickOnUploadButtonandVerify
   
   
      Then Logout from SipApplication

   





   





   