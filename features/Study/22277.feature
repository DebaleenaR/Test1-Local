@22277
Feature: 22277
  
  Scenario: 22277
  
   #Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 1
   #Then Site User Navigate To View All Workspaces
   #Then Site User Navigate To Study 1
   #Then Site User Click On Study Site Profile Tab
   #Then Site User Click On Site Staff
   #Then Verify Study Site Staff Screen Is Displayed For Site User
   
   #Then Verify Site User 1 Is Displayed As "Principal Investigator"
   #Then Verify Site User 2 Is Displayed As "Drug Shipment Contact"
   
   Then Site User Navigate To View All Workspaces
   Then Site User Navigate To Study 2
   Then Site User Click On Study Site Profile Tab
   Then Site User Click On Site Staff
   Then Verify Study Site Staff Screen Is Displayed For Site User
   
   #Then Verify Site User 1 Is Displayed As "Principal Investigator"
   #Then Verify Site User 2 Is Displayed As "Drug Shipment Contact"
   
   #Then Verify Remove Selected Site Staff Button Disabled
   #Then Select Checkbox Against Site User 2 Is Displayed As "Drug Shipment Contact"
   #Then Verify Remove Selected Site Staff Button Enabled
   
   #Then Click On Remove Selected Site Staff Button
   #Then Verify Remove Site Staff PopUp Displayed With Proceed And Cancel Button
   
   #Then Verify Proceed Button In Remove Site Staff PopUp Is Disabled
   #Then Select Current Date In Date role ended in SIP
   #Then Select Reason For Role End As "Role Changed" In Remove Site Staff PopUp
   #Then Verify Proceed Button In Remove Site Staff PopUp Is Enabled
   
   #Then Click On Proceed Button In Remove Site Staff PopUp
   #Then Verify Confirm Selected Site Staff for study access removal PopUp Displayed
   
   #Then Verify Site User 2 Name Is Displayed In Confirm Selected Site Staff for study access removal PopUp
   #Then Verify Site User 2 Email Is Displayed In Confirm Selected Site Staff for study access removal PopUp
   
   #Then Click On Submit Button In Confirm Selected Site Staff for study access removal PopUp
   #Then Verify Site User 2 Having Role As "Drug Shipment Contact" Is Role Ended
   #Then Verify Site User 2 Having Role As "Drug Shipment Contact" CheckBox Disabled
   
   Then Click On Copy Site Staff Button In Study Site Staff Screen for Site User
   #Then Verify Copy Study Site Profile Screen In Study Site Staff Screen for Site User
   #Then Verify Search Study Site Profiles In Study Site Staff Screen for Site User
   
   Then Select Sponsor 1 From Sponsor/CRO Dropdown
   Then Select Study Type For Study 1 From Study Type Dropdown
   Then Select Study 1 From Study ID Dropdown
   Then Click On Search Button Under Search Study Site Profiles Section
   Then Verify Study 1 Is Displayed Under Search Study Site Profiles Section
   Then Verify Site User 1 Is Displayed Under Search Study Site Profiles Section
   
   Then Select Site User 1 From Search Study Site Profiles Section
   Then Click On SELECT STUDY SITE PROFILE Button
   Then Select Site User 2 From Select Site Staff To Copy Table
   Then Click On COPY SELECTED RECORD_S Button In Select Site Staff To Copy Section
   
   Then Click On OK Button In Study Site Staff Copied Successfully PopUp
   
   Then Verify Site User 2 Is Displayed As "Drug Shipment Contact" With Current Date
   
   Then Logout from SipApplication
   Then Close the browser