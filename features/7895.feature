@7895
Feature: 7895
 
  
  Scenario: 7895
  
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login
   Then Navigatetosearchfacilityandverify
   Then clickOnSearchAndVerifyErrorsAndFields
   Then EnterCountry as "CountryField" and Facility as "FacilityName" and Search
   Then ClickOnCancelButtonToNevigateBackAndVerify
   Then EnterCountry as "CountryField" and Facility as "FacilityName" and Search
   Then Select Facility as "FacilityName" and ClickAddFacilityToYourUser
   Then VerifyAddDeparmentPage
   Then Navigatetosearchfacilityandverify
   Then EnterCountry as "CountryField2" and Facility as "FacilityName2" and Search
   Then Select Facility as "FacilityName2" and ClickAddFacilityToYourUser  
   Then Click IWillMaintainTheFacilityProfile And VerifyPage
   Then Click On FacilityHyperlink 
   Then Click On EnterFacilityProfileManually And Verify Green FacilityContact
   