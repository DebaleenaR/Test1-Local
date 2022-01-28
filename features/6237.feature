@6237
Feature: 6237
 
  
  Scenario: 6237
# SuteUser Login 
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login
   Then Navigatetosearchfacilityandverify


   Then EnterCountry as "CountryField" and Facility as "FacilityName" and Search
   Then ClickOn + buttonForSite
   Then EnterCountry as "CountryField2" and Facility as "FacilityName2" and Search
   Then ClickOnCancelButtonToNevigateBackAfterVerifyErrorMsg
   Then Logout from SipApplication
  
  
#    Then ClickOnAddFacilityAndVerifyFacility
    
#    Then Select Facility as "FacilityName" and ClickAddFacilityToYourUser
#    Then Click IWillMaintainTheFacilityProfile And VerifyPage
#   
    
 
   