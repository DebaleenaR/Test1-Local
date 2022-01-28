@14753
Feature: 14753
 
  
  Scenario: 14753
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "ghosht_8706@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "FacilityName"     
                                           #Should have Golden Facility
#   Answer Question of ConsentTraining
   Then NevigateToConsentTrainingOnly
   Then AnswerAllConsentTrainingquestion
    Then SelectThreeLanguage

#   Answer Question ofFacilityAndEquipment
   Then NevigateToFacilityAndEquipmentOnly
   Then AnswerAllFacilityAndEquipment
   Then SelectThreeInternet
   
#   NevigateBackTofacility
   Then NavigatetoMyfacility
   Then ClickOn Action with facilities as "FacilityName"
   Then ClickOn ExportFacilityProfileUnderActionPDFForm  
#                                                         #Need to change index at which place the facility is                                                         
   Then clickonhome 
   Then NevigateToMyTaskAndVerify
   Then ClickTheLinkForDownload
   Then Logout from SipApplication
   Then Close the browser
#   Logout from SiteUser
   
   
   
#   Login to SponserUser  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "spadmin1@curie-member-id0" bypass login 
   Then NavigatetoSponserSearchfacility
   Then EnterSponserCountryAndFacilityName
   Then ClickOnFacilityLink      
  Then SwitchTab
 Then NevigateToConsentTrainingOnly
 Then NevigateToFacilityAndEquipmentOnly
 Then ScrolldeepdownAndVerify
 Then Logout from SipApplication
 Then Close the browser

   
  
  
#   Login to CRO  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "jupiter.cro@venus-member-id0" bypass login 
   Then NavigatetoSponserSearchfacility
   Then EnterSponserCountryAndFacilityName
   Then ClickOnFacilityLink 
  Then SwitchTab
 Then NevigateToConsentTrainingOnly
 Then NevigateToFacilityAndEquipmentOnly
 Then ScrolldeepdownAndVerify
 Then Logout from SipApplication
 Then Close the browser
 