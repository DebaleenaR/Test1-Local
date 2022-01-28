@14936
Feature: 14936
 
  
  Scenario: 14936
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "smitha_4214@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOn Action with facilities as "FacilityName"
   Then AddDepartment
   Then ClickOnAdoptFacility
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "FacilityName"
   Then NevigateToConsentTraining
   Then FacilityAndEquipment
   Then Logout from SipApplication
   


   Then Close the browser
   
  
  

 