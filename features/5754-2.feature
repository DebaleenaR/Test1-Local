@5754-2
Feature: 5754-2
 
  
  Scenario: 5754-2
# SuteUser Login 
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "gomezj_3303@securepass.exostartest.com" bypass login
   Then NavigatetoMyfacility
   Then HoverOverTheHyperLink as "Facility+Department"
   
   Then clickonbell
   Then VerifyNotification
   Then Logout from SipApplications
   
   
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "gomezl_6590@securepass.exostartest.com" bypass login
   Then NavigatetoMyfacility
   Then HoverOverTheHyperLink as "Facility+Department"
   Then clickonbell
   Then VerifyNotification
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   
   
#   Verify All sections
   Then NevigateToDepartmentContact
   Then ScrolldownForVerify
   Then NevigateToTherapeuticAreasPatientPopulation
    Then ScrolldownForVerify
    Then NevigateToIRBEthics
     Then ScrolldownForVerify
    Then NevigateToLocalLab
     Then ScrolldownForVerify
    Then NevigateToConsentTrainingOnly
     Then ScrolldownForVerify
    Then NevigateToFacilityAndEquipmentOnly
     Then ScrolldownForVerify
    Then NevigateToInvestigationalProduct
     Then ScrolldownForVerify
    Then NevigateToSourceDocumentation
     Then ScrolldownForVerify
   Then NevigateToAdditionalInformation
    Then ScrolldownForVerify
   Then NevigateToAdditionalLocations
    Then ScrolldownForVerify
   
   
#   Then Navigatetosearchfacilityandverify
#   Then EnterCountry as "CountryField" and Facility as "FacilityName" and Search
#   Then Select Facility as "FacilityName" and ClickAddFacilityToYourUser
   
#   Steps are pending


   


#   Then Logout from SipApplication


   