@19328
Feature: 19328
  
  Scenario: 19328
  
   Given Open browser and launch SIPUrl
   When Application homepage is open
   Then Enter_Application_With_Bypass_Login_SponsorUser 1
   Then Verify Sponsor Logo Is Displayed
   Then Verify SEARCH BY Dropdown Is Displayed With Option
   Then Click On Facility/Department Option From SEARCH BY Dropdown
   Then Verify Facility/Department Search Screen Is Displayed
   Then Click On SEARCH BY Dropdown
   Then Click On PRINCIPAL INVESTIGATOR Option From SEARCH BY Dropdown
   Then Verify PRINCIPAL INVESTIGATOR Screen Is Displayed
   Then Click On SEARCH BY Dropdown
   Then Click On User/Facility Option From SEARCH BY Dropdown
   Then Verify User/Facility Search Screen Is Displayed
   Then Click On SIP Logo
   Then Verify VIEW ALL Options Under RECENT STUDIES Section
   Then Verify SET FAVOURITES Options Under FAVORITES Section
   Then Verify Favourite Studies Under FAVORITES Section
   Then Click On SET FAVOURITES Options Under FAVORITES Section
   Then Verify View All Workspaces Screen Is Displayed
   Then Verify Favourite Marked Studies Are Displayed
   Then Click On SIP Logo
   Then Verify Recently Viewed Studies Displayed Under RECENT STUDIES Section
   Then Click On VIEW ALL Options Under RECENT STUDIES Section
   Then Verify View All Workspaces Screen Is Displayed
   Then Verify LINKS Section In Sponsor Home Screen
   Then Verify Links Under LINKS Section In Sponsor Home Screen
   Then Click On Any Links Under LINKS Section In Sponsor Home Screen
   Then Verify Link URL Is Displayed
   Then Logout from SipApplication
   Then Close the browser