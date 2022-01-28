@10564
Feature: 10564
 
  
  Scenario: 10564
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "smitha_4214@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "FacilityName"
   Then ClickOnSIPFacilityProfileButton
    Then SwitchTabandCloseNewtab
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then ClickAdoptFacilityAndDepartment
   Then SelectAdoptfacilityAndClickAdoptprofile as "FacilityName2"
   Then clickOkandVerify
    Then ClickOnHyperlink as "Facility+Department"
    Then SwitchTab
    Then Logout from SipApplication
  
   


#   Then Close the browser
   
  
  

 