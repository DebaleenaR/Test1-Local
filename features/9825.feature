@9825
Feature: 9825
 
  
  Scenario: 9825
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "ronalc_3238@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOn Action with facilities as "FacilityName"
    Then AddDepartmentFromActionOnly
   #always need to change index of this Xpth depands upon at which place facility is [3] 
   
#   Then VerifyAddDeparmentPage

   Then ClickOnCreatNewDepartment
   Then EnterDepartmentTypeAndNameUnderCreatNewDepartment
   Then ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE And Countinue Updates
   Then Click EnterDepartmentManually
   Then Click OnAddDepartmentContact
   Then EnterEmailAddressToSearch as "soccer.siptest+0067@gmail.com"
   Then ClickOnClearSearch
   Then EnterEmailAddressToSearch as "soccer.siptest+0067@gmail.com"  
   Then ClickOnDepartmentContactSearch
   Then VerifySendRegistrationInvite
   Then ClickOnCancelNewRegistration
   Then ClickOnCancelFordepartmentContact
   
#   Nevigate To TherapeuticAreasPatientPopulation section
   Then NevigateToTherapeuticAreasPatientPopulation
   Then VerifyTherapeuticAreasAndClickDepartmentContact
   Then Click OnAddDepartmentContact
   Then EnterEmailAddressToSearch as "soccer.siptest+0067@gmail.com"
   Then ClickOnDepartmentContactSearch
   Then ClickOnSendRegistrationInvite
   Then ClickOKForConfirmation
   
#   ForSiteUser2
   Then Click OnAddDepartmentContact
   Then EnterEmailAddressToSearch as "forsip2020+1010@gmail.com"
   Then ClickOnDepartmentContactSearch
   Then SelectSiteUserForDepartmentContact With "Budget/Financial Contact"
                      
                      
#   ForSiteUser3                   
   Then Click OnAddDepartmentContact
   Then EnterEmailAddressToSearch as "soccer.siptest+0001@gmail.com"
   Then ClickOnDepartmentContactSearch
   Then SelectSiteUserForDepartmentContact With "Department Profile Manager"
   
#   Then ClickOnHyperlink as "Facility+Department"
#   Then NevigateToDepartmentContact
   
#   ManageContactDepartment
     Then ClickOnEditOfSiteUser with "soccer.siptest+0002@gmail.com" Email Id
    Then ClickOnCancelUnderEditDepartmentRole
     Then ClickOnEditOfSiteUser with "forsip2020+1010@gmail.com" Email Id
    Then selectDPMrole
    Then ClickonSaveUnderEditDepartmentRole
    Then ClickOnFlagOfSiteUserThree                               
    Then ClickOnEditOfSiteUser with "soccer.siptest+0002@gmail.com" Email Id
    Then DeselectDPMroleAndSelectContractManager
    Then ClickonSaveUnderEditDepartmentRole
    Then ClicKOKonWarning
    Then ClickOn Action with facilities as "Facility+Department"
    Then Logout from SipApplication
#   logout From SiteUser1


   # login to SiteUser2
   
    Given Open browser and launch SIPUrl
    When Application homepage is open
    Then Enter to the application with "bryantn_8460@securepass.exostartest.com" bypass login 
    Then clickonbell
    Then VerifyNotification

#  Remove User With soccer.siptest+0002@gmail.com

    Then NavigatetoMyfacility
    Then ClickOnHyperlink as "Facility+Department"
    Then NevigateToDepartmentContact
    Then RemoveSiteUserFromeDepartmentContact with "soccer.siptest+0002@gmail.com" Email Id
    Then ClicKOK
    Then ClickOnEditOfSiteUser with "forsip2020+1010@gmail.com" Email Id
     Then SelectBudget/FinancialContact
     
#Deselecting In actual                                         

     Then ClickonSaveUnderEditDepartmentRole
     Then clickonbell
     
     #  Remove User With forsip2020+1010@gmail.com
     
     Then NavigatetoMyfacility
    Then ClickOnHyperlink as "Facility+Department"
    Then NevigateToDepartmentContact
    Then RemoveSiteUserFromeDepartmentContact with "forsip2020+1010@gmail.com" Email Id
    Then ClicKOK
    
    
    Then ClickOnHyperlink as "Facility+Department"
#    Nevigate to NewTab
    Then SwitchTab
    Then Logout from SipApplication
    Then Close the browser
#    Logout From The SiteUser2
    
#    Login To SiteUser3 

    Given Open browser and launch SIPUrl
    When Application homepage is open
    Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login 
     Then NavigatetoMyfacility
    Then ClickOnHyperlink as "Facility+Department"
    Then NevigateToDepartmentContact
    Then Logout from SipApplication
     
#   Then Close the browser
   
  
  

 