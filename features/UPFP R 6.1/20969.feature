@20969 
Feature: 20969 

Scenario: 20969 

	Given Open browser and launch SIPUrl 
	Then Application homepage is open 
	Then Enter to the application with "CurieSponsorDocAdmin1_RS@franklin-member-id0" bypass login 
	#   Then NavigatetoMyfacility
	Then NavigatetoSponserSearchfacility 
	Then EnterSponserCountry 
	Then CheckFacility as "FacilityName2" and ClickViewDepartment
	
#	Department1
	Then ClickOnDepartment1
	Then switchTab_Verify_CloseNewTab
	
#	Department2
	Then ClickOnDepartment2
	Then switchTab_Verify_CloseNewTab
	
	
	 Then Navigate_reports
   Then facilitydepartmentcapabilitycomparisonreport
   Then selectcountry1
   Then selectallcheckbox
   Then select12record
   Then clickonvewselectionandverify
   Then clickoncompare
	Then SelectAll
	#Then Logout 
#	Then Close the browser 
	
	
	
  