@8520
Feature: 8520
 
  
  Scenario: 8520
#  Login to SiteUserOne

   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then HoverOverTheHyperLink as "FacilityName"
   Then HoverOverTheHyperLink as "Facility+Department"
   
#   For Checking SiteUser2 As FPM And DPM

   Then ClickOnHyperlink as "FacilityName"
   Then NevigateToFacilityContact
   Then VerifyFacilityContactFPM
   
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then NevigateToDepartmentContact
   Then VerifyFacilityContactFPM
                                  #Same for Department Also                                 
   Then Logout from SipApplication
#     SiteUser1 loggout
     
# Help desk request  to remove SiteUser 2 "ronalc_3238@securepass.exostartest.com" 
     
#     Again SiteUser1 login 
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login 
   
#   Again For Checking SiteUser2

   Then NavigatetoMyfacility
    Then ClickOnHyperlink as "FacilityName"
   Then NevigateToFacilityContact
   Then VerifyFacilityContactFPM
   
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then NevigateToDepartmentContact
   Then VerifyFacilityContactFPM
   
#   For Checking SiteUser3 as bryantn_8460@securepass.exostartest.com

    Then NavigatetoMyfacility
    Then ClickOnHyperlink as "FacilityName"
   Then NevigateToFacilityContact
   Then VerifyFacilityDepartmentContact with "forsip2020+1010@gmail.com"
                                                                         #SiteUser3 should be present 
   Then Logout from SipApplication
#   SiteUser1 Logout



   
# Help Desk Request  to remove SiteUser 3 "bryantn_8460@securepass.exostartest.com" 




#     Again SiteUser1 login 
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login 
   
#   Again For Checking SiteUser3 as bryantn_8460@securepass.exostartest.com

    Then NavigatetoMyfacility
    Then ClickOnHyperlink as "FacilityName"
   Then NevigateToFacilityContact
   Then VerifyFacilityDepartmentContact with "forsip2020+1010@gmail.com"
                                                                        #SiteUser3 should not be present   
                                                                        
                                                                                                                                             
#   For Checking SiteUser4 as "lillytesting2019+235@gmail.com"
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then NevigateToDepartmentContact
   Then VerifyFacilityDepartmentContact with "lillytesting2019+235@gmail.com"
                                                                               #SiteUser4 should be present
    Then Logout from SipApplication                                                                            
                                       
                                       
                                                                               
# Help Desk Request  to remove SiteUser 4 "lillytesting2019+235@gmail.com"        
 
 
 
 
 #     Again SiteUser1 login 
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter to the application with "balls_9397@securepass.exostartest.com" bypass login 
   Then NavigatetoMyfacility
   Then HoverOverTheHyperLink as "FacilityName"
   Then HoverOverTheHyperLink as "Facility+Department"
   
   
# Nevigate to FacilitityCantact to check SiteUse 2 and Site User3   
   
   Then ClickOnHyperlink as "FacilityName"
   Then VerifyFacilityDepartmentContact with "soccer.siptest+0002@gmail.com"
   Then VerifyFacilityDepartmentContact with "forsip2020+1010@gmail.com"
                                                                         #SiteUser3 should not be present
   
   #   Again for Checking SiteUser4 as "lillytesting2019+235@gmail.com"
   
   Then NavigatetoMyfacility
   Then ClickOnHyperlink as "Facility+Department"
   Then NevigateToDepartmentContact
   Then VerifyFacilityDepartmentContact with "lillytesting2019+235@gmail.com"
                                                                              #SiteUser4 should not be present
    Then Logout from SipApplication                                                                             
#   
                                                                       
#   Then Close the browser

   
  
  

 