@7175
Feature: 7175
 
  
  Scenario: 7175
 
 
# Val2Environment
 
# LoginSiteUser2
 Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "tests_4991@securepass.exostartest.com" bypass login    
   Then NevigateToMyTaskPageAndVerify as "123"
   Then ClickOnUserProfileTaskTitle as "123"
   Then ClickOnRelaseTask
  Then Logout from SipApplication

 
 # LoginSiteUser1
 Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "123m_4858@securepass.exostartest.com" bypass login  
   Then Navigateuserprofile_MyProfile_Validate 
   Then ClickOnUndelegateButton
   Then ClickOnUnDelegateCancel
   
   Then ClickOnUndelegateButton
   Then ClickOnUndelegatedApproveRejectChange
   Then ClickOnRejectAll
   
   Then ClickOnUndelegateButton
   Then ClickOnUnDelegateCancelFirst
   Then ClickOnUndelegateButton
   Then RemoveDelegate
   Then VerifyOrganizationName
   
   Then verifymanagedelegationpage
     Then Logout from SipApplication
   
   
    Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "tests_4991@securepass.exostartest.com" bypass login    
   Then NevigateToMyTaskPageAndVerify as "123"
   Then clickonbell
   Then Logout from SipApplication