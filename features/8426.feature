@8426
Feature: 8426
 
  
  Scenario: 8426
#  Login to SiteUserOne

   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then HoverOverTheHyperLink as "FacilityName"
   Then ClickOnHyperlink as "FacilityName"
   Then NevigateToLocalLab
   Then ClickOnYesUnderLocalLab
   Then ScrolldownToClickonButton
   Then NevigteTo<IRBEthicsCommitteAndverify
   Then NevigateToLocalLab
   Then ScrolldownToClickonButton
   Then NevigateToConsentTraing>Andverify
   
   Then NevigateToLocalLab
   Then NevigateToTherapeuticAreasPatientPopulation
                                                    #Click on AnySection on left                                              


   Then NevigateToLocalLab
   Then ScrolldownToClickonButton
   Then NevigteTo<IRBEthicsCommitteAndverify
    Then NevigateToLocalLab
   Then ScrolldownToClickonButton
   Then NevigateToConsentTraing>Andverify
   
   Then NevigateToLocalLab
   Then NevigateToTherapeuticAreasPatientPopulation
                                                    #Click on AnySection on left                                                      


   Then NevigateToLocalLab
   
#   Step8

#   For IrbEthics
   Then EnterLocalLabFewMendatoryFields
   Then NevigateToIRBEthics
   Then VerifyvalidationMessage
   Then ClickOnX
   Then EnterLocalLabMendatoryFields
   Then NevigateToIRBEthics
   Then VerifyvalidationMessage         
   Then ClickOnSaty                            
   Then EnterLocalLabFewMendatoryFields                               
   Then NevigateToIRBEthics
   Then VerifyvalidationMessage     
   Then ClickOnLeave   
   Then ThenVerifyIRBEthics        
   Then NevigateToLocalLab   
   
#    For consentTraning          
     Then EnterLocalLabMendatoryFields      
     Then NevigateToConsentTrainingOnly 
     Then VerifyvalidationMessage    
      Then ClickOnX   
      Then NevigateToConsentTrainingOnly 
      Then VerifyvalidationMessage   
      Then ClickOnSaty 
      Then EnterLocalLabFewMendatoryFields 
      Then NevigateToConsentTrainingOnly 
      Then VerifyvalidationMessage
      Then ClickOnLeave  
      Then VerifyConsentTraining 
      Then NevigateToLocalLab      
      
#      Step23
      
      Then Logout from SipApplication         
#   Then Close the browser

   
  
  

 