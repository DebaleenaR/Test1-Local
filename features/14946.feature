@14946
Feature: 14946
 
  
  Scenario: 14946
# SuteUser Login 
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "smitha_4214@securepass.exostartest.com" bypass login
   Then Navigatetosearchfacilityandverify
   Then EnterCountryStateAndCity
   Then ClickOnCancelButtonToNevigateBackAndVerify
   Then EnterCountry as "CountryField" and Facility as "FacilityName" and Search
   Then NavigatetoMyfacility
   Then ClickOnAddFacilityAndVerifyFacility
    Then EnterCountry as "CountryField" and Facility as "FacilityName" and Search
    Then Select Facility as "FacilityName" and ClickAddFacilityToYourUser
    Then Click IWillMaintainTheFacilityProfile And VerifyPage
    Then Logout from SipApplication
    
#    Sponser Admin login
     Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "spadmin1@curie-member-id0" bypass login
   Then NavigatetoSponserSearchfacility
   Then EnterSponserCountryStateAndCity
   Then NevigateToSponserSearchFacility
   Then EnterSponserCountryAndFacilityName
   Then NevigateToSponserSearchFacility
   Then EnterSponserCountryAndSIPID
   Then Logout from SipApplication

#   CRO Login

 Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "jupiter.cro@venus-member-id0" bypass login
   Then NavigatetoSponserSearchfacility
   Then EnterSponserCountryStateAndCity
   Then NevigateToSponserSearchFacility
   Then EnterSponserCountryAndFacilityName
   Then NevigateToSponserSearchFacility
   Then EnterSponserCountryAndSIPID
   Then Logout from SipApplication


#  Notes-At the time of execution Use Brazil,Sao paulo-Not used golden facilty and update details on execl accordingly 
   