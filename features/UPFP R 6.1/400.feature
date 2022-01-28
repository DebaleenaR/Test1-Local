@400
Feature: 400
  
  Scenario: 400
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifygeneratecv
   Then verifyleftpanelincomplete
   Then verifyfacilitymentionedfields
   Then verifyeducationdetails
   Then verifynotapplicableineducation
   Then verifynotapplicableinmedical
   Then verifynotapplicableprofessionalexp
   Then verifyprofessionalexpgreen
   Then verifyresearchexp1
   Then verifynotdisappear
   Then verifyresearchgreentick
   Then verifygcpgreentick
   Then verifyliceseddetails
   Then verifylicesedetailspopup
   Then verifygeneratecvenable
   Then verifyprofileattchement
   Then verifypublicationpresentation
   #Then Logout 
   Then Close the browser
  