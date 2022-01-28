@21571 
Feature: 21571 


Scenario: 21571 

	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "limbadl_4646@securepass.exostartest.com" bypass login 
	Then NavigatetoMyfacility 
	
	Then ClickOnHyperlink as "FacilityName" 
	Then NevigateToAssociatedSiteUserSection 
	Then VerifyAssociatedSiteUserTables 
	Then VerifyTable1 
	Then VerifyTable2 
	Then ViewAssociatedDepartment 
	Then VerifyRemoveUserBtn 
	Then RemoveSiteUser 
	
	
	Then Logout from SipApplication
	#   Then Close the browser
	
	
	
	
 