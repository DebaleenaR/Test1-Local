@5844
Feature: 5844
 
  
  Scenario: 5844
# SuteUser Login 
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "FacilityName"
   Then NevigateToFacilityAndEquipmentOnly
   Then ScrolldeepdownAndVerify
   Then VerifySubSectionFacilityCapability
   Then VerifySubsectionEquipment
   Then VerifySubsectionGeneralEquipment
   Then VerifySubsectionComputerCapabilities
   Then ClickOnInvestigationalProduct>
   Then ClickOn<Facility&Equipment
   Then SelectYesForQuestionPKPD
   Then AnswerAllFacilityAndEquipment
   Then SelectThreeInternet
   
   
   Then NevigateToConsentTraing>Andverify
   Then ClickOn<Facility&Equipment

    
     



   


#   Then Logout from SipApplication


   