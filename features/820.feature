@820 
Feature: 820 


Scenario: 820 
#  Login to SiteUserOne

   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "limbadl_4646@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then Verify Facility/Department Fields
   Then Update Department Details
   Then clickonhome
   
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then Verify Facility/Department Fields
   Then Logout from SipApplication

    #  LoginSiteUser5
	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "pollardc_1356@securepass.exostartest.com" bypass login 
	Then NavigatetoMyfacility 
	Then ClickOn Action with facilities as "FacilityName" 
	Then AddDepartmentFromActionOnly 
	Then Verify AddDepartment Page 
	Then Click on Contact DPM link of Department as "Departmentt" 
	Then Click on SendMessage 
	Then Write Message 
	Then Click on SendMessage 
	Then Verify SendMessage PopUp 
	Then clickonbell 
	Then Logout from SipApplication 
	
	
	#   LoginSiteUser1
	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "limbadl_4646@securepass.exostartest.com" bypass login 
	Then clickonbell 
	Then Logout from SipApplication 
	
	
	#   LoginSiteUser2
	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "smitha_4214@securepass.exostartest.com" bypass login 
	Then clickonbell 
	Then Logout from SipApplication 
	
	#   LoginSiteUser3
	
	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "bravor_1962@securepass.exostartest.com" bypass login 
	Then clickonbell 
	Then Logout from SipApplication 
	
	
	#   LoginSiteUser4
	
	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "tuckera_0783@securepass.exostartest.com" bypass login 
	Then clickonbell 
	Then Logout from SipApplication 
	
	
	#   AgainLoginSiteUser5
	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "limbadl_4646@securepass.exostartest.com" bypass login 
	Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then NevigateToDepartmentContact
   Then Change The Primary DPM as "anirbantesting+64674747@gmail.com"
   Then Change The Primary DPM as "anirbantesting+64674747@gmail.com"
   Then Logout from SipApplication 
   
#   AgainLoginSiteUser5
   
   	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "pollardc_1356@securepass.exostartest.com" bypass login 
	Then NavigatetoMyfacility 
	Then ClickOn Action with facilities as "FacilityName" 
	Then AddDepartmentFromActionOnly 
	Then Verify AddDepartment Page 
	Then Click on Contact DPM link of Department as "Departmentt" 
	Then Write Message 
	Then Click on SendMessage 
   Then Verify SendMessage PopUp 
   Then Logout from SipApplication 
   
   
   #   LoginSiteUser2
	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "smitha_4214@securepass.exostartest.com" bypass login 
	Then clickonbell 
	Then Logout from SipApplication 
	
	
	#	#   LoginSiteUser1
	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "limbadl_4646@securepass.exostartest.com" bypass login 
	Then clickonbell 
	Then Logout from SipApplication 
	
	
	#	#   LoginSiteUser3
	
	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "bravor_1962@securepass.exostartest.com" bypass login 
	Then clickonbell 
	Then Logout from SipApplication 
	
	
	#	#   LoginSiteUser4
	
	Given Open browser and launch SIPUrl 
	When Application homepage is open 
	Then Enter to the application with "tuckera_0783@securepass.exostartest.com" bypass login 
	Then clickonbell 
	Then Logout from SipApplication 
	