@11134
Feature: 11134
 
  
  Scenario: 11134
  
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "smitha_4214@securepass.exostartest.com" bypass login
   Then Navigatetosearchfacilityandverify
   Then EnterCountry as "CountryField" and State as "State" and Search
#   Then VerifyFacilityOrDepartmentColumnForSorting
   Then ClickonFacilitySort


   Then ClickonCitySort
##For ascending
   Then ClickonCitySort
##For decending

   Then ClickOnStateSort
##For ascending
   Then ClickOnStateSort
##For decending



Then ClickOnCancelButtonToNevigateBackAndVerify
Then EnterSiteUserCountryStateCityFacility
Then Select Facility as "FacilityName2" and ClickAddFacilityToYourUser
Then VerifyFacilityOrDepartmentColumnForSorting
Then ClickOnDepartmentSort

Then ClickOnDepartmentCitySort
#For ascending
Then ClickOnDepartmentCitySort
#For decending

Then ClickOnDepartmentStateSort
#For ascending
Then ClickOnDepartmentStateSort
#For decending

Then Logout from SipApplication
##logout from SiteUser


#   CRO login
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "jupiter.cro@venus-member-id0" bypass login 
   Then NavigatetoSponserSearchfacility
   Then EnterSponserCountry
#   Then VerifySponserFacilityOrDepartmentColumnForSorting
   Then ClickonFacilitySort

   Then ClickonCitySort
##For ascending
   Then ClickonCitySort
##For decending

   Then ClickOnStateSort
##For ascending
   Then ClickOnStateSort
##For decending

Then ClickonFacilitySort
Then CheckFacility as "FacilityName2" and ClickViewDepartment
Then ScrolldownToClickonButton
Then ClickOnDepartmentSort

Then ClickOnDepartmentCitySort
#For ascending
Then ClickOnDepartmentCitySort
#For decending

Then ClickOnDepartmentStateSort
#For ascending
Then ClickOnDepartmentStateSort
#For decending
Then Logout from SipApplication
   