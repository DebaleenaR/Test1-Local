@13989
Feature: 13989
 
  
  Scenario: 13989


# SuteUser Login 
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "ghosht_8706@securepass.exostartest.com" bypass login
   Then NavigatetoMyfacility
    Then ClickOnHyperlink as "FacilityName"
    Then NevigateToDepartmentContact
    Then ClickOnAddFacilityContact
    Then SelectFacilityandsearch as "FacilityName"
###                                    Department Or Facility Contact section are same
  Then ClickOnDepartmentContactSearch    
  #                                    Department Or Facility Contact section are same
    
    
    Then ClickOnRadiobuttonAndSelectFacilityContact
    Then SelectRoleFromFacilityContact
    Then SelectSaveUnderFacilityContact
    Then ScrolldownForVerify
   Then Logout from SipApplication
#   Logout From siteUser
   
   
   


   
   
   
   


  
#   
#   Then Close the browser
   
  
  

 