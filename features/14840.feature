@14840 
Feature: 14840 


Scenario: 14840 

	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "spadmin1@curie-member-id0" bypass login 
	Then Select_FacilityDepartment_From_SearchBy 
	Then EnterSponserCountry as "Afghanistan" 
	Then ClickPlusIcon 
	Then EnterSponserCountry as "Australia" 
	
	
	
	Then NavigatetoSponserSearchfacility 
	Then EnterSponserCountryAndState as "Australia" and "New South Wales" 
	Then ClickPlusIcon 
	Then EnterSponserCountryAndFacility as "Australia" and "Carlton Family Medical" 
	Then ClickPlusIcon 
	Then EnterSponserCountryAndDepartmentType "Australia" and "Dermatology" 
	Then ClickPlusIcon 
	Then EnterSponserCountryStateCityAndDepartmentType 
	Then ClickPlusIcon 
	Then EnterSponserCountryTA_SubTA_Phase_StydyType 
	Then ClickPlusIcon 
	Then EnterSponserCountryAndFacility as "Australia" and "Carlton Family Medical" 
	
