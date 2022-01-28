@14321
Feature: 14321
 
  
  Scenario: 14321
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "hudsonj_8300@securepass.exostartest.com" bypass login   
   Then navigatetodelegatedprofiles
   Then verifyfacilitysections
   Then VerifyFacilityIdAndDepartmentId
   Then ClickOnAddfacility
   Then EnterCountry as "CountryField2" and Facility as "FacilityName2" and Search
   Then Select Facility as "FacilityName2" and ClickAddFacilityToYourUser
   Then VerifyAddDeparmentPage
   Then Select Department as "Department2" and ClickAddDeparmentToYourUser
   Then VerifyFacilityIdAndDepartmentId2
   Then ClickOnSendAllChangesForApprovelButton
   Then Logout from SipApplication
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "ghosht_8706@securepass.exostartest.com" bypass login  
   Then NevigateToApproveRejectUpdates
   Then verifyfacilitysections
   Then ClickOnApproveTheChange
   Then VerifyFacilityIdAndDepartmentId2
   Then Logout from SipApplication
   #Then Logout
   Then Close the browser
   
  
  

 