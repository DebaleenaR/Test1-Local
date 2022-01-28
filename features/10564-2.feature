@10564-2
Feature: 10564-2
 
  
  Scenario: 10564
  
# Execute this script After 15 min 
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "smitha_4214@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
    Then ClickOnHyperlink as "Facility+Department"

#    Nevigate to All section
    Then NevigateToDepartmentContact
    Then NevigateToTherapeuticAreasPatientPopulation
    Then NevigateToIRBEthics
    Then NevigateToLocalLab
    Then NevigateToConsentTrainingOnly
    Then NevigateToFacilityAndEquipmentOnly
    Then NevigateToInvestigationalProduct
    Then NevigateToSourceDocumentation
   Then NevigateToAdditionalInformation
   
    Then NevigateToAdditionalLocations
    
#    Then OrganizationAffiliations
    
    Then Logout from SipApplication
    
   


#   Then Close the browser
   
  
  

 