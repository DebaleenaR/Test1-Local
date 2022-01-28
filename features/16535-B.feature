@16535-B 
Feature: 16535-B 


Scenario: 16535-B 


#In this One adDress is already Fill
# SuteUser Login 
	Given Open browser and launch SIPUrl 
	Then Application homepage is open 
	Then Enter to the application with "bravor_1962@securepass.exostartest.com" bypass login 
	
	Then NavigatetoMyfacility 
	Then ClickOnHyperlink as "FacilityName" 
	Then NevigateToInvestigationalProduct 
	
#	Address2
	
	Then Click_On_ADDSHIPPINGLOCATIONButton 
	Then Save Shipping Address 
	Then Click OK for Shipping Address PopUp 
	Then Click On Country DropDown Under INVESTIGATIONAL PRODUCT SHIPPING DETAILS 
	Then Click On State DropDown Under INVESTIGATIONAL PRODUCT SHIPPING DETAILS 
	Then Enter Invalid Email 
	Then Enter Valid Email 
	Then Enter Data in Remaining Fields 
	Then Verify Add Shipping Location Button is disable 
	Then EnterIPRecipientName as "Umar Mukhtar" 
	Then Save Shipping Address 
	Then Click OK for Shipping Address PopUp 
	
	
#	Address3
	
	Then Click_On_ADDSHIPPINGLOCATIONButton 
	Then Save Shipping Address 
	Then Click OK for Shipping Address PopUp 
	Then Click On Country DropDown Under INVESTIGATIONAL PRODUCT SHIPPING DETAILS 
	Then Click On State DropDown Under INVESTIGATIONAL PRODUCT SHIPPING DETAILS 
	Then Enter Invalid Email 
	Then Enter Valid Email 
	Then Enter Data in Remaining Fields 
	Then Verify Add Shipping Location Button is disable 
	Then EnterIPRecipientName as "Umar Mukhtar" 
	Then Save Shipping Address 
	Then Click OK for Shipping Address PopUp 
	
	Then EnterIPRecipientName as "Tanveer" 
	Then Save Shipping Address 
	Then Click OK for Shipping Address PopUp 
	
	Then Click_On_PlusTcon_To_Verify_Details3 
	Then Click_On_PlusTcon_To_Verify_Details1 
	
	
	Then ClickOnRemoveShippingAddress1 
	Then ClickOnCancelOfRemoveShippingAddress1 
	


#	Details1 =Details2
	Then Click_On_PlusTcon_To_Verify_Details1 
	Then ClickOnRemoveShippingAddress2 
	Then ClickOnOKOfRemoveShippingAddress3 
	
	
	
	Then Click_On_ADDSHIPPINGLOCATIONButton 
	Then Click On Country DropDown Under INVESTIGATIONAL PRODUCT SHIPPING DETAILS 
	Then Click On State DropDown Under INVESTIGATIONAL PRODUCT SHIPPING DETAILS 
	Then Enter Valid Email 
	Then Enter Data in Remaining Fields 
	Then EnterIPRecipientName as "Umar Mukhtar" 
	Then Save Shipping Address 
	Then Click OK for Shipping Address PopUp 
	
    Then Logout from SipApplication
	
	
	
	
	
	
	
	
	
	
	
	
	
   