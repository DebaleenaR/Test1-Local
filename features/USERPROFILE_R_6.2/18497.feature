@18497
Feature: 18497
 
  
  Scenario: 18497
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "spadmin1@curie-member-id0" bypass login  
   Then HoverOverUserProfile
   Then Navigateuserprofile_MyProfile_Validate
   Then Click On Role Status DropDown
   Then SelectAllStatusUnderRoleDrowpDown
   Then ClickCross
   Then VerifyRolesInTable
   
   Then Click On Role Status DropDown
   Then SelectAllStatusUnderRoleDrowpDown
   Then SelectRoleStatus as "Active"
  Then ClickCross
  Then VerifyRolesInTable   
  Then VerifyEndDatedByColumnInTable
  Then VerifyStatusColumnInTable
  
  
   Then Click On Role Status DropDown
   Then SelectRoleStatus as "Active"
    Then SelectRoleStatus as "Inactive"
    Then ClickCross
    Then VerifyEndDatedByColumnInTable
  Then VerifyStatusColumnInTable
#   Then Close the browser
  