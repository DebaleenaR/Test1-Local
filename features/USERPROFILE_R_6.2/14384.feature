@14384
Feature: 14384
 
  
  Scenario: 14384
 
 
# Val2Environment
 
# LoginSiteUser2
 Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "SponsorAdminFranklinSP@franklin-member-id0" bypass login    
   Then Navigateuserprofile_MyProfile_Validate 
   Then Click_On_Edit_PhoneNumber
   Then UpdatePhoneNumber
   Then Logout from SipApplication

  