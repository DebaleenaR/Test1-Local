@5754
Feature: 5754
 
  
  Scenario: 5754
# SuteUser Login 
    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "gomezl_6590@securepass.exostartest.com" bypass login
   Then Navigatetosearchfacilityandverify
   Then EnterCountry as "CountryField" and Facility as "FacilityName" and Search
   Then Select Facility as "FacilityName" and ClickAddFacilityToYourUser
   Then ClickOnOkForFacilityAlreadyAdded
   


#for method checking
#   Then NavigatetoMyfacility
#   Then ClickOn Action with facilities as "FacilityName"
#   Then AddDepartmentFromActionOnly


   Then ClickOnCreatNewDepartment
   Then EnterDepartmentTypeAndNameUnderCreatNewDepartment
   Then ClickOnIwillAssignSomeOneElse
   Then EnterEmailAddressToSearch as "lillytesting2019+244@gmail.com" 
   Then ClickOnDepartmentContactSearch

   Then ClickOnRadiobuttonAndSelectDepartmentContact
   Then ClickOnCountinueUpdating

   Then VerifyPopulatedDepartmentProfile
   Then ClickOnUploadSIPDocument
   Then ClickOnCancelOfSIPdocument
   Then VerifyPopulatedDepartmentProfile
   Then ClickOnUploadSIPDocument
#   Then ClickOnDownloadLink

   
    Then BrowseFile and VerifyUploadButton as "EmptyDoc"
   Then ClickOnUploadButtonandVerify
   Then ClickOKOnErrormsg
   
   Then BrowseFile and VerifyUploadButton as "DocPath1"
   Then ClickOnUploadButtonandVerify
   Then ClickOKOnErrormsg
   
   
   Then BrowseFile and VerifyUploadButton as "DocPath2"
   Then ClickOnUploadButtonandVerify
   Then ClickOKOnErrormsg
   
   Then BrowseFile and VerifyUploadButton as "DocPath3"
   Then ClickOnUploadButtonandVerify
   Then ClickOKOnErrormsg
   
   Then BrowseFile and VerifyUploadButton as "DocPath4"
   Then ClickOnUploadButtonandVerify
   Then ClickOKOnErrormsg 
   
#   Open SIP Department Profile and Enter all data
   
   Then BrowseFile and VerifyUploadButton as "FinalDoc"
   Then ClickOnUploadButtonandVerify
   Then ClickOKOnErrormsg
   
   
   
   
    
   Then HoverOverTheHyperLink as "Facility+Department"
   Then Logout from SipApplication
   


#   Then Logout from SipApplication


   