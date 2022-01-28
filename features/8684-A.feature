@8684-A
Feature: 8684-A
 
  
  Scenario: 8684-A
  


   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "CurieSponsorDocAdmin1_RS@franklin-member-id0" bypass login 
   Then NavigatetoSponserSearchfacility
   Then EnterSponserCountry
   Then CheckFacility as "FacilityName"
   Then CheckFacility as "FacilityName2"
   Then ExportFacilitySearchIntoPDF
   Then Logout from SipApplication
   

   

   