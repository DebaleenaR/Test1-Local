@14025-2
Feature: 14025-2
 
  
  Scenario: 14025-2
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login 

#   For PDF download
   Then NevigateToMyTaskAndVerify
   Then ClickTheLinkForDownload
   Then clickonhome 
   
   
#   For Doc download
     Then NevigateToMyTaskAndVerify
     Then ClickTheLinkForDownload
     Then clickonhome 
   Then Logout from SipApplication
   


#   Then Close the browser
   
  
  

 