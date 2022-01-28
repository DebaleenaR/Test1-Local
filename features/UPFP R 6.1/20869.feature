@20869
Feature: 20869
  
  Scenario: 20869
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "FranklinStudyAdminRed01@franklin-member-id0" bypass login 
   Then Navigate_reports
   Then facilitydepartmentcapabilitycomparisonreport
   Then selectcountry1
   Then selectallcheckbox
   Then select12record
   Then clickonvewselectionandverify
   Then clickoncompare
   Then Logout from SipApplication
#   Then Close the browser
   
   
   
  