@16719 
Feature: 16719 


Scenario: 16719 

    Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then Enter to the application with "sanderb_4530@securepass.exostartest.com" bypass login
   Then Navigatetoorganizationandverify
   Then Click On Hyperlink of organization as "DS_ORG 3"
   Then Nevigate Facility/Department Affiliations section
   Then verify Facility
	Then NavigatetoMyfacility 
	Then ClickOn Action with facilities as "FacilityName" 
	Then AddDepartmentFromActionOnly 
	   Then Logout from SipApplication
	   
	   
	   
	    Given Open browser and launch SIPUrl
	   Then Application homepage is open
	   Then Enter to the application with "smitha_4214@securepass.exostartest.com" bypass login
	   Then NavigateToMyProfileFacilitiesAndVerify
	   Then ClickOnHyperlink as "FacilityName"
	   Then NevigateToFacilityContact
	   Then ClickOnAddFacilityContact
	   Then Add Site User as "sharmilaselvamani.sip+220@gmail.com" 
	   Then Select contact type as FPM
	   Then SelectSaveUnderFacilityContact
	   Then Logout from SipApplication
	   
	   
	
	Given Open browser and launch SIPUrl 
	Then Application homepage is open 
	Then Enter to the application with "sanderb_4530@securepass.exostartest.com" bypass login 
	Then Navigatetoorganizationandverify 
	Then Click On Hyperlink of organization as "DS_ORG 3" 
	Then Nevigate Facility/Department Affiliations section 
	Then verify Facility 
	Then NavigatetoMyfacility 
	Then ClickOn Action with facilities as "FacilityName" 
	Then AddDepartmentFromActionOnly 
	#always need to change index of this Xpth depands upon at which place facility is [3] 
	Then ClickOnCreatNewDepartment 
	Then EnterDepartmentTypeAndNameUnderCreatNewDepartment
    Then ClickI_WIL_MAINTAIN_THE_DEPARTMENT_PROFILE
    Then Go To myUserProfile
    Then clickonbell
	Then Logout from SipApplication
   