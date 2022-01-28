@504
Feature: 504
  
  Scenario: 504
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_logintwo
   Then Navigatetomyprofileandverify
   Then verifygcpgreentick
   Then verifysubmittrainingcreditrequest
   Then Navigatedtodelegatedprofile
   Then verifygcpgreentick
   Then verifysubmittrainingcreditrequest
   Then clickonsubmitcreditrequest
   Then AddCompletionDate "GCP" "ADAX International" "ICH E6 GCP Investigator Site Training - v1.0 - ADAX International"
   Then AddCompletionPage
   Then ChooseFileold
   Then ReviewAndSubmit
   Then SubmitCredits
   Then GoToMyCreditPage
   Then Close
   Then SelectSomeoneElse
   Then CourseNotListedbutton
   Then CourseNotListedpopup
   Then EnterCourseNotListedPage
   Then TrainingTypeStudyNotPresent
   Then TrainingTypeCROPresent
   Then TrainingTypeSelet
   Then SponsorCROSelect
   Then CRODisplay
   Then SubmitCourses
   Then AddCompletionDateUpdate
   Then ChooseFileUpdated
   Then ReviewandSubmitScreenVerification
   Then VerifytheRequestDisplayed
   #Then Logout 
   Then Close the browser
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   #Then Logout 
   Then Close the browser
   
   
   
   
  
 
   
   
   
   
  
  
   	
   
   
   
   
  
    
   
 
  
   
  
   
  
  