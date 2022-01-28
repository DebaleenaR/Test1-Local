@22526
Feature: 22526
  
  Scenario: 22526
  
   #Given Open browser and launch SIPUrl
   #When Application homepage is open
   #Then Enter_Application_With_Bypass_Login_Siteuser 1
   #Then Navigate To Admin > View and Manage Delegation of Site Users
   #Then Verify View and Manage Delegation on behalf of Site Users Screen Displayed
   #Then Select "50" From Show Dropdown In View and Manage Delegation on behalf of Site Users Screen
   #Then Verify Site User 2 Displayed In View and Manage Delegation of Site Users Screen
   #Then Verify Site User 3 Displayed In View and Manage Delegation of Site Users Screen
   #Then Verify Site User 4 Displayed In View and Manage Delegation of Site Users Screen
   #Then Verify Site User 5 Displayed In View and Manage Delegation of Site Users Screen
   #Then Verify Site User 6 Displayed In View and Manage Delegation of Site Users Screen
   #Then Click On View/Manage Delegation For Site User 2
   #Then Verify Manage Delegation on behalf of Site User 2 Screen Displayed
   #Then Verify User Profile Section Displayed Under Manage Delegation on behalf of Site User Screen
   #Then Verify Survey Section Displayed Under Manage Delegation on behalf of Site User Screen
   #Then Verify Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   #Then Verify Safety Contact & Regulatory Contact (PI Delegate) Section Displayed Under Manage Delegation on behalf of Site User Screen
   #Then Click On Study Site Profile Maintenance Section Displayed Under Manage Delegation on behalf of Site User Screen
   #Then Verify No Delegate Message Displayed Under STUDY SITE MAINTENANCE DELEGATES In Delegate Study Sites Screen
   #Then Verify CURRENT STUDY SITE DELEGATES Table In Delegate Study Sites Screen
   #Then Verify Site User 3 For Study 1 Is Displayed In CURRENT STUDY SITE DELEGATES Table
   #Then Verify Site User 3 For Study 1 Has End Date As Blank In CURRENT STUDY SITE DELEGATES Table
   #Then Verify Site User 3 For Study 1 Has Start Date As Past Date In CURRENT STUDY SITE DELEGATES Table
   
   #Then Verify Site User 4 For Study 1 Is Displayed In CURRENT STUDY SITE DELEGATES Table
   #Then Verify Site User 4 For Study 1 Has End Date As Blank In CURRENT STUDY SITE DELEGATES Table
   #Then Verify Site User 4 For Study 1 Has Start Date As Future Date In CURRENT STUDY SITE DELEGATES Table
   
   #Then Verify Site User 5 For Study 1 Is Displayed In CURRENT STUDY SITE DELEGATES Table
   #Then Verify Site User 5 For Study 1 Has End Date As Future Date In CURRENT STUDY SITE DELEGATES Table
   #Then Verify Site User 5 For Study 1 Has Start Date As Current Date In CURRENT STUDY SITE DELEGATES Table
   
   #Then Verify Site User 6 For Study 1 Is Not Displayed In CURRENT STUDY SITE DELEGATES Table
   #Then Click Edit Under Site User 3 For Study 1 Is Displayed In CURRENT STUDY SITE DELEGATES Table
   #Then Verify And Click On DatePicker of End Date In CURRENT STUDY SITE DELEGATES Table For Site User 3 For Study 1
   
   #Then Select Current Date In End Date In CURRENT STUDY SITE DELEGATES Table For Site User 3 For Study 1
   #Then Click Save For Site User 3 For Study 1 Is Displayed In CURRENT STUDY SITE DELEGATES Table
   #Then Verify End Study Site Delegation PopUp
   #Then Click On END THIS STUDY SITE DELEGATION Button In End Study Site Delegation PopUp
   #Then Verify Site User 3 For Study 1 Is Not Displayed In CURRENT STUDY SITE DELEGATES Table
   
   #Then Click Edit Under Site User 5 For Study 1 Is Displayed In CURRENT STUDY SITE DELEGATES Table
   #Then Verify And Click On DatePicker of End Date In CURRENT STUDY SITE DELEGATES Table For Site User 5 For Study 1
   #Then Select Future Date In End Date In CURRENT STUDY SITE DELEGATES Table For Site User 5 For Study 1
   #Then Click Save For Site User 5 For Study 1 Is Displayed In CURRENT STUDY SITE DELEGATES Table
   #Then Verify End Study Site Delegation PopUp
   #Then Click On END THIS STUDY SITE DELEGATION Button In End Study Site Delegation PopUp
   #Then Verify Site User 5 For Study 1 Has End Date As Future Date In CURRENT STUDY SITE DELEGATES Table
   
   #Then Switch To Parent Window And Logout from SipApplication
   #Then Close the browser
   
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_Siteuser 2
   Then Site User Navigate To View All Workspaces
   Then Site User Navigate To Study 1
   Then Site User Click On Study Site Profile Tab
   Then Site User Click On Site Staff
   Then Verify Site User 3 Is Displayed With Date role ended in SIP As Current Date
   Then Verify Site User 6 Is Displayed With Date role ended in SIP As Current Date
   Then Verify Site User 4 Is Displayed With Date role ended in SIP As Blank
   Then Verify Site User 5 Is Displayed With Date role ended in SIP As Future Date
   Then Logout from SipApplication
   Then Close the browser
   