@5055
Feature: 5055
  
  Scenario: 5055
 
   Given Open browser and launch SIPUrl
   Then Application homepage is open
   Then enter_to_the_application_with_bypaas_loginone
   Then verifygcpsection
   Then verifygcponscreenwithyesno
   Then verifyradio
   Then selectradiono
   Then verifygcpgreentick
   Then verifynotifications
   Then navgatetomyprofile
   Then generateCVButton1
   #Then Logout 
   Then Close the browser