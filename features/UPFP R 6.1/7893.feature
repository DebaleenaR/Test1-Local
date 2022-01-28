@7893
Feature: 7893
  
  Scenario: 7893
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then Navigateuserprofile_MyProfile_Validate
   Then Generatecvbutton
   Then clickonhome
   Then Navigateuserprofile_MyProfile_Validate
   Then Verifybasicdetails
   Then Verifyfacilitysection
   Then verifyeducationsectiondisplayed
   Then verifynotapplicableprofessionalexp
   Then verifyresearchgreentick
   Then verifygcpgreentick
   Then verifyliceseddetails
   Then verifyprofileattahments
   Then verifypublicatonpresentationsort
   #Then Logout 
   Then Close the browser