@17307
Feature: 17307
 
  
  Scenario: 17307
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "tuckera_0783@securepass.exostartest.com" bypass login   
   Then NavigateToMyProfileFacilitiesAndVerify

   Then ClickOnHyperlink as "Facility+Department"
   Then NevigateToInvestigationalProduct
   
#   For Error message verify
   Then Save Shipping Address
   Then Click OK for Shipping Address PopUp
   
   Then Save Investigational Product Storage Location
    Then Click OK for Product Storage Location PopUp
    
    
#    For PopUp Verify
    Then Save Shipping Address
   Then Click OK for Shipping Address PopUp
   
   
   Then Save Investigational Product Storage Location
    Then Click OK for Product Storage Location PopUp
    
    
    Then Enter Invalid Special Character In Describe additional Investigational Product Storage Field
    Then Click OK For Special Character PopUp
    Then Logout from SipApplication

#   Then Close the browser
   
  
  

 