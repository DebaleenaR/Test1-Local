@20920
Feature: 20920
 
  
  Scenario: 20920
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "spadmin1@curie-member-id0" bypass login  
   Then NavigateToAuditTrail
   Then SelectUserAndFacilityDocumentUnderAuditTrail
   Then FillDetailsUnderAudittrail
   Then GenerateReport
   Then Logout from SipApplication
   
   #Then Logout 
#   Then Close the browser
  