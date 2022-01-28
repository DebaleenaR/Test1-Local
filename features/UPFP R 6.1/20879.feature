@20879
Feature: 20879 

Scenario: 20879 

	Given Open browser and launch SIPUrl 
	Then Application homepage is open 
	Then Enter to the application with "curieabsc@curie-member-id0" bypass login 
	Then NavigatetoSponserSearchfacility 
	Then EnterSponserCountry 
	

	
	Then ClickOnFacilityHyperlinkOnSearch as "FacilityName"
	Then switchTab_Verify_CloseNewTab
	
	Then ClickOnFacilityHyperlinkOnSearch as "FacilityName2"
	Then switchTab_Verify_CloseNewTab

#	
#	
	 Then Navigate_reports
   Then facilitydepartmentcapabilitycomparisonreport
   Then selectcountry1
#   Then selectallcheckbox
   Then select_1_5_record
   Then clickonvewselectionandverify
   Then clickoncompare
	Then SelectAll
	#Then Logout 
#	Then Close the browser 
	
	
	
  